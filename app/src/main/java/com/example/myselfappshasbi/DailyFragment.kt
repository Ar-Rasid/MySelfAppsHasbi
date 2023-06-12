package com.example.myselfappshasbi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DailyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private val itemList = listOf(
        CustomAdapter.Item("Tidur", R.drawable.daily_tidur),
        CustomAdapter.Item("Makan", R.drawable.daily_makan),
        CustomAdapter.Item("Olahraga", R.drawable.daily_olahraga),
        CustomAdapter.Item("Belajar", R.drawable.daily_belajar),
        CustomAdapter.Item("Coding", R.drawable.daily_coding),
        CustomAdapter.Item("Kuliah", R.drawable.daily_kuliah),
        CustomAdapter.Item("Main Game", R.drawable.daily_game)
    )

    private lateinit var recyclerViewFriend: RecyclerView
    private lateinit var adapterFriend: CustomAdapterFriend
    private val itemListFriend = listOf(
        CustomAdapter.Item("Arby Febrian S", R.drawable.foto_arby),
        CustomAdapter.Item("Muhammad Hilman R", R.drawable.foto_hilman),
        CustomAdapter.Item("Stanislaus Katska Alvin P.S", R.drawable.foto_alvin),
        CustomAdapter.Item("Zulfikar Azizan", R.drawable.foto_zulfikar)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)

        recyclerView = view.findViewById(R.id.recycleViewDaily)
        adapter = CustomAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerViewFriend = view.findViewById(R.id.recycleViewFriend)
        adapter = CustomAdapter(itemListFriend)
        recyclerViewFriend.adapter = adapter
        recyclerViewFriend.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerViewFriend)

        return view


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DailyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DailyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}