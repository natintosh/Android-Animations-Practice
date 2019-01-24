package com.example.animprac.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animprac.R
import com.example.animprac.adapter.MainAdapter

class MainFragment : Fragment(), MainAdapter.SetOnListAdapterListener {

    private lateinit var list: MutableList<String>
    private var listener: MainFragmentListener? = null

    override fun onListItemClick(position: Int) {
        onItemClick(position)
    }

    private fun onItemClick(position: Int) {
        listener?.onListItemClick(position)
    }

    private fun onFragmentResume() {
        listener?.onMainFragmentResume()
    }

    interface MainFragmentListener {
        fun onListItemClick(position: Int)
        fun onMainFragmentResume()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addItemToList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.main_recycler_view)
        recyclerView.apply {
            adapter = MainAdapter(list, this@MainFragment)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onResume() {
        super.onResume()
        onFragmentResume()
    }

    private fun addItemToList() {
        list = ArrayList()
        list.add("Value Animator")
        list.add("Object Animator")
        list.add("Animator Set")
        list.add("StateList Animator")
        list.add("Animation Drawable")
        list.add("Animated Vector Drawable")
        list.add("Circular Review Animation")
    }

}