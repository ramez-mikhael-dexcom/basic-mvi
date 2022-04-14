package com.ramezmikhael.mvibasicexample.redux

import com.ramezmikhael.mvibasicexample.MiddleWare
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageStore(
    val reducer: Reducer,
    val middleWare: List<MiddleWare>
) {
    
    private val _state = MutableStateFlow(MessageViewState())
    val state: StateFlow<MessageViewState> = _state

    fun dispatch(action: MessageAction) {
        CoroutineScope(Dispatchers.IO).launch {
            middleWare.forEach {
                it.process(_state.value, action, this@MessageStore)
            }
        }
        _state.value = reducer.reducer(_state.value, action)
    }
}