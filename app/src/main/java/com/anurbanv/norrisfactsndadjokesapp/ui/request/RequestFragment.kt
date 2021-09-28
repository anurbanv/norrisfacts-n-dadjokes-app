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
import com.anurbanv.norrisfactsndadjokesapp.R
import com.anurbanv.norrisfactsndadjokesapp.databinding.FragmentRequestBinding
import kotlinx.coroutines.launch

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
        when (args.requestType) {
            RequestType.NORRIS_FACT -> {
                updateTitle(getString(R.string.title_chuck_norris))
                updateButtonText(getString(R.string.btn_request_text_norris))
            }
            RequestType.DAD_JOKE -> {
                updateTitle(getString(R.string.title_dad_joke))
                updateButtonText(getString(R.string.btn_request_text_dad))
            }
        }

        viewModel.getResultString().observe(viewLifecycleOwner, { updateResultString(it) })

        viewModel.getErrorString().observe(viewLifecycleOwner, { updateErrorString(it) })

        binding.btnRequest.setOnClickListener {
            updateLoadingVisibility(true)
            lifecycleScope.launch { viewModel.requestApi() }
        }
    }

    private fun updateTitle(title: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = title
    }

    private fun updateButtonText(text: String) {
        binding.btnRequest.text = text
    }

    private fun updateLoadingVisibility(isVisible: Boolean) {
        binding.loadingGroup.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    private fun updateResultString(result: String) {
        updateLoadingVisibility(false)
        with(binding.tvResultText) {
            visibility = View.VISIBLE
            text = result
        }
    }

    private fun updateErrorString(error: String) {
        updateLoadingVisibility(false)

        val errorEmpty = error.isNotBlank()

        binding.tvResultText.visibility = if (errorEmpty) View.GONE else View.VISIBLE
        binding.tvErrorText.visibility = if (errorEmpty) View.VISIBLE else View.GONE
        binding.tvErrorText.text = error
    }
}