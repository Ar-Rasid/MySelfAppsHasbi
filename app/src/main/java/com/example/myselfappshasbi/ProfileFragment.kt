package com.example.myselfappshasbi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnClick = view.findViewById<ImageView>(R.id.instagram)
        val btnCall = view.findViewById<ImageView>(R.id.phonenumber)
        val btnWhatsApp = view.findViewById<ImageView>(R.id.whatsapp)
        val btnEmail = view.findViewById<ImageView>(R.id.email)
        val btnLinkedIn = view.findViewById<ImageView>(R.id.linkedin)
        val btnOpenMaps = view.findViewById<ImageView>(R.id.address)

        btnClick.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/muhammadhasbiarrasid?igshid=MzNlNGNkZWQ4Mg==") // Ganti dengan URL profil Instagram yang diinginkan
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.instagram.android")

            if (isIntentAvailable(intent)) {
                startActivity(intent)
            } else {
                // Jika aplikasi Instagram tidak terinstal, buka Instagram di browser
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/")))
            }
        }

        btnCall.setOnClickListener {
            val phoneNumber = "083822355426" // Ganti dengan nomor telepon yang diinginkan
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        btnWhatsApp.setOnClickListener {
            val phoneNumber = "+6283822355426" // Nomor telepon dengan kode negara
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val email = "muhammadhasbiarrasid@gmail.com" // Alamat email yang dituju
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:$email")
            startActivity(intent)
        }

        btnLinkedIn.setOnClickListener {
            val linkedInProfileUrl = "https://www.linkedin.com/in/your-linkedin-profile" // Ganti dengan URL profil LinkedIn Anda
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(linkedInProfileUrl)
            startActivity(intent)
        }

        btnOpenMaps.setOnClickListener {
            val latitude = -7.035860
            val longitude = 107.515536
            val label = "Soreang, Kabupaten Bandung"

            val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($label)")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        return view
    }

    private fun isIntentAvailable(intent: Intent): Boolean {
        val packageManager = requireActivity().packageManager
        val activities = packageManager.queryIntentActivities(intent, 0)
        return activities.size > 0
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        private const val REQUEST_PHONE_CALL = 1
    }
}