package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.abanoubmilad.labyrinth.demo.tab0.About1
import org.abanoubmilad.labyrinth.demo.tab0.About2
import org.abanoubmilad.labyrinth.demo.tab0.About3
import org.abanoubmilad.labyrinth.demo.tab0.Welcome
import org.abanoubmilad.labyrinth.demo.tab2.Register
import org.junit.After
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random


open class LabyrinthVMUnitTestSingle {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var viewModel: LabyrinthViewModelSingle
    lateinit var iLabyrinthConfig: ILabyrinthConfigSingle

    @Before
    open fun setUp() {
        viewModel = LabyrinthViewModelSingle()
        iLabyrinthConfig = object : ILabyrinthConfigSingle {
            override var saveStateEnabled = true
            override var retainNonActiveFragmentsEnabled = false
        }
        viewModel.init(iLabyrinthConfig)

    }

    @After
    fun tearDown() {

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


        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout2, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout2::class.java, viewModel.currentFragment!!::class.java)
        }
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

        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout1, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout1::class.java, viewModel.currentFragment!!::class.java)
        }
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


        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout1, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout1::class.java, viewModel.currentFragment!!::class.java)
        }
    }

    @Test
    fun onBackPressed_with_root_fragment_isCorrect() {
        val fragmentAbout1 = About1()
        viewModel.push(fragmentAbout1)

        viewModel.dismiss(clearAllTop = true)

        viewModel.onBackPressed()
        viewModel.onBackPressed()
        viewModel.onBackPressed()

        assertSame(1, viewModel.currentStack.size)

    }

    @Test
    fun pop_isCorrect() {
        val fragmentAbout1 = About1()
        val fragmentAbout2 = About2()
        val fragmentWelcome = Welcome()
        viewModel.push(fragmentAbout1)
        viewModel.push(fragmentAbout2)
        viewModel.popThenPush(fragmentWelcome)


        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentWelcome, viewModel.currentFragment)
        } else {
            assertSame(fragmentWelcome::class.java, viewModel.currentFragment!!::class.java)
        }

        viewModel.onBackPressed()

        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout1, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout1::class.java, viewModel.currentFragment!!::class.java)
        }
    }


    @Test
    fun maintain_bundle_when_pushing() {

        val fragmentAbout1 = About1()
        val fragmentAbout1Bundle = Bundle()
        fragmentAbout1.arguments = fragmentAbout1Bundle

        viewModel.push(fragmentAbout1)


        val fragmentAbout2 = About2()
        val fragmentAbout2Bundle = Bundle()
        fragmentAbout2.arguments = fragmentAbout2Bundle

        viewModel.push(fragmentAbout2)


        val fragmentWelcome = Welcome()
        val fragmentWelcomeBundle = Bundle()
        fragmentWelcome.arguments = fragmentWelcomeBundle

        viewModel.push(fragmentWelcome)



        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentWelcome, viewModel.currentFragment)
        } else {
            assertSame(fragmentWelcome::class.java, viewModel.currentFragment!!::class.java)
        }

        assertSame(
            fragmentAbout2Bundle,
            viewModel.currentFragment?.arguments
        )
        assertNotSame(
            fragmentAbout1Bundle,
            viewModel.currentFragment?.arguments
        )
        assertSame(
            fragmentWelcomeBundle,
            viewModel.currentFragment?.arguments
        )

        viewModel.dismiss(clearAllTop = false)

        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout2, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout2::class.java, viewModel.currentFragment!!::class.java)
        }

        assertSame(
            fragmentAbout2Bundle,
            viewModel.currentFragment?.arguments
        )
        assertNotSame(
            fragmentAbout1Bundle,
            viewModel.currentFragment?.arguments
        )
        assertNotSame(
            fragmentWelcomeBundle,
            viewModel.currentFragment?.arguments
        )

        viewModel.dismiss(clearAllTop = false)


        if (iLabyrinthConfig.retainNonActiveFragmentsEnabled) {
            assertSame(fragmentAbout1, viewModel.currentFragment)
        } else {
            assertSame(fragmentAbout1::class.java, viewModel.currentFragment!!::class.java)
        }

        assertSame(
            fragmentAbout1Bundle,
            viewModel.currentFragment?.arguments
        )
        assertNotSame(
            fragmentAbout2Bundle,
            viewModel.currentFragment?.arguments
        )
        assertNotSame(
            fragmentWelcomeBundle,
            viewModel.currentFragment?.arguments
        )

    }


    private fun populateStacksWithRandomFragments() {
        val list = listOf(About1(), Welcome(), Register(), About3(), About2(), About1())
        val random = Random(100)
        for (i in list.indices) {
            list.shuffled().take(random.nextInt(list.count())).forEach {
                viewModel.push(it)
            }
        }
    }


}
