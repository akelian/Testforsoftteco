package by.softteco.nmisko.testforsoftteco.ui.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.softteco.nmisko.domain.model.Address
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.testforsoftteco.databinding.FragmentUserDetailsBinding
import by.softteco.nmisko.testforsoftteco.ui.activity.MainActivity
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import com.github.hariprasanths.bounceview.BounceView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber


class UserDetailsFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var user: User

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

        CoroutineScope(Dispatchers.Main).launch {
            CoroutineScope(Dispatchers.IO).launch {
                mainViewModel.fetchUserById(userId)
            }.join()
            user = mainViewModel.getUser()
            withContext(Dispatchers.Main) {
                setupUI(user, postId)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupUI(user: User, postId: Int) {
        with(binding) {
            this.postId.text = postId.toString()
            userName.text = user.name
            userNickName.text = user.username
            userEmail.text = user.email
            userSite.text = user.website
            userPhoneNumber.text = user.phone
            userCity.text = user.address.street
            myToolbar.title = "Contact #" + user.id

            userEmail.setOnClickListener(this@UserDetailsFragment)
            userSite.setOnClickListener(this@UserDetailsFragment)
            userPhoneNumber.setOnClickListener(this@UserDetailsFragment)
            userCity.setOnClickListener(this@UserDetailsFragment)
            saveUserInDb.setOnClickListener(this@UserDetailsFragment)
        }
    }

    override fun onClick(p0: View?) {
        with(binding) {
            when (p0) {
                userEmail -> startEmailActivity(user.email)
                userSite -> startWebSiteActivity(user.website)
                userPhoneNumber -> startCallActivity(user.phone)
                userCity -> startMapActivity(user.address)
                saveUserInDb -> {
                    BounceView.addAnimTo(p0)
                    CoroutineScope(Dispatchers.IO).launch{
                        saveUserInDb(user)
                        withContext(Dispatchers.Main){
                            Timber.e(getUserFromRoom(user.id).name)
                            Toast.makeText(activity?.applicationContext, "${user.name} saved in db", Toast.LENGTH_LONG).show()
                        }

                    }
                }
                else -> {}
            }
        }
    }

    private suspend fun saveUserInDb(user: User) {
            mainViewModel.insertUserInDb(user)
    }

    private suspend fun getUserFromRoom(id : Int) = mainViewModel.getUserByIdFromRoom(id)


    private fun startMapActivity(address: Address) {
        val geoLocation =
            Uri.parse("geo:${address.geo.lat},${address.geo.lng}?z=1&q=${address.geo.lat},${address.geo.lng}(${address.street})")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        startActivity(intent)
    }

    private fun startCallActivity(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)

    }

    private fun startWebSiteActivity(website: String) {
        var editedWeb: String = website
        if (!website.startsWith("http://") && !website.startsWith("https://")) {
            editedWeb = "http://$website"
        }
        val webpage: Uri = Uri.parse(editedWeb)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        startActivity(intent)

    }

    private fun startEmailActivity(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        startActivity(intent)
    }
}