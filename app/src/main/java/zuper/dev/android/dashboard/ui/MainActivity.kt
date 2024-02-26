package zuper.dev.android.dashboard.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import zuper.dev.android.dashboard.R
import zuper.dev.android.dashboard.ui.theme.AppTheme
import zuper.dev.android.dashboard.ui.view.screens.HomeScreen
import zuper.dev.android.dashboard.ui.view.screens.JobScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTheme {
                NavHost(
                    navController = navController,
                    startDestination = getString(R.string.home)
                ) {
                    composable(getString(R.string.home)) {
                        HomeScreen(navController)
                    }
                    composable(getString(R.string.jobscreen)) {
                        JobScreen(navController)
                    }
                }
            }
        }
    }
}
