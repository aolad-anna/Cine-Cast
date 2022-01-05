package com.example.kitkat_movie.adapter

import android.content.Context
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitkat_movie.onboarding.OnboardingFragment
import com.example.kitkat_movie.R


class OnboardingViewPagerAdapter(
    fragmentActivity: com.example.kitkat_movie.onboarding.Slider,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): androidx.fragment.app.Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                context.resources.getString(R.string.description_onboarding_1),
                R.raw.threeottie
            )
            1 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_2),
                R.raw.twolottie
            )
            else -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_3),
                R.raw.onelottie
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}