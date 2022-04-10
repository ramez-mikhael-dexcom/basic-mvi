package com.ramezmikhael.mvibasicexample.network

import com.ramezmikhael.mvibasicexample.MiddleWare
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.redux.Reducer
import kotlinx.coroutines.delay

class Api: MiddleWare {
    override suspend fun process(currentState: MessageViewState, action: MessageAction, reducer: Reducer) {

        if(action == MessageAction.SendClicked) {
            sendMessage(currentState, action, reducer)
        }
    }

    private suspend fun sendMessage(currentState: MessageViewState, action: MessageAction, reducer: Reducer) {
        delay(2000)
        reducer.reducer(currentState, MessageAction.SendFinished)
    }
}