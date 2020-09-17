package org.abanoubmilad.labyrinth

import androidx.fragment.app.Fragment

interface ILabyrinthConfig {

    val rootTabFragmentsInitializer: List<() -> Fragment>
    val menuItemIdToRootTabFragmentIndexMap: HashMap<Int, Int>

    var defaultSelectedTabIndex: Int

    var resetOnSameTabClickEnabled: Boolean
    var saveStateEnabled: Boolean
    var retainNonActiveTabFragmentsEnabled: Boolean
    var tabHistoryEnabled: Boolean

}