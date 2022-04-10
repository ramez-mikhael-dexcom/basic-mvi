package com.ramezmikhael.mvibasicexample.model

data class MessageViewState(
    val message: String = "",
    val errorMessage: String = "",
    val errorMessageVisible: Boolean = false,
    val progressBarVisible: Boolean = false,
    val sendButtonEnabled: Boolean = false,
)