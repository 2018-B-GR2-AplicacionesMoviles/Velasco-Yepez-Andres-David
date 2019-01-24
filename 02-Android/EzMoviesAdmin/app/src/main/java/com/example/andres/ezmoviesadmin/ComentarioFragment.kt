package com.example.andres.ezmoviesadmin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.JsonReader
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andres.ezmoviesadmin.BDD.Companion.comentarios
import com.github.kittinunf.fuel.httpGet

import com.example.andres.ezmoviesadmin.dummy.ComentarioContent
import com.github.kittinunf.result.success
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.StringReader
import java.util.ArrayList
import com.google.gson.JsonParser
import com.google.gson.JsonElement




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
        getComentarios()
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


    fun getComentarios(){
        val url = "http://192.168.1.52:1337/Comentario"
        url.httpGet().responseString{request, response, result ->
            //Log.i("http","Request: $request")
            ///Log.i("http","Request: $response")
            Log.i("http-r","Request: ${result}")
            //val resultado = JsonParser().parse(result.toString())
            //var jobject = resultado.getAsJsonObject()
            //jobject = jobject.getAsJsonObject("Success")
            //Log.i("http-a","Request: ${jobject}")

           // comentarios.clear()
            //val gson = Gson()
            //comentarios = gson.fromJson(result.toString(), ArrayList<Comentario>()::class.java)
            //Log.i("http-a","${comentarios}")

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
