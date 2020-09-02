package org.abanoubmilad.labyrinth

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.abanoubmilad.labyrinth.demo.UITestMultiNavActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class LabyrinthUISelectTabTest {


    @get:Rule
    var activityRule = ActivityScenarioRule(UITestMultiNavActivity::class.java)

    lateinit var iLabyrinthConfig: ILabyrinthConfig

    @Before
    fun setUp() {
        activityRule.scenario.onActivity { activity ->
            iLabyrinthConfig = activity.iLabyrinthConfig
        }
    }

    @Test
    fun selectTab_isCorrect() {
        iLabyrinthConfig.menuItemIdToRootTabFragmentIndexMap.forEach { (menuId, index) ->

            onView(withId(menuId))
                .perform(click())
            activityRule.scenario.onActivity { activity ->
                Assert.assertEquals(1, activity.supportFragmentManager.fragments.size)
                Assert.assertEquals(
                    iLabyrinthConfig.rootTabFragmentsInitializer[index].invoke()::class,
                    activity.supportFragmentManager.findFragmentById(R.id.nav_host_container)!!::class
                )
            }

        }
    }
}