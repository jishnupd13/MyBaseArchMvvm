package com.app.mybaseapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.app.mybaseapp.R
import com.app.mybaseapp.databinding.FragmentHomeBinding
import com.app.mybaseapp.models.user_details.UserDetailsResponse
import com.app.mybaseapp.ui.home.viewmodel.HomeViewModel
import com.app.mybaseapp.utils.EMPTY
import com.app.mybaseapp.utils.NetworkResult
import com.app.mybaseapp.utils.USER_ID
import com.app.mybaseapp.utils.hide
import com.app.mybaseapp.utils.show
import com.app.mybaseapp.utils.toast
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment:Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userDetailsFlow.collect {
                    when(it) {

                        is NetworkResult.Loading->{
                            binding.progressCircular.show()
                        }

                        is NetworkResult.Success->{
                            binding.progressCircular.hide()
                            bind(it.data)
                        }

                        is NetworkResult.Error->{
                            binding.progressCircular.hide()
                            toast(it.exception.message.toString())
                        }
                    }
                }
            }
        }
    }


    private fun bind(data: UserDetailsResponse?) = binding.apply{

        textFirstNameValue.text = data?.data?.firstName ?: EMPTY
        textLastNameValue.text = data?.data?.lastName ?: EMPTY
        textLastEmailValue.text = data?.data?.email ?: EMPTY

        Glide
            .with(this@HomeFragment)
            .load(data?.data?.avatar?: EMPTY)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(imgUser)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchUserDetails(USER_ID)
    }

}