package tw.nolions.tdd

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryInstrumentedTest {

    @Test
    fun saveUserName() {
        val appContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val userName = "A123456789"

        Repository(appContext).saveUserName(userName)

        val actual =  Repository(appContext).getUserName()

        Assert.assertEquals(userName, actual)
    }
}