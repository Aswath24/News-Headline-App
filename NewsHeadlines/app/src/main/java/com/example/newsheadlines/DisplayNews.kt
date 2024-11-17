//package com.example.newsheadlines
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.TextView
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.core.text.HtmlCompat
//import coil.compose.rememberImagePainter
//import com.example.newsheadlines.ui.theme.NewsHeadlinesTheme
//
//class DisplayNews : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            NewsHeadlinesTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    // Extract data from the Intent
//                    val desk = intent.getStringExtra("desk") ?: "No Description Available"
//                    val title = intent.getStringExtra("title") ?: "No Title Available"
//                    val uriImage = intent.getStringExtra("urlToImage") ?: ""
//                    Log.i("DisplayNews", "Desk: $desk")
//
//                    Column(
//                        Modifier
//                            .background(Color.Gray)
//                            .padding(20.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(text = title, fontSize = 32.sp, color = Color.White)
//                        HtmlText(html = desk)
//                        if (uriImage.isNotEmpty()) {
//                            Image(
//                                painter = rememberImagePainter(uriImage),
//                                contentDescription = "Article Image",
//                                modifier = Modifier.padding(top = 16.dp)
//                            )
//                        } else {
//                            // Placeholder or alternative content for when there is no image
//                            Text(text = "No Image Available", color = Color.Red)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun HtmlText(html: String, modifier: Modifier = Modifier) {
//    AndroidView(
//        modifier = modifier,
//        factory = { context -> TextView(context) },
//        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NewsHeadlinesTheme {
//        // You can add a preview of the UI here
//        Column {
//            Text(text = "Sample Title", fontSize = 32.sp, color = Color.White)
//            HtmlText(html = "Sample description here.")
//        }
//    }
//}
package com.example.newsheadlines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.rememberImagePainter
import com.example.newsheadlines.ui.theme.NewsHeadlinesTheme

class DisplayNews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsHeadlinesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Extract data from the Intent
                    val desk = intent.getStringExtra("desk") ?: "No Description Available"
                    val title = intent.getStringExtra("title") ?: "No Title Available"
                    val uriImage = intent.getStringExtra("urlToImage") ?: ""
                    Log.i("DisplayNews", "Desk: $desk")

                    Column(
                        Modifier
                            .background(Color.Gray)
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = title, fontSize = 32.sp, color = Color.White)
                        HtmlText(html = desk)
                        if (uriImage.isNotEmpty()) {
                            Image(
                                painter = rememberImagePainter(uriImage),
                                contentDescription = "Article Image",
                                modifier = Modifier.padding(top = 16.dp)
                            )
                        } else {
                            // Placeholder or alternative content for when there is no image
                            Text(text = "No Image Available", color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsHeadlinesTheme {
        // You can add a preview of the UI here
        Column {
            Text(text = "Sample Title", fontSize = 32.sp, color = Color.White)
            HtmlText(html = "Sample description here.")
        }
    }
}

