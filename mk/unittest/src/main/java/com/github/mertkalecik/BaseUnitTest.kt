package com.github.mertkalecik

import io.mockk.MockKAnnotations
import java.lang.reflect.Method
import kotlin.reflect.full.callSuspend
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.isAccessible
import org.junit.Before
import org.junit.Rule
import timber.log.Timber

abstract class BaseUnitTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Before
    open fun setUp() {
        MockKAnnotations.init(this)
    }

    /**
     * [@Java] + [@Kotlin]
     * Updates Inaccessible Field with Using Reflection
     * [Any] Stands for the target class (system under test) which includes private field.
     */
    fun Any.updateInaccessibleField(fieldName: String, value: Any) {
        try {
            this::class.java.getDeclaredField(fieldName).also {
                it.isAccessible = true
                it.set(this, value)
            }
        } catch (ex: NoSuchFieldException) {
            Timber.d(ex)
        }
    }

    /**
     * [@Java] + [@Kotlin]
     * Returns "Private" Field and also makes the field accessible for testing purpose.
     * [Any] Stands for the target class (system under test) which includes private field.
     */
    fun Any.getInaccessibleField(fieldName: String): Any? =
        try {
            this::class.java.getDeclaredField(fieldName).also {
                it.isAccessible = true
            }.get(this)
        } catch (ex: NoSuchFieldException) {
            Timber.d(ex)
            null
        }

    /**
     * [@Java]
     * Returns "Private" Method and also makes the method accessible for testing purpose.
     * [Any] Stands for the the target class (system under test) which includes private method.
     */
    fun Any.getInaccessibleMethod(methodName: String, vararg types: Class<*>): Method? =
        try {
            this.javaClass.getDeclaredMethod(methodName, *types).also { it.isAccessible = true }
        } catch (ex: NoSuchMethodException) {
            Timber.d(ex)
            null
        }

    /**
     * [@Kotlin]
     * Invokes "Private" Suspend Method also makes the method accessible for testing purpose.
     * [Any] Stands the target class (system under test) which includes private suspend method.
     */
    suspend fun Any.invokeSuspendFunction(methodName: String, vararg args: Any?): Any? =
        this::class.memberFunctions.find { it.name == methodName }?.also {
            it.isAccessible = true
            return it.callSuspend(this, *args)
        }

    /**
     * [@Kotlin]
     * Invokes "Private" Method also makes the method accessible for testing purpose.
     * [Any] Stands the target class (system under test) which includes private method.
     */
    fun Any.invokeFunction(methodName: String, vararg args: Any?): Any? =
        this::class.memberFunctions.find { it.name == methodName }?.also {
            it.isAccessible = true
            return it.call(this, *args)
        }

}
