package com.example.animprac.fragment


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.animprac.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CircularRevealFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_circular_reveal, container, false)
    }

    private lateinit var viewLayout: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLayout = view.findViewById(R.id.circular_reveal_view_layout)
        val fab = view.findViewById<FloatingActionButton>(R.id.circular_reveal_fab).apply {
            setOnClickListener {
                val cx: Int = it.x.toInt()
                val cy: Int = it.y.toInt()
                revealViewLayout(cx, cy)
            }
        }
    }

    private fun revealViewLayout(x: Int, y: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cx = x
            val cy = y

            val finalRadius =
                Math.hypot((viewLayout.width).toDouble(), (viewLayout.height).toDouble()).toFloat()

            val anim = ViewAnimationUtils.createCircularReveal(viewLayout, cx, cy, 0f, finalRadius)
            viewLayout.visibility = View.VISIBLE
            anim.duration = 1000
            anim.interpolator = FastOutSlowInInterpolator()
            anim.start()
        } else {
            viewLayout.visibility = View.VISIBLE
        }
    }
}
