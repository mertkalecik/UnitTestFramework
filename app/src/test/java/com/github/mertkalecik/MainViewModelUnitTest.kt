package com.github.mertkalecik

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

    private val viewModel = MainViewModel()

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
        val expected = true

        // When
        val out = viewModel.invokeSuspendFunction(methodName = "isSessionExpired")

        // Then
        assertEquals(expected, out)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `verify suspend function with parameter is called`() = runTest {
        // Given
        val expected = 18

        // When
        val out = viewModel.invokeSuspendFunction(methodName = "returnSumByConstant", 5)

        // Then
        assertEquals(expected, out)
    }
}