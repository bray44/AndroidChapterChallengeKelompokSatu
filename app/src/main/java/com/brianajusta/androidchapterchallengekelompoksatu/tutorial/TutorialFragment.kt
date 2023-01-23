package com.brianajusta.androidchapterchallengekelompoksatu.tutorial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.FragmentTutorialBinding

private const val ARG_TITLE = "TITLE"
private const val ARG_CONTENT = "CONTENT"

class TutorialFragment : Fragment() {
    companion object {
        fun newInstance(title: String, content: String) =
            TutorialFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_CONTENT, content)
                }
            }
    }

    private lateinit var binding: FragmentTutorialBinding
    private var title: String? = null
    private var content: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LearningApp", "${this.javaClass.simpleName}:onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LearningApp", "${this.javaClass.simpleName}:onCreate")

        arguments?.let {
            title = it.getString(ARG_TITLE)
            content = it.getString(ARG_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("LearningApp", "${this.javaClass.simpleName}:onCreateView")
        binding = FragmentTutorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LearningApp", "${this.javaClass.simpleName}:onViewCreated")

        title?.let {
            binding.tvTutorialTitle.text = it
        }

        content?.let {
            binding.tvTutorialContent.text = it
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LearningApp", "${this.javaClass.simpleName}:onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LearningApp", "${this.javaClass.simpleName}:onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LearningApp", "${this.javaClass.simpleName}:onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("LearningApp", "${this.javaClass.simpleName}:onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LearningApp", "${this.javaClass.simpleName}:onDestroy")
    }

}