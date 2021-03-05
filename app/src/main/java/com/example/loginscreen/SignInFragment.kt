package com.example.loginscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.etPhoneNumber
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

class SignInFragment : Fragment() {
    private lateinit var mActivity: MainActivity
    private lateinit var countryCodePicker: CountryCodePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = activity as MainActivity
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val ccp = view.ccp
        val btnSingIn = view.btnSingIn
        val tvName = view.etPhoneNumber
        val tvPassword = view.tvPassword
        btnSingIn.setOnClickListener {
            val code = ccp.selectedCountryCodeWithPlus
           (activity as MainActivity).userViewModel?.postUser(
                code,
                tvName.text.toString().trim().replace(" ", ""),
                tvPassword.text.toString()
            )

        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ccp.registerCarrierNumberEditText(etPhoneNumber)
        (activity as MainActivity).userViewModel?.getLiveDataItem()?.observe(requireActivity(), Observer{
            Log.e("onActivityCreated", " --------${it.userId}")
            if (it.userId.isNotEmpty()){
                findNavController().navigate(R.id.action_signInFragment_to_profileFragment)
            }
        })
//        ccp.fullNumber

    }

}