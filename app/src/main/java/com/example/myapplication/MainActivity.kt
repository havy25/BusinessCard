package com.example.myapplication

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()

                }
            }
        }
    }
}
@Composable
fun  BusinessCard(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null

            )
        Column (modifier = Modifier.fillMaxSize().padding(top = 92.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BasicInfo()
            ContactInfo()
        }
    }

}
@Composable
fun BasicInfo(){
    Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(3.dp, Color(0xFFB65177), CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.hvy),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Lê Thị Hạ Vy",
            color = Color(0xFFB65177),
            fontWeight = FontWeight.Bold,
            fontSize = 52.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontFamily = FontFamily.Monospace,
            text = "Android Developer",
            color = Color(0xF3E56494),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}
@Composable
fun ContactInfo(){
    Column {
        ContactItem(icon = Icons.Default.Call, text="0702611265")
        ContactItem(icon = Icons.Default.Email, text="havy252k5@gmail.com")
        ContactItem(icon = Icons.Default.Home, text="Điện Bàn, Quảng Nam")

    }

}
@Composable
fun ContactItem(icon: ImageVector, text: String){
    Row {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .padding(top = 16.dp),
            imageVector = icon,
            tint = Color(0xF3E56494),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 12.dp,top = 16.dp),
            fontFamily = FontFamily.Monospace,
            text = text,
            color = Color(0xF3E56494),
            fontSize = 24.sp
        )

    }

}




@Preview(
    showBackground = true,
    showSystemUi= true,
    name="My Preview"
)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme {
        BusinessCard()

    }
}