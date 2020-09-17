package org.abanoubmilad.labyrinth

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.Fragment
import org.abanoubmilad.labyrinth.demo.tab0.About1
import org.abanoubmilad.labyrinth.demo.tab0.About2
import org.abanoubmilad.labyrinth.demo.tab0.About3
import org.abanoubmilad.labyrinth.demo.tab0.Welcome
import org.abanoubmilad.labyrinth.demo.tab1.Leaderboard
import org.abanoubmilad.labyrinth.demo.tab2.Register
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random


open class LabyrinthVMUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: LabyrinthViewModel
    lateinit var iLabyrinthConfig: ILabyrinthConfig

    fun log(msg: String) {
        println("Logger:  $msg")
    }

    @Before
    open fun setUp() {
        viewModel = LabyrinthViewModel()
        iLabyrinthConfig = object : ILabyrinthConfig {
            override val rootTabFragmentsInitializer: List<() -> Fragment> = listOf(
                { Welcome() },
                { Leaderboard() },
                { Register() }
            )
            override val menuItemIdToRootTabFragmentIndexMap: HashMap<Int, Int> =
                hashMapOf(
                    R.id.home to 0,
                    R.id.list to 1,
                    R.id.form to 2
                )
            override var defaultSelectedTabIndex: Int = 1
            override var resetOnSameTabClickEnabled: Boolean = true
            override var saveStateEnabled: Boolean = true
            override var retainNonActiveTabFragmentsEnabled = false
            override var tabHistoryEnabled: Boolean = true

        }
        viewModel.init(iLabyrinthConfig)

    }

    @After
    fun tearDown() {

    }

    @Test(expected = IllegalArgumentException::class)
    fun selectTab_outOfBounds_lessThanZero_isCorrect() {
        viewModel.selectTab(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun selectTab_outOfBounds_greaterThanNumberOfTabs_isCorrect() {
        viewModel.selectTab(iLabyrinthConfig.rootTabFragmentsInitializer.size)
    }

    @Test
    fun selectTab_clearTop_isCorrect() {

        populateStacksWithRandomFragments()

        for (i in iLabyrinthConfig.rootTabFragmentsInitializer.indices) {
            viewModel.selectTab(i, clearAllTop = true)

            assertEquals(i, viewModel.selectedTabIndex)
            assertEquals(true, viewModel.isCurrentFragmentRoot)
            assertEquals(
                iLabyrinthConfig.rootTabFragmentsInitializer[i].invoke()::class,
                viewModel.currentFragment::class
            )
        }

        populateStacksWithRandomFragments()

        for (i in iLabyrinthConfig.rootTabFragmentsInitializer.indices.reversed()) {
            viewModel.selectTab(i, clearAllTop = true)

            assertEquals(i, viewModel.selectedTabIndex)
            assertEquals(true, viewModel.isCurrentFragmentRoot)
            assertEquals(
                iLabyrinthConfig.rootTabFragmentsInitializer[i].invoke()::class,
                viewModel.currentFragment::class
            )
        }
    }

    @Test
    fun selectTab_isCorrect() {
        for (i in iLabyrinthConfig.rootTabFragmentsInitializer.indices) {
            viewModel.selectTab(i, clearAllTop = true)

            assertEquals(i, viewModel.selectedTabIndex)
            assertEquals(true, viewModel.isCurrentFragmentRoot)
            assertEquals(
                iLabyrinthConfig.rootTabFragmentsInitializer[i].invoke()::class,
                viewModel.currentFragment::class
            )
        }

    }


    @Test
    fun onMenuItemClicked_isCorrect() {
        iLabyrinthConfig.menuItemIdToRootTabFragmentIndexMap.toList()
            .forEach { (menuItemId, tabIndex) ->
                viewModel.onMenuItemSelected(menuItemId)
                assertEquals(tabIndex, viewModel.selectedTabIndex)
            }
        iLabyrinthConfig.menuItemIdToRootTabFragmentIndexMap.toList().asReversed()
            .forEach { (menuItemId, tabIndex) ->
                viewModel.onMenuItemSelected(menuItemId)
                assertEquals(tabIndex, viewModel.selectedTabIndex)
            }
    }

    @Test
    fun onMenuItemClicked_sameTab_isCorrect() {
        val tabsList = iLabyrinthConfig.menuItemIdToRootTabFragmentIndexMap.toList()

        val tabMenuId = tabsList[0].first
        val tabIndex = tabsList[0].second

        viewModel.onMenuItemSelected(tabMenuId)

        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentAbout3 = About3()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.push(fragmentAbout3)

        viewModel.onMenuItemSelected(tabMenuId)

        if (iLabyrinthConfig.resetOnSameTabClickEnabled) {
            assertEquals(true, viewModel.isCurrentFragmentRoot)
            assertEquals(
                iLabyrinthConfig.rootTabFragmentsInitializer[tabIndex].invoke()::class,
                viewModel.currentFragment::class
            )
        } else {
            assertEquals(fragmentAbout2, viewModel.currentFragment)
        }


    }

    @Test
    fun push_1_depth_isCorrect() {
        val fragmentAbout1 = About1()
        viewModel.push(fragmentAbout1)

        assertSame(fragmentAbout1, viewModel.currentFragment)
    }

    @Test
    fun push_2_depth_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)

        assertSame(fragmentAbout2, viewModel.currentFragment)
    }


    @Test
    fun push_3_depth_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentAbout3 = About3()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.push(fragmentAbout3)

        assertSame(fragmentAbout3, viewModel.currentFragment)
    }

    @Test
    fun onBackPressed_1_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentAbout3 = About3()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.push(fragmentAbout3)

        viewModel.onBackPressed()

        assertSame(fragmentAbout2, viewModel.currentFragment)
    }


    @Test
    fun onBackPressed_2_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentAbout3 = About3()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.push(fragmentAbout3)

        viewModel.onBackPressed()
        viewModel.onBackPressed()

        assertSame(fragmentAbout1, viewModel.currentFragment)
    }

    @Test
    fun onBackPressed_3_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentAbout3 = About3()
        val fragmentWelcome = Welcome()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.push(fragmentAbout3)
        viewModel.push(fragmentWelcome)

        viewModel.onBackPressed()
        viewModel.onBackPressed()
        viewModel.onBackPressed()

        assertSame(fragmentAbout1, viewModel.currentFragment)
    }


    @Test
    fun navigateAndPush_isCorrect() {
        viewModel.selectTab(0)

        val fragmentAbout1 = About1()
        val fragmentWelcome = Welcome()
        viewModel.push(fragmentAbout1)
        viewModel.selectTab(1, clearAllTop = false, fragmentToPush = fragmentWelcome)

        assertSame(fragmentWelcome, viewModel.currentFragment)

        viewModel.selectTab(0)
        if (iLabyrinthConfig.retainNonActiveTabFragmentsEnabled) {
            assertSame(fragmentAbout1, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout1::class.java, viewModel.currentFragment::class.java)
        }

        viewModel.selectTab(1)
        if (iLabyrinthConfig.retainNonActiveTabFragmentsEnabled) {
            assertSame(fragmentWelcome, viewModel.currentFragment)
        } else {
            assertSame(fragmentWelcome::class.java, viewModel.currentFragment::class.java)
        }
    }

    @Test
    fun pop_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentWelcome = Welcome()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.popThenPush(fragmentWelcome)

        assertSame(fragmentWelcome, viewModel.currentFragment)
        viewModel.onBackPressed()
        assertSame(fragmentAbout1, viewModel.currentFragment)
    }


    private fun populateStacksWithRandomFragments() {
        val list = listOf(About1(), Welcome(), Register(), About3(), About2(), About1())
        val random = Random(100)
        for (i in iLabyrinthConfig.rootTabFragmentsInitializer.indices) {
            viewModel.selectTab(i)
            list.shuffled().take(random.nextInt(list.count())).forEach {
                viewModel.push(it)
            }
        }
    }


}
