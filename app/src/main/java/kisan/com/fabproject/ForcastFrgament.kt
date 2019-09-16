package kisan.com.fabproject

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_forcast_frgament.*

// forcast fragment for forcast data
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ForcastFrgament.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ForcastFrgament.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ForcastFrgament : Fragment() {
    // TODO: Rename and change types of parameters
    private var list: ArrayList<ForcastModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            list = it.getParcelableArrayList(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forcast_frgament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ForcastAdapter(list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = adapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters as list of forcast model.
         *
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(list : ArrayList<ForcastModel>) =
                ForcastFrgament().apply {
                    arguments = Bundle().apply {
                        putParcelableArrayList(ARG_PARAM1, list)

                    }
                }
    }
}
