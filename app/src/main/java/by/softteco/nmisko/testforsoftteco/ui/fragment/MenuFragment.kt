package by.softteco.nmisko.testforsoftteco.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.databinding.FragmentMenuBinding
import by.softteco.nmisko.testforsoftteco.ui.activity.MainActivity
import by.softteco.nmisko.testforsoftteco.ui.adapter.PostPagerAdapter
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import com.github.hariprasanths.bounceview.BounceView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.*
import timber.log.Timber
import java.io.*
import java.lang.StringBuilder


class MenuFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    private var posts = ArrayList<Post>()

    override fun onAttach(context: Context) {
        (activity as MainActivity).appComponent.inject(this)
        super.onAttach(context)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.e(savedInstanceState?.isEmpty.toString())


        CoroutineScope(Dispatchers.Main).launch {
            if (savedInstanceState == null) {
                CoroutineScope(Dispatchers.IO).launch {

                    mainViewModel.fetchPosts()
                }.join()
            }

            posts = mainViewModel.getPosts()
            withContext(Dispatchers.Main) {
                Timber.e("setupUI MENU")
                setupUI()
            }
        }

    }

    private fun setupUI() {
        binding.imageView.setOnClickListener(this)
        binding.saveLog.setOnClickListener(this)

        val pager = binding.postsPager
        val pagerAdapter = PostPagerAdapter(this, posts)
        val tabLayout = binding.postsTabLayout
        pager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, pager) { _, _ ->

        }.attach()

    }

    override fun onClick(p0: View?) {
        with(binding) {
            when (p0) {
                imageView -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        withContext(Dispatchers.Main) {
                            saveLog.visibility = View.GONE
                            imageView.isClickable = false
                            imageView.isEnabled = false
                            animateView(p0)
                        }
                        delay(1700)
                        withContext(Dispatchers.Main) {
                            saveLog.visibility = View.VISIBLE
                            imageView.isClickable = true
                            imageView.isEnabled = true
                        }
                        readFromFile(requireContext())
                    }
                }

                saveLog -> {
                    BounceView.addAnimTo(p0)
                    CoroutineScope(Dispatchers.IO).launch{
                        saveLogInFile()
                        Timber.e("click")
                        withContext(Dispatchers.Main){
                            Toast.makeText(activity?.applicationContext, "Saved", Toast.LENGTH_SHORT).show()
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

     private fun saveLogInFile(){
        try {
            val process = Runtime.getRuntime().exec("logcat -d")
            val bufferedReader = BufferedReader(
                InputStreamReader(process.inputStream))
            val log = StringBuilder()
            var line: String? = ""
            writeToFile(line, requireContext())
            while (bufferedReader.readLine().also { line = it } != null) {
                log.append(line)
            }
            writeToFile(log.toString(), requireContext())
        } catch (e: IOException) {
        }
    }

    private fun writeToFile(data: String?, context: Context) {
        try {
            val outputStreamWriter =
                OutputStreamWriter(context.openFileOutput("log.txt", Context.MODE_PRIVATE))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
        } catch (e: IOException) {
            Timber.e("File write failed: $e")
        }
    }
    private fun readFromFile(context: Context){
        var ret = ""
        try {
            val inputStream: InputStream? = context.openFileInput("log.txt")
            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var receiveString: String?
                val stringBuilder = StringBuilder()
                while (bufferedReader.readLine().also { receiveString = it } != null) {
                    stringBuilder.append("\n").append(receiveString)
                }
                inputStream.close()
                ret = stringBuilder.toString()
            }
        } catch (e: FileNotFoundException) {
            Timber.e("File not found: $e")
        } catch (e: IOException) {
            Timber.e( "Can not read file: $e")
        }
         Timber.e(ret)
    }
}