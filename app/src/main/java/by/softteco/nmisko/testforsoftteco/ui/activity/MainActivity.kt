package by.softteco.nmisko.testforsoftteco.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.softteco.nmisko.testforsoftteco.App
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.databinding.ActivityMainBinding
import by.softteco.nmisko.testforsoftteco.di.ApplicationComponent
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    lateinit var navController: NavController
    lateinit var appComponent: ApplicationComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

     private val mainViewModel: MainViewModel by viewModels{viewModelFactory}


    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.e("setupUI Activity")
        appComponent = (applicationContext as App).getComponent()
        appComponent.inject(this)
        appComponent.inject(mainViewModel)

        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCenter.start(application, "cb0e6574-15c8-4c2a-a052-4e9ecf958818",
            Analytics::class.java, Crashes::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController

    }


}