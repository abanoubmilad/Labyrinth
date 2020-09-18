/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 6:14 PM
 *  * Last modified 8/15/20 6:14 PM
 *
 */

package org.abanoubmilad.labyrinth

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlin.math.min

class LabyrinthViewModelSingle : ViewModel() {

    private val _stackChanged =
        SingleLiveEvent<Fragment>()
    val stackChanged: LiveData<Fragment> = _stackChanged

    var currentStack = mutableListOf<FragmentWrapper<*>>()
        private set

    var hasSavedState = false
        private set

    val currentFragment
        get() = currentStack.lastOrNull()?.fetchFragment()


    val isCurrentFragmentRoot
        get() = currentStack.size == 1

    val stackIsEmpty
        get() = currentStack.size == 0

    private lateinit var builder: ILabyrinthConfigSingle

    fun init(builder: ILabyrinthConfigSingle) {
        if (hasSavedState) {
            currentFragment?.let {
                _stackChanged.value = it
            }
            return
        }
        this.builder = builder

        currentStack.clear()
        hasSavedState = builder.saveStateEnabled
    }

    private fun popCurrentStack() {
        currentStack.removeAt(currentStack.size - 1)
    }

    fun push(fragment: Fragment) {
        if (!stackIsEmpty && !builder.retainNonActiveFragmentsEnabled) {
            currentStack.lastOrNull()?.clearRetainedFragment()
        }
        currentStack.add(FragmentWrapper(fragment))
        _stackChanged.value = currentFragment
    }

    private fun pop(depth: Int) {
        require(depth >= 1) { "Pop depth should be greater than 0" }

        var toRemove = min(currentStack.size - 1, depth)

        if (toRemove <= 0) return
        while (toRemove-- > 0)
            popCurrentStack()

        _stackChanged.value = currentFragment

    }

    private fun clearCurrentStack() {
        if (currentStack.size <= 1) return
        pop(currentStack.size - 1)
    }

    fun onBackPressed(): Boolean {
        return if (stackIsEmpty || isCurrentFragmentRoot) {
            true
        } else {
            pop(1)
            false
        }
    }

    fun popThenPush(fragment: Fragment) {
        if (!stackIsEmpty) {
            popCurrentStack()
        }
        push(fragment)
    }

    fun dismiss(clearAllTop: Boolean) {
        if (clearAllTop)
            clearCurrentStack()
        else
            pop(1)
    }

}