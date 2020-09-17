package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest9 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}
