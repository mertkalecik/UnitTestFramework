package com.github.mertkalecik

import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest : BaseUnitTest() {

    private val viewModel: MainViewModel = mockk(relaxed = true)

    @Test
    fun `verify the private variable value change`() {
        // Given
        val expected = true

        // When
        viewModel.updateInaccessibleField(fieldName = "isSessionExpired", expected)

        // Then
        val output = viewModel.getInaccessibleField(fieldName = "isSessionExpired")
        assertEquals(expected, output)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `verify suspend function called`() = runTest {
        // Given
        val expected = false

        // When
        val out = viewModel.invokeSuspendFunction(methodName = "isSessionExpired2")

        // Then
        assertEquals(expected, out)
    }
}