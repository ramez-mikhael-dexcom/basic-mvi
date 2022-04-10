package com.ramezmikhael.mvibasicexample.redux

import com.ramezmikhael.mvibasicexample.intent.MessageAction
import com.ramezmikhael.mvibasicexample.model.MessageViewState

class Reducer {
    fun reducer(currentState: MessageViewState, action: MessageAction): MessageViewState {
        return when (action) {
            is MessageAction.Error -> TODO()
            is MessageAction.MessageTextChanged -> buildStateWhenTextChanged(currentState, action)
            MessageAction.SendClicked -> buildStateWhenSendClicked(currentState)
            MessageAction.SendFinished -> buildStateWhenSendFinished(currentState)
        }
    }

    private fun buildStateWhenSendFinished(currentState: MessageViewState): MessageViewState {
        return currentState.copy(message = "",
        errorMessage = "",
        errorMessageVisible = false,
        progressBarVisible = false,
        sendButtonEnabled = false)
    }

    private fun buildStateWhenSendClicked(currentState: MessageViewState): MessageViewState {
        return currentState.copy(
            errorMessageVisible = false,
            progressBarVisible = true,
            sendButtonEnabled = false
        )
    }

    private fun buildStateWhenTextChanged(
        currentState: MessageViewState,
        action: MessageAction.MessageTextChanged
    ): MessageViewState {
        return currentState.copy(
            message = action.message,
            sendButtonEnabled = action.message.isNotEmpty(),
            errorMessageVisible = false,
            progressBarVisible = false,
        )
    }
}