package org.abanoubmilad.labyrinth.customTests

import org.abanoubmilad.labyrinth.LabyrinthVMUnitTest
import org.junit.Before

open class LabyrinthVMUnitTest1 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

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

open class LabyrinthVMUnitTest3 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest4 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest5 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest6 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest7 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest8 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

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

open class LabyrinthVMUnitTest10 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest11 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest12 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest13 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest14 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest15 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest16 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 0
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest17 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest18 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest19 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest20 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest21 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest22 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest23 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest24 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest25 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest26 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest27 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest28 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest29 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest30 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest31 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest32 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 1
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest33 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest34 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

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

open class LabyrinthVMUnitTest36 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest37 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

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

open class LabyrinthVMUnitTest39 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest40 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = true
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest41 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest42 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest43 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest44 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = true
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest45 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest46 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = true
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}

open class LabyrinthVMUnitTest47 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = true
    }
}

open class LabyrinthVMUnitTest48 : LabyrinthVMUnitTest() {
    @Before
    override fun setUp() {
        super.setUp()
        iLabyrinthConfig.defaultSelectedTabIndex = 2
        iLabyrinthConfig.resetOnSameTabClickEnabled = false
        iLabyrinthConfig.saveStateEnabled = false
        iLabyrinthConfig.retainNonActiveTabFragmentsEnabled = false
        iLabyrinthConfig.tabHistoryEnabled = false
    }
}