package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest35 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}
