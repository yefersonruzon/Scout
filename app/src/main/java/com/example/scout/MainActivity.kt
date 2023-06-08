package com.example.scout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scout.ui.theme.ScoutTheme
import kotlin.math.roundToInt



private val touristDestinations: List<Destination> = listOf(
    Destination(R.drawable.img, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_1, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
    Destination(R.drawable.img_2, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_3, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
    Destination(R.drawable.img_4, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_5, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
    Destination(R.drawable.img_6, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_7, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
    Destination(R.drawable.img_8, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_9, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
    Destination(R.drawable.img_10, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 260),
    Destination(R.drawable.img_11, tittle = "Cala Comte Beach", country = "Ibiza, Spain", height = 210),
)

data class Destination(val image: Int, val tittle: String, val country: String, val height: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 16.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NavBar()
                    }
                }
            }
        }
    }
}
@Composable
fun Home(){
    Box(modifier = Modifier
        .fillMaxWidth()
    )
    Column {
        TopBar()
        Spacer(modifier = Modifier.height(15.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(18.dp))
        Categories()
        Spacer(modifier = Modifier.height(18.dp))
        Grid(touristDestinations)


    }

}

@Composable
fun TopBar(){
    Row (
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = null,
            ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
                )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Location", color = Color.Gray, fontSize = 14.sp)
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = "Place",
                    Modifier.size(16.dp),
                    tint = Color(0xFFF9B576)
                )
                Text(text = "Santa Marta, Colombia", fontSize = 15.sp)
            }
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            border = null,
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Alerts",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val rowWidth = with(LocalDensity.current) { (screenWidth * 0.32f).toPx().roundToInt() }.dp

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center

    ){
        Row(
            modifier = Modifier
                .width(rowWidth)
                .clip(RoundedCornerShape(16.dp))
                .border(1.5.dp, Color.Gray, RoundedCornerShape(16.dp))
                .padding(1.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .weight(1f),
                singleLine = true,
                maxLines = 1,
                placeholder = { Text(text = "Search...") },
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }

}


@Composable
fun Categories() {

    Box (
        modifier = Modifier
            .padding(start = 24.dp)
    ){
        Text(text = "Categories")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp, end = 8.dp, top = 7.dp)
    ) {
        for (category in getAllCategories()) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                ,
                colors = ButtonDefaults.buttonColors(Color(0xFFF9B576)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(category.value)
            }
        }
    }
}


@Composable
fun NavBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(60.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1A1612)),
        contentAlignment = Alignment.Center
    ) {
        Row {
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = null,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Home", color = Color(0xFFF9B576))
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color(0xFFF9B576), shape = MaterialTheme.shapes.small)
                    )
                }
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = null,
            ) {
                Icon(
                    imageVector = Icons.Default.Public,
                    contentDescription = "Menu",
                    tint = Color(0xFF5A5A5A),
                    modifier = Modifier.size(30.dp)
                )
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = null,
            ) {
                Icon(
                    imageVector = Icons.Default.Flight,
                    contentDescription = "Menu",
                    tint = Color(0xFF5A5A5A),
                    modifier = Modifier.size(30.dp)
                )
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = null,
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Menu",
                    tint = Color(0xFF5A5A5A),
                    modifier = Modifier.size(30.dp)
                )
            }

        }
    }
}


@Composable
fun Grid(contents: List<Destination>){
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
    ){
        items(contents){content ->
            Card(content)
        }
        item{
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}





@Composable
fun Card(content: Destination){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth(0.53f)
            .height(content.height.dp)
            .padding(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(content.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 0.dp)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .size(37.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0x658D8D8D))
                        .padding(8.dp)

                )
            }
            Column(
                verticalArrangement = Arrangement.Bottom
                ,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 450f,
                            endY = 900f
                        )
                    )
                    .padding(6.dp)

            ) {
                Text(
                    text = content.tittle,
                    textAlign = TextAlign.Start,
                    color = Color.White,
                    fontSize = 14.sp,
                    
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "location", tint = Color.LightGray, modifier = Modifier.size(12.dp))
                    Text(
                        text = content.country,
                        textAlign = TextAlign.Start,
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            }
        }

    }

}


















@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ScoutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Home()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavBar()
            }
        }
    }
}