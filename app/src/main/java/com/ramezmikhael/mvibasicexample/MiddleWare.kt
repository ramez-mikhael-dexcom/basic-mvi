package com.ramezmikhael.mvibasicexample

import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.redux.MessageStore
import com.ramezmikhael.mvibasicexample.redux.Reducer

interface MiddleWare {
    suspend fun process(currentState: MessageViewState, action: MessageAction, store: MessageStore)
}