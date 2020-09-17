package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest38 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}
