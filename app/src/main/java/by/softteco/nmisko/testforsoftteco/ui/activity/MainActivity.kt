package by.softteco.nmisko.testforsoftteco.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.softteco.nmisko.testforsoftteco.App
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.databinding.ActivityMainBinding
import by.softteco.nmisko.testforsoftteco.di.ApplicationComponent
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import dagger.Component

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    lateinit var navController: NavController
    lateinit var appComponent: ApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        appComponent = (applicationContext as App).getComponent()
        appComponent.inject(this)

        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCenter.start(application, "62b9c125-63b2-4e03-8451-94bbf5cdf9a7",
            Analytics::class.java, Crashes::class.java)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController

    }


}