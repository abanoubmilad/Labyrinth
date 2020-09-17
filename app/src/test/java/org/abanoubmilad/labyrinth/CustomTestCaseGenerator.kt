package org.abanoubmilad.labyrinth

import java.io.File


fun main(args: Array<String>) {
    log("deleting custom test cases at path: ${getCustomTestCasesPath()}")
    log("deleting result: ${File(getCustomTestCasesPath()).deleteRecursively()}")
    File(getCustomTestCasesPath()).mkdir()


    val defaultSelectedTabIndexList = listOf(0, 1, 2)
    val resetOnSameTabClickEnabledList = listOf(true, false)
    val saveStateEnabledList = listOf(true, false)
    val retainNonActiveTabFragmentsEnabledList = listOf(true, false)
    val tabHistoryEnabledList = listOf(true, false)

    var itr = 0

    defaultSelectedTabIndexList.forEach { defaultSelectedTabIndex ->

        resetOnSameTabClickEnabledList.forEach { resetOnSameTabClickEnabled ->

            saveStateEnabledList.forEach { saveStateEnabled ->

                retainNonActiveTabFragmentsEnabledList.forEach { retainNonActiveTabFragmentsEnabled ->

                    tabHistoryEnabledList.forEach { tabHistoryEnabled ->
                        itr++
                        File(getCustomTestCasesPath() + "/LabyrinthVMUnitTest$itr.kt").printWriter()
                            .use { out ->
                                out.println(
                                    "package org.abanoubmilad.labyrinth.customTests" +
                                            "\n import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest" +
                                            "\n import org.junit.Before" +
                                            "\n open class LabyrinthVMUnitTest$itr: LabyrinthVMUnitTest() {@Before override fun setUp() {super.setUp() " +
                                            "\n iLabyrinthConfig.defaultSelectedTabIndex = $defaultSelectedTabIndex" +
                                            "\n iLabyrinthConfig.resetOnSameTabClickEnabled = $resetOnSameTabClickEnabled" +
                                            "\n iLabyrinthConfig.saveStateEnabled = $saveStateEnabled" +
                                            "\n iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = $retainNonActiveTabFragmentsEnabled" +
                                            "\n iLabyrinthConfig.tabHistoryEnabled = $tabHistoryEnabled" +
                                            " }}"
                                )

                            }
                    }
                }


            }
        }
    }
}