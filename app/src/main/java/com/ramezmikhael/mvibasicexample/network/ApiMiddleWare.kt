package com.ramezmikhael.mvibasicexample.network

import com.ramezmikhael.mvibasicexample.MiddleWare
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.redux.MessageStore
import com.ramezmikhael.mvibasicexample.redux.Reducer
import kotlinx.coroutines.delay

class ApiMiddleWare() : MiddleWare {
    override suspend fun process(
        currentState: MessageViewState,
        action: MessageAction,
        store: MessageStore
    ) {

        if (action == MessageAction.SendClicked) {
            sendMessage(currentState, action, store)
        }
    }

    private suspend fun sendMessage(
        currentState: MessageViewState,
        action: MessageAction,
        store: MessageStore
    ) {
        delay(2000)
        store.dispatch(MessageAction.SendFinished)
    }
}