package com.example.loginscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    private lateinit var mActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = activity as MainActivity
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val tvSurname = view.tvSurname
        val tvName = view.tvName
        val tvPhoneNumber = view.etPhoneNumber
       var user = (activity as MainActivity).userViewModel?.getUse()
        tvSurname.setText(user?.secondName)
        tvName.setText(user?.name)
        tvPhoneNumber.setText(user?.phoneNumber)
        return view
    }
}