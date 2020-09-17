package org.abanoubmilad.labyrinth

fun main(args: Array<String>) {
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
                        println(
                            "open class LabyrinthVMUnitTest$itr: LabyrinthVMUnitTest() {@Before override fun setUp() {super.setUp() " +
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