package com.ramezmikhael.mvibasicexample.intent

sealed class MessageAction {
    class MessageTextChanged(val message: String): MessageAction()
    object SendClicked: MessageAction()
    object SendFinished: MessageAction()
    class Error(val errorMessage: String): MessageAction()
}