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
import org.abanoubmilad.labyrinth.labyrinth.SingleLiveEvent
import kotlin.math.min

class MultiStacksViewModel : ViewModel() {

    private val _stackChanged =
        SingleLiveEvent<Fragment>()
    val stackChanged: LiveData<Fragment> = _stackChanged


    private val _navTabSelected =
        SingleLiveEvent<Int>()
    val navTabSelected: LiveData<Int> = _navTabSelected

    private val _selectedMenuId =
        SingleLiveEvent<Int>()
    val selectedMenuId: LiveData<Int> = _selectedMenuId

    private val _nonNavTabSelected =
        SingleLiveEvent<Int>()
    val nonNavTabSelected: LiveData<Int> = _nonNavTabSelected

    var menuItemIdToRootTabFragmentIndexMap: HashMap<Int, Int> = hashMapOf()
        private set

    var fragmentStacks = mutableListOf<MutableList<Fragment>>()
        private set

    var resetOnSameTabClickEnabled = false

    var selectedTabIndex = 0
        private set

    var tabHistoryEnabled = false
        private set
    var tabsHistory = UniqueStack()
        private set

    var hasSavedState = false
        private set

    val currentStack
        get() = fragmentStacks[selectedTabIndex]


    val currentFragment
        get() = fragmentStacks[selectedTabIndex].last()


    val isCurrentFragmentRoot
        get() = fragmentStacks[selectedTabIndex].size == 1

    fun init(builder: Labyrinth.Builder) {
        if (hasSavedState) {
            _selectedMenuId.value = getMenuItemIdOfIndex(selectedTabIndex)
            _stackChanged.value = currentFragment
            return
        }

        fragmentStacks.clear()
        builder.rootTabFragmentsInitializer.forEach { fragmentStacks.add(mutableListOf(it())) }

        selectedTabIndex = builder.defaultSelectedTabIndex
        tabHistoryEnabled = builder.tabHistoryEnabled
        menuItemIdToRootTabFragmentIndexMap = builder.menuItemIdToRootTabFragmentIndexMap
        resetOnSameTabClickEnabled = builder.resetOnSameTabClickEnabled

        tabsHistory.clear()

        hasSavedState = builder.saveStateEnabled


        tabsHistory.push(selectedTabIndex)
        _selectedMenuId.value = getMenuItemIdOfIndex(selectedTabIndex)
        _stackChanged.value = currentFragment
    }

    fun selectTab(index: Int, clearAllTop: Boolean = false, fragmentToPush: Fragment? = null) {
        require(index >= 0 && index < fragmentStacks.size)
        { "Tab index should be in range [0, ${fragmentStacks.size - 1} but is $index]" }

        if (selectedTabIndex == index &&
            (isCurrentFragmentRoot || !clearAllTop)
        )
            return

        selectedTabIndex = index

        if (clearAllTop) {
            while (currentStack.size > 1)
                currentStack.removeAt(currentStack.size - 1)
        }

        fragmentToPush?.let {
            currentStack.add(it)
        }

        _selectedMenuId.value = getMenuItemIdOfIndex(index)
        _stackChanged.value = currentFragment


        tabsHistory.push(selectedTabIndex)
    }

    fun push(fragment: Fragment) {
        currentStack.add(fragment)
        _stackChanged.value = currentFragment
    }

    private fun pop(depth: Int) {
        require(depth >= 1) { "Pop depth should be greater than 0" }

        var toRemove = min(currentStack.size - 1, depth)

        if (toRemove <= 0) return
        while (toRemove-- > 0)
            currentStack.removeAt(currentStack.size - 1)

        _stackChanged.value = currentFragment

    }

    private fun clearCurrentStack() {
        if (currentStack.size <= 1) return
        pop(currentStack.size - 1)
    }

    fun onBackPressed(): Boolean {
        return if (isCurrentFragmentRoot) {
            when {
                !tabHistoryEnabled || tabsHistory.getSize() < 2 -> true
                else -> {
                    tabsHistory.pop()
                    tabsHistory.pop()?.let {
                        selectTab(it)
                    }
                    false
                }
            }
        } else {
            pop(1)
            false
        }
    }

    fun popThenPush(fragment: Fragment) {
        if (!isCurrentFragmentRoot) {
            currentStack.removeAt(currentStack.size - 1)
        }
        currentStack.add(fragment)
        _stackChanged.value = currentFragment
    }

    fun dismiss(clearAllTop: Boolean) {
        if (clearAllTop)
            clearCurrentStack()
        else
            pop(1)
    }

    private fun onNavTabClick(index: Int) {
        if (index == selectedTabIndex) {
            dismiss(clearAllTop = resetOnSameTabClickEnabled)
        } else {
            selectTab(index)
            _navTabSelected.value = index
        }
    }

    fun onMenuItemSelected(menuItemId: Int): Boolean {
        val targetIndex = menuItemIdToRootTabFragmentIndexMap[menuItemId]
        return if (targetIndex != null) {
            onNavTabClick(targetIndex)
            true
        } else {
            _nonNavTabSelected.value = menuItemId
            false
        }
    }

    private fun getMenuItemIdOfIndex(index: Int): Int? {
        return menuItemIdToRootTabFragmentIndexMap.filterValues { it == index }
            .keys.firstOrNull()
    }

}