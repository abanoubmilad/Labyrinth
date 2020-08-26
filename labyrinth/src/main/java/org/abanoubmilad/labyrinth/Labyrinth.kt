/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


class Labyrinth(private val builder: Builder) : INav {

    private var isTransactionExecuting = false
    private var shouldInterceptNavMenu = true

    init {
        builder.bottomNavigationView?.setOnNavigationItemSelectedListener {
            if (shouldInterceptNavMenu) {
                builder.viewModel.onMenuItemSelected(it.itemId)
            } else {
                true
            }
        }

        builder.viewModel.stackChanged.observe(builder.lifecycleOwner, Observer { stackTop ->
            commitFragment(stackTop)
            stackTop.executeIfAdded {
                (it as? NavFragment)?.onVisibleInternal()
            }

        })

        builder.viewModel.navTabSelected.observe(builder.lifecycleOwner, Observer {
            builder.onNavTabSelected?.invoke(it)
        })

        builder.viewModel.nonNavTabSelected.observe(builder.lifecycleOwner, Observer {
            builder.onNonNavTabSelected?.invoke(it)
        })

        builder.viewModel.selectedMenuId.observe(builder.lifecycleOwner, Observer {
            shouldInterceptNavMenu = false
            builder.bottomNavigationView?.selectedItemId = it
            shouldInterceptNavMenu = true

        })

        builder.viewModel.init(builder)
    }

    fun onDestroy() {
        builder.bottomNavigationView?.setOnNavigationItemSelectedListener(null)
        builder.bottomNavigationView = null
        builder.onNavTabSelected = null
        builder.onNonNavTabSelected = null
    }

    fun shouldCallSuperOnBackPressed(): Boolean {
        return builder.viewModel.onBackPressed()
    }

    private fun commitFragment(fragment: Fragment) {
        val transaction = builder.fragmentManager.beginTransaction()

        builder.fragmentManager.fragments.forEach { transaction.remove(it) }

        transaction.add(builder.fragmentContainerId, fragment)
        transaction.commit()

        executePendingTransactions()

    }

    private fun executePendingTransactions() {
        if (!isTransactionExecuting) {
            isTransactionExecuting = true
            builder.fragmentManager.executePendingTransactions()
            isTransactionExecuting = false
        }
    }


    /*
    *
    *
    *
    *
    *
    *                   INav implementation
    *
    *
    *
    *
    *
    * */


    override fun dismiss(clearAllTop: Boolean) {
        builder.viewModel.dismiss(clearAllTop)
    }

    override fun dismissThenNavigate(fragment: Fragment, bundle: Bundle?) {
        if (bundle != null)
            fragment.arguments = bundle
        builder.viewModel.popThenPush(fragment)
    }

    override fun navigate(fragment: Fragment, bundle: Bundle?) {
        if (bundle != null)
            fragment.arguments = bundle
        builder.viewModel.push(fragment)
    }

    override fun navigate(
        tabIndex: Int,
        clearAllTop: Boolean,
        fragmentToPush: Fragment?,
        bundle: Bundle?
    ) {
        if (bundle != null)
            fragmentToPush?.arguments = bundle

        builder.viewModel.selectTab(
            tabIndex,
            clearAllTop = clearAllTop,
            fragmentToPush = fragmentToPush
        )

    }


    override fun getCurrentFragment() = builder.viewModel.currentFragment
}