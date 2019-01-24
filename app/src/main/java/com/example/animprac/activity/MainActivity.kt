package com.example.animprac.activity

import addFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.animprac.fragment.AnimationDrawableFragment
import com.example.animprac.R
import com.example.animprac.fragment.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import replaceFragmentToStack

class MainActivity : AppCompatActivity(), MainFragment.MainFragmentListener {

    override fun onMainFragmentResume() {
        showFab()
    }

    override fun onListItemClick(position: Int) {

        hideFab()
        when (position) {
            0 -> return replaceFragmentToStack(ValueAnimatorFragment(), R.id.content_container)
            1 -> return replaceFragmentToStack(ObjectAnimatorFragment(), R.id.content_container)
            2 -> return replaceFragmentToStack(AnimatorSetFragment(), R.id.content_container)
            3 -> return replaceFragmentToStack(StateListAnimatorFragment(), R.id.content_container)
            4 -> return replaceFragmentToStack(AnimationDrawableFragment(), R.id.content_container)
            5 -> return replaceFragmentToStack(AnimatedVectorDrawableFragment(), R.id.content_container)
            6 -> return replaceFragmentToStack(CircularRevealFragment(), R.id.content_container)
            else -> return showFab()
        }
    }

    private fun showFab() {

        fab.apply {
            visibility = View.VISIBLE
        }
    }

    private fun hideFab() {

        fab.apply {
            visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        addFragment(MainFragment(), R.id.content_container)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
