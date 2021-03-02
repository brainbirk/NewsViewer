package dk.shantech.newsviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import dk.shantech.newsviewer.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

//    private val navController by lazy {
//        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
               val navController = findNavController(R.id.nav_host_fragment)


//        NavigationUI.setupWithNavController(navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Log.d("Here", "onCreate: $destination")
//            when(destination.id) {
//                R.id.splashFragment, R.id.onboardingFragment, R.id.loginFragment, R.id.navigation_short_notification -> {
//                    navView.visibility = View.GONE
//                    navViewLine.visibility = View.INVISIBLE
//                }
//                else -> {
//                    navView.visibility = View.VISIBLE
//                    navViewLine.visibility = View.VISIBLE
//                }
//            }

        }
    }
}