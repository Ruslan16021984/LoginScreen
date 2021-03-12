package com.example.loginscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.loginscreen.domain.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

class SignInFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val ccp = view.ccp
        val btnSingIn = view.btnSingIn
        val tvName = view.etPhoneNumber
        val tvPassword = view.tvPassword
        btnSingIn.setOnClickListener {
            val code = ccp.selectedCountryCodeWithPlus
           viewModel.postUser(
                code,
                tvName.text.toString().trim().replace(" ", ""),
                tvPassword.text.toString()
            )

        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ccp.registerCarrierNumberEditText(etPhoneNumber)
        viewModel.getLiveDataItem().observe(viewLifecycleOwner, Observer{
            if (it.userId.isNotEmpty()){
                findNavController().navigate(R.id.action_signInFragment_to_profileFragment)
            }
        })
    }

}