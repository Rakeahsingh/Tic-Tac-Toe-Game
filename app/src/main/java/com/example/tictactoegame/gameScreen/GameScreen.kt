package com.example.tictactoegame.gameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoegame.gameScreen.component.BoardBase
import com.example.tictactoegame.ui.theme.GrayBackground
import com.example.tictactoegame.ui.theme.blueCustom

@Composable
fun GameScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Player 'O' : 0",
                fontSize = 16.sp
            )
            Text(
                text = "Draw : 0",
                fontSize = 16.sp
            )
            Text(
                text = "Player 'X' : 0",
                fontSize = 16.sp
            )
        }

        Text(
            text = "Tic Tac Toe",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = blueCustom
        )

       Box(
           modifier = Modifier
               .fillMaxWidth()
               .aspectRatio(1f)
               .shadow(
                   elevation = 10.dp,
                   shape = RoundedCornerShape(20.dp)
               )
               .clip(RoundedCornerShape(20.dp))
               .background(GrayBackground),
           contentAlignment = Center
       ) {
           BoardBase()
       }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Player 'O' Turns",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = blueCustom,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Play Again",
                    fontSize = 16.sp
                )
            }

        }

    }
}


@Preview
@Composable
fun Prev() {
    GameScreen()
}