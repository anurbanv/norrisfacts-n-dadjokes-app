package com.anurbanv.norrisfactsndadjokesapp.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.anurbanv.norrisfactsndadjokesapp.databinding.FragmentLandingBinding
import com.anurbanv.norrisfactsndadjokesapp.ui.request.RequestType

class LandingFragment : Fragment() {

    private lateinit var binding: FragmentLandingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNorrisFacts.setOnClickListener {
            val action = LandingFragmentDirections.showRequestFragment(RequestType.NORRIS_FACT)
            Navigation.findNavController(view).navigate(action)
        }

        binding.btnDadJokes.setOnClickListener {
            val action = LandingFragmentDirections.showRequestFragment(RequestType.DAD_JOKE)
            Navigation.findNavController(view).navigate(action)
        }
    }
}