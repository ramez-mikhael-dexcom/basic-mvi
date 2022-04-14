package com.ramezmikhael.mvibasicexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramezmikhael.mvibasicexample.Logger
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.network.ApiMiddleWare
import com.ramezmikhael.mvibasicexample.redux.MessageStore
import com.ramezmikhael.mvibasicexample.redux.Reducer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel(
    private val store: MessageStore = MessageStore(Reducer(),
        listOf(ApiMiddleWare(), Logger()))
) : ViewModel() {

    val state = store.state

    fun messageChanged(message: String) {
        store.dispatch(MessageAction.MessageTextChanged(message))
    }

    fun send() {
        store.dispatch(MessageAction.SendClicked)
    }
}