package com.example.animprac.fragment


import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.animprac.R

class AnimatorSetFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animator_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val helloTextView = view.findViewById<TextView>(R.id.animator_set_hello_text_view)

        val animatorSet = AnimatorInflater.loadAnimator(context, R.animator.animator_set1) as AnimatorSet
        animatorSet.apply {
            setTarget(helloTextView)
            start()
        }
    }

}
