package org.abanoubmilad.labyrinth

fun getCustomTestCasesPath() = "./app/src/test/java/org/abanoubmilad/labyrinth/customTests"

fun log(msg: String) {
    println("Logger:  $msg")
}

fun generateCustomTest(
    defaultSelectedTabIndex: Int,
    resetOnSameTabClickEnabled: Boolean,
    saveStateEnabled: Boolean,
    retainNonActiveTabFragmentsEnabled: Boolean,
    tabHistoryEnabled: Boolean,
    testName: String
): String {
    return " package org.abanoubmilad.labyrinth.customTests" +

            "\n import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest" +
            "\n         import org.junit.Before" +

            "\n         open class $testName : LabyrinthVMUnitTest() {" +
            "\n     @Before" +
            "\n     override fun setUp() {" +
            "\n         super.setUp()" +
            "\n         iLabyrinthConfig.defaultSelectedTabIndex = $defaultSelectedTabIndex" +
            "\n         iLabyrinthConfig.resetOnSameTabClickEnabled = $resetOnSameTabClickEnabled" +
            "\n         iLabyrinthConfig.saveStateEnabled = $saveStateEnabled" +
            "\n         iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = $retainNonActiveTabFragmentsEnabled" +
            "\n         iLabyrinthConfig.tabHistoryEnabled = $tabHistoryEnabled" +
            "\n     }" +
            "\n }"

}