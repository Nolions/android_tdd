package tw.nolions.tdd

import android.content.Context
import android.content.SharedPreferences
import io.mockk.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class RepositoryTest {

    lateinit var sharedPrefs: SharedPreferences
    lateinit var sharedPrefsEditor: SharedPreferences.Editor
    lateinit var context: Context

    @Before
    fun setup() {
        sharedPrefs = mockk<SharedPreferences>()
        sharedPrefsEditor = mockk<SharedPreferences.Editor>()
        context = mockk<Context>()
    }

    @Test
    fun testSaveUserName() {
        every { context.getSharedPreferences(any(), any()) } returns sharedPrefs
        every { sharedPrefs.edit() } returns sharedPrefsEditor
        every { sharedPrefsEditor.putString(any(), any()) } returns sharedPrefsEditor
        every { sharedPrefsEditor.apply() } just Runs

        val repository = Repository(context)
        repository.saveUserName("A1234567")

        verify { sharedPrefsEditor.putString(any(), any()) }
        verify { sharedPrefsEditor.apply() }
    }

    @Test
    fun testGetUserName() {
        every { context.getSharedPreferences(any(), any()) } returns sharedPrefs
        every { sharedPrefs.getString(any(), any()) } returns String()

        val repository = Repository(context)
        repository.getUserName()

        verify { sharedPrefs.getString(any(), any()) }
    }
}