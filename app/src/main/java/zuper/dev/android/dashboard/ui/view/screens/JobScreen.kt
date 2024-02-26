package zuper.dev.android.dashboard.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch
import zuper.dev.android.dashboard.R
import zuper.dev.android.dashboard.data.model.JobApiModel
import zuper.dev.android.dashboard.data.model.JobStatus
import zuper.dev.android.dashboard.ui.theme.BGLightGrey
import zuper.dev.android.dashboard.ui.theme.TitleBlack
import zuper.dev.android.dashboard.ui.view.components.JobChart
import zuper.dev.android.dashboard.ui.view.components.JobItemCard
import zuper.dev.android.dashboard.ui.viewmodels.JobViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobScreen(navHostController: NavHostController, jobViewModel: JobViewModel = hiltViewModel()) {
    val jobsState by jobViewModel.jobsState.observeAsState()
    val coroutineScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }

    Column() {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = White
            ),
            title = {
                Text(
                    text = stringResource(R.string.jobs_count, jobsState?.size ?: 0),
                    style = MaterialTheme.typography.titleMedium.copy(TitleBlack),
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navHostController.popBackStack()
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                }
            }
        )
        SwipeRefresh(
            modifier = Modifier.fillMaxSize(),
            state = rememberSwipeRefreshState(isRefreshing = refreshing),
            onRefresh = {
                refreshing = true
                coroutineScope.launch {
                    jobViewModel.refreshJobs()
                    refreshing = false
                }
            },
        ) {
            Column {

                jobsState?.let { jobList ->
                    if (jobList.isEmpty()) {
                        Text(
                            text = stringResource(R.string.no_jobs_available),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    } else {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Color.LightGray
                        )
                        JobChart(jobs = jobList)
                        JobTabs(jobs = jobList)
                    }
                }
            }
        }
    }
}

@Composable
fun JobTabs(jobs: List<JobApiModel>) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val titles = listOf(
        stringResource(R.string.yet_to_start, jobs.count { it.status == JobStatus.YetToStart }),
        stringResource(R.string.in_progress_, jobs.count { it.status == JobStatus.InProgress }),
        stringResource(R.string.cancelled, jobs.count { it.status == JobStatus.Cancelled }),
        stringResource(R.string.completed, jobs.count { it.status == JobStatus.Completed }),
        stringResource(R.string.in_complete, jobs.count { it.status == JobStatus.Incomplete })
    )

    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            containerColor = BGLightGrey,
            contentColor = TitleBlack,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(2.dp)
                        .background(color = MaterialTheme.colorScheme.primary),
                    color = Color.Transparent
                )
            }

        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = {
                        Text(
                            text = title,
                        )
                    }
                )
            }
        }
        when (tabIndex) {
            in titles.indices -> JobList(jobs.filter { it.status == JobStatus.values()[tabIndex] })
        }
    }
}

@Composable
fun JobList(jobs: List<JobApiModel>) {
    if (jobs.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.no_jobs_available),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(jobs.size) { index ->
                val job = jobs[index]
                JobItemCard(job)
            }
        }
    }
}
