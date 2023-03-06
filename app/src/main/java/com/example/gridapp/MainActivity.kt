@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.gridapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridapp.data.Topic
import com.example.gridapp.model.DataSource
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridApp() {
    CourseGrid(DataSource.topics)
}



@Composable
fun CourseGrid(topicList: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(topicList){
            CourseCard(topic = it)
        }
    }
}




@Composable
fun CourseCard(topic: Topic, modifier:Modifier = Modifier){
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row{
            Column() {
                Image(
                    painter = painterResource(id = topic.topicImageResource),
                    contentDescription = stringResource(id = topic.topicNameResource),
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ){
                Text(text = stringResource(id = topic.topicNameResource),
                    fontSize = 12.sp
                )
                Row(
                    modifier = Modifier
                        .padding(
                            top = 8.dp
                        )
                        .wrapContentSize(unbounded = true),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Text(
                        text = topic.numberOfCourses.toString(),
                        fontSize = 12.sp
                    )

                }
            }
        }
    }
}