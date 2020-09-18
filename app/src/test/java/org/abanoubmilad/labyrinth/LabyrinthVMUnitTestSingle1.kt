package org.abanoubmilad.labyrinth

import org.junit.Before


open class LabyrinthVMUnitTestSingle1 : LabyrinthVMUnitTestSingle() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveFragmentsEnabled = false
    }
}
