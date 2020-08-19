/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.abanoubmilad.labyrinth.executeIfAdded


class Labyrinth(private val builder: Builder) : INav {

    class Builder(
        viewModelStoreOwner: ViewModelStoreOwner,
        val lifecycleOwner: LifecycleOwner,
        val fragmentManager: FragmentManager,
        @IdRes val fragmentContainerId: Int,
        var bottomNavigationView: BottomNavigationView?,
        val rootTabFragmentsInitializer: List<() -> Fragment>,
        val menuItemIdToRootTabFragmentIndexMap: HashMap<Int, Int>
    ) {

        var defaultSelectedTabIndex: Int = 0

        var resetOnSameTabClickEnabled: Boolean = true
        var saveStateEnabled: Boolean = false
        var tabHistoryEnabled: Boolean = true

        var onNavTabSelected: ((menItemId: Int) -> Unit)? = null
        var onNonNavTabSelected: ((menItemId: Int) -> Unit)? = null

        val viewModel: MultiStacksViewModel =
            ViewModelProvider(viewModelStoreOwner).get(MultiStacksViewModel::class.java)

        fun build() = Labyrinth(this)
    }

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