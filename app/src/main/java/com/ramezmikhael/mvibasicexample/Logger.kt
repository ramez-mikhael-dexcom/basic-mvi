package com.ramezmikhael.mvibasicexample

import android.util.Log
import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import com.ramezmikhael.mvibasicexample.redux.MessageStore

class Logger: MiddleWare {
    override suspend fun process(
        currentState: MessageViewState,
        action: MessageAction,
        store: MessageStore
    ) {
        Log.d("MessageLog", "Action: $action")
        Log.d("MessageLog", "State: $currentState")
    }
}