
Job Dashboard with Copose, MVVM, navigation, Hilt

Interview Project done for zuper

Project Details
The app has 2 screens, the dashboard and the jobs screen.

Dashboard
A simple profile card with a greeting, today's date, and a profile picture.
Job stats card:
"Jobs" are considered as small tasks to be done, like "Home Cleaning", "AC installation", etc.
Jobs can be in statuses: "Yet to Start", "In Progress", "Canceled", "Completed", "Incomplete".
Job stats chart shows a visual representation of the stats.
The numbers in this card are the total number of jobs in each status.
Invoice stats card:
Invoice is a document with the cost of parts and services for a job.
Invoice can be in statuses: "Draft", "Pending", "Paid", "Bad Debt".
The numbers in this card are the sum of the value (total) of invoices in each status.
The total value of invoices is 50k USD, out of which 15K is collected (paid).
Some invoices in draft status sum up to 10K.
Chart:
Dashboard charts are not interactive but a simple view.
The chart values are sorted by descending order of the total.
For example, completed has the maximum and is placed first (green), followed by in-progress (sky blue).
The stats shown are considered real-time, with sample data emitted every 30 seconds using Kotlin Flow.
Jobs Screen
Upon clicking Job stats card in dashboard, the jobs page is shown.
Jobs page has the chart at the top, below which jobs are shown in tabs by job status.
Requirements
Project should be built as a single activity Jetpack Compose app with any navigation frameworks to navigate from dashboard to jobs page.
Project should be built using Kotlin.
Dashboard charts should be built without using any chart libraries.
Usage of other frameworks (like DI frameworks) is optional and not mandatory.
No API integration is required. The boilerplate project already has the sample data to iterate on.
![image](https://github.com/munirajan24/DashboardApp-Compose-MVVM-Hilt/assets/22021746/e0cbd923-0235-4efe-9ab8-d19648d42e6f)
