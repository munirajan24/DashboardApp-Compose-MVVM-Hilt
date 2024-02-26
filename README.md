
Job Dashboard with Copose, MVVM, navigation, Hilt

Project done for zuper

Description:

Dashboard Project
Design
Project Details
The app has 2 screens, the dashboard and the jobs screen
Dashboard
A simple profile card with a greeting, today's date and a profile picture.
You can use any profile picture
Job stats card
Consider "Jobs" as small tasks to be done. For eg, "Home
Cleaning", "AC installation" can be considered as jobs
A job can be in any one of the following statuses : "Yet to Start", "In
Progress", "Canceled", "Completed", "Incomplete"
Job stats chart shows a visual representation of the stats
The numbers shown in this card are the total number of jobs in each
status. For eg, in the UI design, 10 jobs are in "Yet to start" status
Invoice stats card
Invoice is a document which has the cost of the parts and services
for a Job
An invoice is meant to be paid by the customers once a Job is
completed
Invoice can be in any of the following statuses : "Draft", "Pending",
"Paid", "Bad Debt"
The numbers shown in this card are sum of the value (total) of
invoices in each status
In the UI design,
the total value of invoices is 50k USD out of which 15K is
collected i.e paid
There may be few invoices in draft status which sums up to 10K
Other statuses follow the same respective
Chart
Dashboard charts are not interactive, but a simple view
The chart values are sorted by descending order of the total. For eg,
in the UI design, completed has the maximum which is placed first
(green), followed by in-progress (sky blue)
The stats shown on the dashboard are considered realtime. The sample
project attached has a repository which emits sample data every 30
seconds using kotlin Flow . We're just simulating realtime behaviour for
the interview purpose and not using any real data
The jobs page is not realtime, and can have swipe to refresh functionality
to refresh the list
Jobs screen
Upon clicking Job stats card in dashboard, the jobs page is shown
Jobs page has the chart at the top, below which jobs are shown in tabs
by job status
Requirements
Project has to be built as a single activity jetpack compose app with any
navigation frameworks of your choice to navigate from dashboard to jobs
page
Project should be built using Kotlin
Dashboard charts should be built without using any chart libraries
Usage of other frameworks (like DI frameworks) are opinionated and are not
mandatory
No API integration is required. The boilerplate project already has the sample
data to iterate on
![image](https://github.com/munirajan24/DashboardApp-Compose-MVVM-Hilt/assets/22021746/e0cbd923-0235-4efe-9ab8-d19648d42e6f)
