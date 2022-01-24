package by.softteco.nmisko.testforsoftteco.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.databinding.FragmentUserDetailsBinding
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.testforsoftteco.ui.activity.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UserDetailsFragment : Fragment() {
    private var _binding : FragmentUserDetailsBinding? = null
    private val binding = _binding!!

    private val mainViewModel : MainViewModel by activityViewModels()
    private lateinit var user : User

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.myToolbar)

        val userId = arguments?.getInt("userId") as Int
        val postId = arguments?.getInt("postId") as Int

        CoroutineScope(Dispatchers.Main).launch{
            CoroutineScope(Dispatchers.IO).launch{
                mainViewModel.fetchUserById(userId)
            }.join()
            user = mainViewModel.getUser()
            withContext(Dispatchers.Main){
                setupUI(user, postId)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupUI(user: User, postId : Int) {
       with(binding) {
            this.postId.text = postId.toString()
            userName.text = user.name
           userNickName.text = user.username
           userEmail.text = user.email
           userSite.text = user.website
           userPhoneNumber.text = user.phone
           userCity.text = "city"
        }
    }
}