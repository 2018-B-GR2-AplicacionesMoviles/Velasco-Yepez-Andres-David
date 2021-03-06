package com.example.andres.ezmoviesadmin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beust.klaxon.Klaxon
import com.beust.klaxon.TypeFor
import com.example.andres.ezmoviesadmin.BDD.Companion.comentarios
import com.github.kittinunf.fuel.httpGet

import com.example.andres.ezmoviesadmin.dummy.ComentarioContent
import com.github.kittinunf.result.Result

import java.util.ArrayList


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ComentarioFragment.OnListFragmentInteractionListener] interface.
 */
class ComentarioFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComentarios(comentarios)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_comentario_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyComentarioRecyclerViewAdapter(ComentarioContent.ITEMS, listener)
            }
        }
        return view
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    fun getComentarios(comentarios: ArrayList<Comentario>){
        val url = "http://172.29.65.234:1337/Comentario"
        url.httpGet().responseString{request, response, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                }
                is Result.Success -> {
                    val data = result.get()
                    comentarios.clear()
                    val wordDict = Klaxon().parseArray<Comentario>(data)
                    Log.i("http", "Datos: ${wordDict.toString()}")
                    if (wordDict != null) {
                        for ( coment in wordDict.iterator()){
                                comentarios.add(coment)
                        }
                    }

                }
            }

        }
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Comentario?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                ComentarioFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
