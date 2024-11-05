package com.codingcat.task.alfred.general.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingcat.task.alfred.R
import com.codingcat.task.alfred.general.models.UiFeaturedTaskModel
import com.codingcat.task.alfred.general.models.UiTaskModel
import com.codingcat.task.alfred.general.theme.AlfredTheme

@Composable
fun FeaturedTaskCardItem(
    modifier: Modifier = Modifier,
    onItemClick: (UiTaskModel) -> Unit,
    itemModel: UiFeaturedTaskModel
) {
    Surface(
        modifier = Modifier
            .size(340.dp)
            .then(modifier),
        color = AlfredTheme.colors.greenGray,
        shape = RoundedCornerShape(20.dp),
        onClick = { onItemClick(itemModel.taskData) }) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                modifier = Modifier.padding(36.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = AlfredTheme.colors.white20p,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(itemModel.iconRes),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = itemModel.taskData.category,
                    style = AlfredTheme.typography.sb3,
                    color = AlfredTheme.colors.white
                )
            }

            Text(
                modifier = Modifier.padding(start = 36.dp, bottom = 36.dp),
                text = itemModel.taskData.title,
                style = AlfredTheme.typography.sb4,
                color = AlfredTheme.colors.white
            )

            Text(
                modifier = Modifier.padding(start = 36.dp, bottom = 36.dp),
                text = itemModel.taskData.endTime,
                style = AlfredTheme.typography.lgh1,
                color = AlfredTheme.colors.white
            )
        }
    }
}

@Preview
@Composable
private fun FeaturedTaskCardItemPreview() {
    AlfredTheme {
        FeaturedTaskCardItem(
            onItemClick = {},
            itemModel = UiFeaturedTaskModel(
                iconRes = R.drawable.ic_launcher_foreground,
                taskData = UiTaskModel(
                    title = "Test Title",
                    description = "Very Very Very long long long descriptioooooooooon",
                    category = "Test category",
                    date = "Test date",
                    startTime = "Test startTime",
                    endTime = "Test endTime"
                )
            )
        )
    }
}