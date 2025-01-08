package com.example.fitness.presentation.summary



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timeLeft = MutableStateFlow(1200)
    val timeLeft: StateFlow<Int> = _timeLeft

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private var timerJob: Job? = null

    fun onToggleTimer() {
        if (_isRunning.value) {
            // Pause
            _isRunning.value = false
            timerJob?.cancel()
        } else {
            // Start
            _isRunning.value = true
            startTimer()
        }
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (_timeLeft.value > 0 && _isRunning.value) {
                delay(1000)
                _timeLeft.value -= 1
            }
            if (_timeLeft.value == 0) {
                _isRunning.value = false
            }
        }
    }

    fun onIncrementTime() {
        _timeLeft.value += 60
    }

    fun onDecrementTime() {
        if (_timeLeft.value >= 60) {
            _timeLeft.value -= 60
        }
    }
}
