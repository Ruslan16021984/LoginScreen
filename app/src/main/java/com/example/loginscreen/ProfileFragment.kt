package com.example.loginscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    private lateinit var mActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = activity as MainActivity
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val tvSurname = view.tvSurname
        val tvName = view.tvName
        val tvPhoneNumber = view.etPhoneNumber
       (activity as MainActivity).userViewModel?.getUse()?.subscribe ({
           tvSurname.setText(it?.secondName)
           tvName.setText(it?.name)
           tvPhoneNumber.setText(it?.phoneNumber)
       },{

       })

        return view
    }
}