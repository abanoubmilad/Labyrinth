/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 7:16 PM
 *  * Last modified 8/15/20 7:02 PM
 *
 */
package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import org.abanoubmilad.labyrinth.executeIfAdded


class LabyrinthSingle(private val builder: Builder) : INav {

    class Builder(
        val fragmentManager: FragmentManager,
        @IdRes val fragmentContainerId: Int
    ) {
        fun build() = LabyrinthSingle(this)
    }


    init {
        builder.fragmentManager.addOnBackStackChangedListener {
            getCurrentFragment()?.executeIfAdded {
                (it as? NavFragment)?.onVisibleInternal()
            }
        }
    }

    fun shouldCallSuperOnBackPressed(): Boolean {
        return if (builder.fragmentManager.backStackEntryCount > 0) {
            dismiss()
            false
        } else {
            true
        }
    }


    override fun dismiss(clearAllTop: Boolean) {
        var count = builder.fragmentManager.backStackEntryCount
        if (clearAllTop) {
            while (count > 0) {
                count--
                builder.fragmentManager.popBackStack()
            }
        } else if (count > 1) {
            builder.fragmentManager.popBackStack()
        }
    }

    override fun dismissThenNavigate(fragment: Fragment, bundle: Bundle?) {
        if (builder.fragmentManager.backStackEntryCount > 0) {
            builder.fragmentManager.popBackStack()
        }
        navigate(fragment, bundle)
    }

    override fun getCurrentFragment(): Fragment? {
        return builder.fragmentManager.fragments.lastOrNull()
    }


    override fun navigate(fragment: Fragment, bundle: Bundle?) {
        if (bundle != null)
            fragment.arguments = bundle
        builder.fragmentManager
            .beginTransaction().addToBackStack(null)
            .replace(builder.fragmentContainerId, fragment).commitAllowingStateLoss()
    }

    override fun navigate(
        tabIndex: Int,
        clearAllTop: Boolean,
        fragmentToPush: Fragment?,
        bundle: Bundle?
    ) {
        fragmentToPush?.let {
            navigate(fragmentToPush, bundle)
        }
    }


}
