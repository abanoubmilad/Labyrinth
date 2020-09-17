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
                        val name = "LabyrinthVMUnitTest$itr"
                        File(getCustomTestCasesPath() + "/$name.kt").printWriter()
                            .use { out ->
                                out.println(
                                    generateCustomTest(
                                        defaultSelectedTabIndex,
                                        resetOnSameTabClickEnabled,
                                        saveStateEnabled,
                                        retainNonActiveTabFragmentsEnabled,
                                        tabHistoryEnabled,
                                        name
                                    )
                                )

                            }
                    }
                }


            }
        }
    }
}