package com.shivamsanwaria.bookworld.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.shivamsanwaria.bookworld.R

class ProfileFragment : Fragment() {

     lateinit var myProfile : TextView
     lateinit var profileImage : ImageView
     lateinit var name : TextView
     lateinit var mTextView:Button
     lateinit var MywebView:WebView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        myProfile  = view.findViewById(R.id.txtProfile)
        profileImage = view.findViewById(R.id.imgProfile)
        name = view.findViewById(R.id.txtName)
        mTextView = view.findViewById(R.id.btnLinkedin)
        mTextView.movementMethod = LinkMovementMethod.getInstance()
        MywebView = view.findViewById(R.id.Mywebview)
        MywebView.webViewClient = WebViewClient()

        MywebView.loadUrl("https://www.linkedin.com/in/shivam-sanwaria-455433207")
        // this will enable the javascript settings, it can also allow xss vulnerabilities
        MywebView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        MywebView.settings.setSupportZoom(true)
        return view

    }

}