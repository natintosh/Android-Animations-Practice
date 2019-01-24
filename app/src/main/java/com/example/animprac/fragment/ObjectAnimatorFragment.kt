package com.example.animprac.fragment


import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.animprac.R


class ObjectAnimatorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_object_animator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val helloText = view.findViewById<TextView>(R.id.object_animator_hello_text_view)

        ObjectAnimator.ofFloat(helloText, "rotation", 0f, 360f).apply {
            repeatCount = -1
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
    }

}
