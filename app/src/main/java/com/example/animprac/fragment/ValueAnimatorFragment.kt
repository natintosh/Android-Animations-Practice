package com.example.animprac.fragment

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.animprac.R


class ValueAnimatorFragment : Fragment() {

    private lateinit var valueAnimator: ValueAnimator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_value_animator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val expandImageView = view.findViewById<ImageView>(R.id.value_animator_expand_image_view)

        valueAnimator = ValueAnimator.ofFloat(0f, -100f, 0f).apply {
            interpolator = AnticipateOvershootInterpolator()
            duration = 1000
            start()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            addUpdateListener {
                expandImageView.translationY = it.animatedValue as Float
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        valueAnimator.apply {
            cancel()
        }
    }
}
