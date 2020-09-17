//package org.abanoubmilad.labyrinth
//
//import org.junit.Before
//
//
//open class LabyrinthVMUnitTestCustom(
//    val defaultSelectedTabIndex: Int,
//    val resetOnSameTabClickEnabled: Boolean,
//    val saveStateEnabled: Boolean,
//    val retainNonActiveTabFragmentsEnabled: Boolean,
//    val tabHistoryEnabled: Boolean
//) : LabyrinthVMUnitTest() {
//    @Before
//    override fun setUp() {
//        super.setUp()
//        iLabyrinthConfig.defaultSelectedTabIndex = defaultSelectedTabIndex
//        iLabyrinthConfig.resetOnSameTabClickEnabled = resetOnSameTabClickEnabled
//        iLabyrinthConfig.saveStateEnabled = saveStateEnabled
//        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = retainNonActiveTabFragmentsEnabled
//        iLabyrinthConfig.tabHistoryEnabled = tabHistoryEnabled
//    }
//
//}
//
//
//class DynamicLabyrinthVMUnitTest {
//    fun log(msg: String) {
//        println("Logger:  $msg")
//    }
//
//    @Before
//    fun setUp() {
//        val defaultSelectedTabIndexList = listOf(0, 1, 2)
//        val resetOnSameTabClickEnabledList = listOf(true, false)
//        val saveStateEnabledList = listOf(true, false)
//        val retainNonActiveTabFragmentsEnabledList = listOf(true, false)
//        val tabHistoryEnabledList = listOf(true, false)
//
//        var itr = 0
//
//        defaultSelectedTabIndexList.forEach { defaultSelectedTabIndex ->
//
//            resetOnSameTabClickEnabledList.forEach { resetOnSameTabClickEnabled ->
//
//                saveStateEnabledList.forEach { saveStateEnabled ->
//
//                    retainNonActiveTabFragmentsEnabledList.forEach { retainNonActiveTabFragmentsEnabled ->
//
//                        tabHistoryEnabledList.forEach { tabHistoryEnabled ->
//                            itr++
//                            log(
//                                "Test num. $itr \n" +
//                                        "defaultSelectedTabIndex $defaultSelectedTabIndex \n" +
//                                        "resetOnSameTabClickEnabled $resetOnSameTabClickEnabled \n" +
//                                        "saveStateEnabled $saveStateEnabled \n" +
//                                        "retainNonActiveTabFragmentsEnabled $retainNonActiveTabFragmentsEnabled \n" +
//                                        "tabHistoryEnabled $tabHistoryEnabled \n"
//                            )
//                            val test = LabyrinthVMUnitTestCustom(
//                                defaultSelectedTabIndex = defaultSelectedTabIndex,
//                                resetOnSameTabClickEnabled = resetOnSameTabClickEnabled,
//                                saveStateEnabled = saveStateEnabled,
//                                retainNonActiveTabFragmentsEnabled = retainNonActiveTabFragmentsEnabled,
//                                tabHistoryEnabled = tabHistoryEnabled
//                            )
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//
//}