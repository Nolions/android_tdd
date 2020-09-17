package tw.nolions.tdd

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.view_number_select.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewNumberSelectAndroidTest {

    lateinit var context: Context
    lateinit var numSelectView: ViewNumberSelect

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        numSelectView = ViewNumberSelect(context)
    }

    @Test
    fun testAddBtnClick_ValueAdd() {
        numSelectView.setDefaultValue(0)
        numSelectView.addButton.performClick()

        Assert.assertEquals(1, numSelectView.textValue)
    }

    @Test
    fun testAddBtnClick_ValueMax() {
        numSelectView.setDefaultValue(1)
        numSelectView.setMaxValue(1)
        numSelectView.addButton.performClick()

        Assert.assertEquals(1, numSelectView.textValue)
    }

    @Test
    fun testMinusBtnClick_ValueMinus() {
        numSelectView.setDefaultValue(1)
        numSelectView.minusButton.performClick()

        Assert.assertEquals(0, numSelectView.textValue)
    }

    @Test
    fun testMinusBtnClick_ValueMin() {
        numSelectView.setDefaultValue(1)
        numSelectView.setMaxValue(1)
        numSelectView.addButton.performClick()

        Assert.assertEquals(1, numSelectView.textValue)
    }
}