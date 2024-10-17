package edu.farmingdale.bcs371_lazylistsgrids

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import edu.farmingdale.bcs371_lazylistsgrids.ui.theme.BCS371_LazyListsGridsTheme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text


import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BCS371_LazyListsGridsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyLists(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    Button( onClick ={startActivity(Intent(this, MainActivity2::class.java))} ) { Text("Move") }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyLists(name: String, modifier: Modifier = Modifier) {
    Column {
        LazyRow (modifier = Modifier.padding(top = 100.dp)) {
            stickyHeader {
                Text(
                    text = "Row Header",
                    color = Color.White,
                    modifier = Modifier.background(Color.Black).padding(10.dp)
                )
            }
            items(3) { index ->
                Text(
                    text = "Row item ${index + 1}",
                    color = Color.Black,
                    modifier = Modifier.background(Color.Yellow).padding(30.dp)
                )
            }
        }
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            stickyHeader {
                Text(
                    text = "Column Header",
                    color = Color.White,
                    modifier = Modifier.background(Color.Black).padding(top=30.dp)
                )
            }
            items(19) { index ->
                Text(
                    text = "Column item ${index + 1}",
                    color = Color.White,
                    modifier = Modifier.padding(top=30.dp).background(Color.Red).border(1.dp, Color.Black , MaterialTheme.shapes.medium).padding(10.dp)
                )
            }
        }
    }

}

