package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest2 : LabyrinthVMUnitTest() {
 @Before
 override fun setUp() {
  super.setUp()
  iLabyrinthConfig.defaultSelectedTabIndex = 0
  iLabyrinthConfig.resetOnSameTabClickEnabled = true
  iLabyrinthConfig.saveStateEnabled = true
  iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
  iLabyrinthConfig.tabHistoryEnabled = false
 }
}
