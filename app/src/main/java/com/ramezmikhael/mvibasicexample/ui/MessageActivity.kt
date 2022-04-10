package com.ramezmikhael.mvibasicexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.ramezmikhael.mvibasicexample.databinding.ActivityMessageBinding
import com.ramezmikhael.mvibasicexample.model.MessageViewState
import kotlinx.coroutines.launch

class MessageActivity : AppCompatActivity() {

    lateinit var binding: ActivityMessageBinding

    private val viewModel by viewModels<MessageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            messageEditText.doAfterTextChanged {
                viewModel.messageChanged(it.toString())
            }

            sendButton.setOnClickListener {

                viewModel.send()
            }
        }

        lifecycleScope.launch {
            viewModel.state.collect {
                updateUI(it)
            }
        }
    }

    private fun updateUI(state: MessageViewState) {
        with(binding) {

            if(messageEditText.text.toString() != state.message)
                messageEditText.setText(state.message)
            sendButton.isEnabled = state.sendButtonEnabled
            errorTextView.isVisible = state.errorMessageVisible
            errorTextView.text = state.errorMessage
            loadingProgressBar.isVisible = state.progressBarVisible
        }
    }
}