/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 7:16 PM
 *  * Last modified 8/15/20 7:02 PM
 *
 */
package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


class LabyrinthSingle(private val builder: BuilderSingle) : INav {

    private var isTransactionExecuting = false

    init {

        builder.viewModel.stackChanged.observe(builder.lifecycleOwner, Observer { stackTop ->
            commitFragment(stackTop)
            stackTop.executeIfAdded {
                (it as? NavFragment)?.onVisibleInternal()
            }

        })

        builder.viewModel.init(builder)
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

    }


    override fun getCurrentFragment() = builder.viewModel.currentFragment
}