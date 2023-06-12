package com.example.myselfappshasbi


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerViewMusic: RecyclerView
    private lateinit var adapterMusic: CustomAdapterMusic
    private val itemListMusik = listOf(
        CustomAdapter.Item("Menjadi Dia - Tiara Andini", R.drawable.music),
        CustomAdapter.Item("Tak Segampang Itu - Anggi Mardito", R.drawable.music),
        CustomAdapter.Item("Ego - Lydora", R.drawable.music),
        CustomAdapter.Item("Usai - Tiara Andini", R.drawable.music),
        CustomAdapter.Item("Meresa Indah - Tiara Andini", R.drawable.music),
        CustomAdapter.Item("Janji Setia - Tiara Andini", R.drawable.music),
        CustomAdapter.Item("Jadi Kekasihku Saja - Keisya Levronka", R.drawable.music),
        CustomAdapter.Item("Piliha Yang Terbaik - Ziva Mgnolya", R.drawable.music),
        CustomAdapter.Item("Tanpa Cinta - Yovie & Nuno", R.drawable.music),
        CustomAdapter.Item("Menjaga Hati - Yovie & Nuno", R.drawable.music),
        CustomAdapter.Item("Putri Iklan - ST12", R.drawable.music),
        CustomAdapter.Item("Ego - Lydora", R.drawable.music),
        CustomAdapter.Item("Dia Miliku - Yovie & Nuno", R.drawable.music),
        CustomAdapter.Item("Cari Pacar Lagi - ST12", R.drawable.music),
        CustomAdapter.Item("Dekat Di Hati - RAN", R.drawable.music),
        CustomAdapter.Item("Sial - Mahalini", R.drawable.music)
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

        val view = inflater.inflate(R.layout.fragment_music, container, false)

        recyclerViewMusic = view.findViewById(R.id.recycleViewMusic)
        adapterMusic = CustomAdapterMusic(itemListMusik)
        recyclerViewMusic.adapter = adapterMusic
        recyclerViewMusic.layoutManager = LinearLayoutManager(requireContext())

        val videoView = view.findViewById<VideoView>(R.id.video)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.menjadi_dia

        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.requestFocus()
        videoView.start()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}