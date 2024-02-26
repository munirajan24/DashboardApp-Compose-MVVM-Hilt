package zuper.dev.android.dashboard.data.model

import zuper.dev.android.dashboard.ui.theme.Blue50
import zuper.dev.android.dashboard.ui.theme.Cyan50
import zuper.dev.android.dashboard.ui.theme.Green50
import zuper.dev.android.dashboard.ui.theme.Red50
import zuper.dev.android.dashboard.ui.theme.Yellow50


/**
 * A simple API model representing a Job
 *
 * Start and end date time is in ISO 8601 format - Date and time are stored in UTC timezone and
 * expected to be shown on the UI in the local timezone
 */
data class JobApiModel(
    val jobNumber: Int,
    val title: String,
    val startTime: String,
    val endTime: String,
    val status: JobStatus
)

enum class JobStatus {
    YetToStart,
    InProgress,
    Cancelled,
    Completed,
    Incomplete
}