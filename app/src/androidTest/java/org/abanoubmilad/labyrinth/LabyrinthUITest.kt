//package org.abanoubmilad.labyrinth
//
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.matcher.ViewMatchers.withId
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import androidx.test.filters.LargeTest
//import org.abanoubmilad.labyrinth.demo.UITestMultiNavActivity
//import org.abanoubmilad.labyrinth.demo.tab0.About2
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//
//@LargeTest
//class LabyrinthUITest {
//
//
//    @get:Rule
//    var activityRule = ActivityScenarioRule(UITestMultiNavActivity::class.java)
//
//    lateinit var iLabyrinthConfig: ILabyrinthConfig
//
//    @Before
//    fun setUp() {
//        activityRule.scenario.onActivity { activity ->
//            iLabyrinthConfig = activity.iLabyrinthConfig
//        }
//    }
//
//
//    @Test
//    fun onMenuItemClicked_sameTab_isCorrect() {
//        val tabMenuId = R.id.home
//        val tabIndex = 0
//
//
//        onView(withId(tabMenuId))
//            .perform(click())
//
//        // push fragmentAbout1
//        onView(withId(R.id.about_btn))
//            .perform(click())
//
//        // push fragmentAbout2
//        onView(withId(R.id.btnNext))
//            .perform(click())
//
//        // push fragmentAbout3
//        onView(withId(R.id.btnNext))
//            .perform(click())
//
//        onView(withId(tabMenuId))
//            .perform(click())
//
//        activityRule.scenario.onActivity { activity ->
//            Assert.assertEquals(1, activity.supportFragmentManager.fragments.size)
//
//            if (iLabyrinthConfig.resetOnSameTabClickEnabled) {
//                Assert.assertEquals(
//                    iLabyrinthConfig.rootTabFragmentsInitializer[tabIndex].invoke()::class,
//                    activity.supportFragmentManager.findFragmentById(R.id.nav_host_container)!!::class
//                )
//            } else {
//                Assert.assertEquals(
//                    About2::class,
//                    activity.supportFragmentManager.findFragmentById(R.id.nav_host_container)!!::class
//                )
//            }
//        }
//
//
//    }
//
//
//}