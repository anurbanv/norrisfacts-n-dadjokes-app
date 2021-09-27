package com.anurbanv.norrisfactsndadjokesapp.ui.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.anurbanv.norrisfactsndadjokesapp.databinding.FragmentRequestBinding

class RequestFragment : Fragment() {

    private val args: RequestFragmentArgs by navArgs()

    private lateinit var binding: FragmentRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (args.requestType) {
            RequestType.NORRIS_FACT -> {
                updateTitle("Fact")
            }
            RequestType.DAD_JOKE -> {
                updateTitle("Joke")
            }
        }
    }

    private fun updateTitle(title: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }
}