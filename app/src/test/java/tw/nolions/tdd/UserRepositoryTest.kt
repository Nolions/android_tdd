package tw.nolions.tdd

import io.mockk.CapturingSlot
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import tw.nolions.tdd.UserService.UserDataReceivedListener

class UserRepositoryTest {
    private lateinit var service: UserService
    private lateinit var model: UserModel
    private lateinit var repo: UserRepository

    @Before
    fun setup() {
        service = mockk<UserService>()
        model = UserModel(id = 1, name = "123456")
        repo = UserRepository(service)
    }

    @Test
    fun testUserDataByListener() {
        val slot = CapturingSlot<UserDataReceivedListener>()

        every {
            service.userDataByListener(any(), capture(slot))
        }.answers {
            slot.captured.onUserReceived(model)
        }

        repo.userDataByListener()

        Assert.assertEquals(model.name, repo.userName)
    }

    @Test
    fun testUserDataByLambda() {
        every {
            service.userDataByLambda(any(), captureLambda())
        }.answers {
            lambda<(data: UserModel) ->Unit>().invoke(model)
        }

        repo.userDataByLambda()

        Assert.assertEquals(model.name, repo.userName)
    }
}