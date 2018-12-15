package com.example.usrdel.a2018movilesgr2

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(
                R.layout.fragment_blank, // XML A USARSE
                container,
                false
        )

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("fragmentos","On Attach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("fragmentos","On ActivityCreated")
        if (arguments!=null){
            Log.i("fragmentos",arguments!!.getString("nombre"))
            txt_view_primer_fragmento.text = arguments!!.getString("nombre")

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragmentos","On Start")

    }

}
