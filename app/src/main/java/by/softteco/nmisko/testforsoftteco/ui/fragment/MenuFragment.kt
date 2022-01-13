package by.softteco.nmisko.testforsoftteco.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.databinding.FragmentMenuBinding
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import kotlinx.coroutines.*


class MenuFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         mainViewModel.fetchPosts()

        setupUI()
    }

    private fun setupUI() {
        binding.imageView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        with(binding) {
            when (p0) {
                imageView -> {
                    CoroutineScope(Dispatchers.Main).launch {
                        savelog.visibility = View.GONE
                        imageView.isClickable = false
                        imageView.isEnabled = false
                        animateView(p0)
                        delay(1500)
                        withContext(Dispatchers.Main) {
                            delay(200)
                            savelog.visibility = View.VISIBLE
                            imageView.isClickable = true
                            imageView.isEnabled = true
                        }
                    }
                }
                else -> {}
            }
        }
    }

    private fun animateView(view: View) {
        view.visibility = View.INVISIBLE
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_fade)
        view.startAnimation(animation)
        view.visibility = View.VISIBLE

    }
}