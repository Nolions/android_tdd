package tw.nolions.tdd

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test


@LargeTest
class MainActivityInstrumentedTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun registerSuccess() {
        onView(withId(R.id.userName)).perform(
            typeText("a123456789"),
            ViewActions.closeSoftKeyboard()
        )

        onView(withId(R.id.send)).perform(click())

        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun registerFail() {
        onView(withId(R.id.userName)).perform(typeText("1234"))
        onView(withId(R.id.send)).perform(click())
        onView(withText("Fail")).inRoot(isDialog()).check(matches(isDisplayed()))
        onView(withText("Fail")).inRoot(withDecorView(not(`is`(activityActivityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))

    }
}