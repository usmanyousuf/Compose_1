package com.example.compose_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
            }
        }
    }
data class User(
    val id:Int
)
val users = listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
)
@Composable
fun UserList(){
   LazyColumn{
       items(users){users->
           UserCard()

       }
   }


   }

@Composable
fun UserCard(){
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(width = 4.dp, color = Color.Blue,shape = RectangleShape)

        ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .padding(12.dp)) {

            Image(
                painter = painterResource(id = R.drawable.sample),
                contentDescription = "Profile_Pic",
                contentScale = ContentScale.Crop,
                 modifier = Modifier
                     .size(120.dp)
                     .clip(CircleShape).border(width = 2.dp,color = Color.DarkGray,shape = CircleShape)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { Toast.makeText(context,R.string.Toast,Toast.LENGTH_LONG ).show() })
                {
                    Text(text = "View Profile")
                }
                Text(text = stringResource(id = R.string.Details))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UserList()
}