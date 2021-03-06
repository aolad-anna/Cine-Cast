package com.example.kitkat_movie.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.kitkat_movie.R

class OnboardingFragment : Fragment() {
    private var title: String? = null
    private var description: String? = null
    private var imageResource = 0
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var image: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            title = requireArguments().getString(ARG_PARAM1)
            description = requireArguments().getString(ARG_PARAM2)
            imageResource = requireArguments().getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootLayout: View =
            inflater.inflate(R.layout.fragment_onboarding1, container, false)
        image = rootLayout.findViewById<View>(R.id.image_onboarding) as LottieAnimationView
        tvTitle = rootLayout.findViewById<View>(R.id.text_onboarding_title) as TextView
        tvDescription = rootLayout.findViewById<View>(R.id.text_onboarding_description) as TextView
        tvTitle.text = title
        tvDescription.text = description
        image.setAnimation(imageResource)
        return rootLayout
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        fun newInstance(
            title: String?,
            description: String?,
            imageResource: Int
        ): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, title)
            args.putString(ARG_PARAM2, description)
            args.putInt(ARG_PARAM3, imageResource)
            fragment.arguments = args
            return fragment
        }
    }
}
