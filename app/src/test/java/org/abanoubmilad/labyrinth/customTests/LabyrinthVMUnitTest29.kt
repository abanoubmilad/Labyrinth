package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest29 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}
