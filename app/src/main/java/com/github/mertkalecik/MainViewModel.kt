package com.github.mertkalecik

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var isSessionExpired = false

    suspend fun isSessionExpired(): Boolean {
        withContext(Dispatchers.IO) {
            delay(3_000) // network simulation
            isSessionExpired = true
        }

        return isSessionExpired
    }

}