package zuper.dev.android.dashboard.ui.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import zuper.dev.android.dashboard.R
import zuper.dev.android.dashboard.ui.theme.TitleBlack
import zuper.dev.android.dashboard.ui.view.components.GreetingCard
import zuper.dev.android.dashboard.ui.view.components.InvoiceStatsCard
import zuper.dev.android.dashboard.ui.view.components.JobStatsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column() {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            ),
            title = {
                Text(
                    text = stringResource(R.string.dashboard),
                    style = MaterialTheme.typography.titleMedium.copy(TitleBlack),
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray
            )

            GreetingCard()
            JobStatsCard(navHostController)
            InvoiceStatsCard()
        }
    }
}
