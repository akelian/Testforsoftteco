package by.softteco.nmisko.testforsoftteco.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.softteco.nmisko.testforsoftteco.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, MenuFragment()).commit()
    }
}