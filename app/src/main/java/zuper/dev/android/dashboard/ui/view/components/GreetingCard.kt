package zuper.dev.android.dashboard.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import zuper.dev.android.dashboard.R
import zuper.dev.android.dashboard.ui.theme.LightBlue40
import zuper.dev.android.dashboard.ui.theme.TextDarkGrey
import zuper.dev.android.dashboard.ui.theme.TitleBlack
import zuper.dev.android.dashboard.utils.Utility.getCurrentDate
import zuper.dev.android.dashboard.utils.Utility.getGreetingMessage

@Composable
fun GreetingCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .border(1.dp, Color.LightGray, RoundedCornerShape(8)),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(start =  16.dp, end = 16.dp, top =  12.dp, bottom = 12.dp   )
                .fillMaxWidth(),
        ) {
            val (nameRow, image) = createRefs()

            Column(
                modifier = Modifier
                    .constrainAs(nameRow) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .padding(end = 58.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = getGreetingMessage(context, stringResource(R.string.henry_jones)),
                    style = MaterialTheme.typography.titleMedium.copy(TitleBlack),
                )
                Text(
                    text = getCurrentDate(context),
                    style = MaterialTheme.typography.bodySmall.copy(TextDarkGrey),
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
            Image(
                painter = painterResource(id = R.drawable.profile_photo_sample),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(40.dp)
                    .constrainAs(image) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .border(2.dp, LightBlue40, RoundedCornerShape(8))
                    .clip(RoundedCornerShape(8)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
