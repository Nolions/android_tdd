package tw.nolions.tdd

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TestRegisterVerify {
    private lateinit var registerVerify: RegisterVerify

    @Before
    fun setup() {
        registerVerify = RegisterVerify()
    }

    @Test
    fun testVerifyRegisterId_True() {
        val actual = registerVerify.verifyUserName("A123456")

        Assert.assertTrue(actual)
    }

    @Test
    fun testVerifyRegisterId_Fail() {
        val actual = registerVerify.verifyUserName("A123")

        Assert.assertFalse(actual)
    }
}