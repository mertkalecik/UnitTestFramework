package com.github.mertkalecik

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var isSessionExpired = false

    private suspend fun isSessionExpired(): Boolean {
        withContext(Dispatchers.IO) {
            delay(1_000) // network simulation
            isSessionExpired = true
        }

        return isSessionExpired
    }

    private suspend fun returnSumByConstant(value: Int): Int {
        val constant = 13
        delay(1_000)
        return value + constant
    }

}