package tw.nolions.tdd

import io.mockk.MockKAnnotations
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var activity: MainActivity

    @Before
    fun setupActivity() {
        MockKAnnotations.init(this)

        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun registerSuccess() {
        val shadowActivity = Shadows.shadowOf(activity)
        activity.userName.setText("A123456789")
        activity.send.performClick()

        val nextIntent = shadowActivity.nextStartedActivity
        Assert.assertEquals(ResultActivity::class.java.name, nextIntent.component!!.className)
    }
}