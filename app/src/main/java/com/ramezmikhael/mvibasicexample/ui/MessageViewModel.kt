package com.ramezmikhael.mvibasicexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.redux.Reducer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val reducer: Reducer = Reducer()) : ViewModel() {

    fun messageChanged(message: String) {
        _state.value = reducer.reducer(_state.value, MessageAction.MessageTextChanged(message))
    }

    // EVIL
    fun send() {
        viewModelScope.launch {
            _state.value = reducer.reducer(_state.value, MessageAction.SendClicked)
            delay(2000)
            // heavy operation running...
            _state.value = reducer.reducer(_state.value, MessageAction.SendFinished)
        }
    }

    private val _state = MutableStateFlow(MessageViewState())
    val state: StateFlow<MessageViewState> = _state
}