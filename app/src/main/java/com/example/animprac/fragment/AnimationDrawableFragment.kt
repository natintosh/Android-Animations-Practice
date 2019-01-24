package com.example.animprac.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.animprac.R


class AnimationDrawableFragment : Fragment() {

    private lateinit var sentimentAnimation: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation_drawable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sentimentImageView = view.findViewById<ImageView>(R.id.animation_drawable_image_view).apply {
            setBackgroundResource(R.drawable.anim_ic_sentiment)
            sentimentAnimation = background as AnimationDrawable
        }

        sentimentAnimation.start()
    }

    override fun onDetach() {
        super.onDetach()
        sentimentAnimation.stop()
    }
}
