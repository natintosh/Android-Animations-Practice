package com.example.animprac.fragment


import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.animprac.R

class AnimatedVectorDrawableFragment : Fragment() {


    private lateinit var playAnimation: AnimatedVectorDrawableCompat

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playAnimation = context?.let { AnimatedVectorDrawableCompat.create(it, R.drawable.anim_play_pause) }!!
        var animate: Animatable;
        val playImageVIew = view.findViewById<ImageView>(R.id.anim_vector_play_image_view).apply {
            setImageDrawable(playAnimation)
            animate = drawable as Animatable
        }
        animate.start()
    }
}
