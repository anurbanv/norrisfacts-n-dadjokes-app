package com.anurbanv.norrisfactsndadjokesapp.ui.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.anurbanv.norrisfactsndadjokesapp.databinding.FragmentRequestBinding
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestFragment : Fragment() {

    private val args: RequestFragmentArgs by navArgs()
    private val viewModel: RequestViewModel by viewModels {
        RequestViewModelFactory(args.requestType)
    }

    private lateinit var binding: FragmentRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            if (viewModel.isResultEmpty()) {
                viewModel.requestApi()
            }

            withContext(Main) {
                viewModel.getResultString().observe(viewLifecycleOwner, { updateResultString(it) })
            }
        }

        when (args.requestType) {
            RequestType.NORRIS_FACT -> updateTitle("Fact")
            RequestType.DAD_JOKE -> updateTitle("Joke")
        }
    }

    private fun updateTitle(title: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }

    private fun updateResultString(result: String) {
        binding.loadingGroup.visibility = View.GONE
        with(binding.tvResultText) {
            visibility = View.VISIBLE
            text = result
        }
    }
}