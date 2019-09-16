package kisan.com.fabproject

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class FirstActivityUITest {
    @Rule @JvmField
    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule @JvmField
    var testName = TestName()



    @Test
    fun Endtoendflow(){

        Thread.sleep(500)

        try {
            onView(withId(R.id.button)).check(matches(isDisplayed()))
            assert(false)
        } catch (e: NoMatchingViewException){
        }

    }

}