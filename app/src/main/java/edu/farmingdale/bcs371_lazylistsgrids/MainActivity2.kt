package edu.farmingdale.bcs371_lazylistsgrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.farmingdale.bcs371_lazylistsgrids.ui.theme.BCS371_LazyListsGridsTheme
import kotlin.random.Random

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BCS371_LazyListsGridsTheme {
                DemoVerticalStaggeredGrid( )
            }
        }
    }
}


@Composable
fun EmojiGrid() {
    val emojiList = listOf("👟", "🏀", "🧸️", "👻", "🐼", "🧲", "🎸", "😁", "❄️", "🍕",
        "🍔", "🍟", "🍦", "🍩", "🍪", "🍫", "🍬", "🍭", "🍮", "🍯", "🍼", "🍽️", "🍾",
        "🍿", "🎀", "🎁", "🎂", "🎃", "🎄", "🎅", "🎆", "🎇", "🎈", "🎉", "🎊", "🎋",
        "🎌", "🎍", "🎎", "🎏", "🎐", "🎑", "🎒", "🎓", "🎠", "🎡", "🎢", "🎣", "🎤",
        "🎥", "🎦", "🎧", "🎨", "🎩", "🎪", "🎫", "🎬", "🎭", "🎮", "🎯", "🎰", "🎱",
        "🎲", "🎳", "🎴", "🎵", "🎶", "🎷", "🎸", "🎹", "🎺", "🎻", "🎼", "🎽", "🎾",
        "🎿", "🏀", "🏁", "🏂", "🏃", "🏄", "🏅", "🏆", "🏇", "🏈", "🏉", "🏊", "🏋️",
        "🏌️", "🏍️", "🏎️", "🏏", "🏐", "🏑", "🏒", "🏓", "🏔️", "🏕️", "🏖️", "🏗️",
        "🏘️", "🏙️", "🏚️", "🏛️", "🏜️", "🏝️")

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(all = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(emojiList) { item ->
            Box(
                modifier = Modifier.background(
                    Color(
                        red = Random.nextInt(0, 255),
                        green = Random.nextInt(0, 255),
                        blue = Random.nextInt(0, 255)
                    )
                ),
                contentAlignment = Alignment.Center,
            )
            {
                Text(
                    text = item,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}


@Composable
fun DemoVerticalStaggeredGrid() {
    val numItems = 30
    val cardSizes = IntArray(numItems) { Random.nextInt(80, 220) }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(100.dp),
        content = {
            items(numItems) { item ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(cardSizes[item].dp)
                ) {
                    Text(
                        text = "Item $item",
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
        }
    )
}