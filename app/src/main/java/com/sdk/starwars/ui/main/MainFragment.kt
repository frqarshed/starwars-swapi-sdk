package com.sdk.starwars.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sdk.starwars.R
import com.sdk.starwars.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewBinding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = MainFragmentBinding.bind(view)

        val nameObserver = Observer<String> { newMessage ->
            viewBinding.message.text = newMessage
        }

        viewModel.message.observe(viewLifecycleOwner, nameObserver)

        viewBinding.button.setOnClickListener {
            viewModel.buttonClicked()
        }
    }

}