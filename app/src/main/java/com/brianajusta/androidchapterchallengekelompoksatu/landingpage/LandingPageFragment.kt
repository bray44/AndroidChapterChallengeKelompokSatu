package com.brianajusta.androidchapterchallengekelompoksatu.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import com.brianajusta.androidchapterchallengekelompoksatu.LoginScreen
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.FragmentLandingPageBinding

private const val ARG_IMG = "IMAGE"
private const val ARG_EDIT_TEXT = "TITLE"
private const val ARG_BTN_VISIBLITY = "VISIBILITY"

class LandingPageFragment : Fragment() {
    private lateinit var binding: FragmentLandingPageBinding
    companion object {
        @JvmStatic
        fun newInstance(imageResource: Int, text: String,visibility: Boolean) =
            LandingPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMG, imageResource)
                    putString(ARG_EDIT_TEXT, text)
                    putBoolean(ARG_BTN_VISIBLITY,visibility)
                }
            }
    }
    private var imageResource: Int? = null
    private var text: String? = null
    private var buttonVisibility: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResource = it.getInt(ARG_IMG)
            text = it.getString(ARG_EDIT_TEXT)
            buttonVisibility = it.getBoolean(ARG_BTN_VISIBLITY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandingPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivNext.setOnClickListener{
            val intent = Intent(activity,LoginScreen::class.java)
            startActivity(intent)
        }
        binding.ivNext.visibility = buttonVisibility
        binding.tvLpDesc.text = text
        imageResource.let {
            if (it != null) {
                binding.ivLpImage.setImageResource(it)
            }
        }
    }
    fun visibility(){
        val invisible = buttonVisibility
        binding.ivNext
    }

}