package com.example.tictactoegame.gameScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.example.tictactoegame.gameScreen.component.BoardCellValue
import com.example.tictactoegame.gameScreen.component.Circle
import com.example.tictactoegame.gameScreen.component.Cross
import com.example.tictactoegame.gameScreen.component.UserAction
import com.example.tictactoegame.ui.theme.GrayBackground
import com.example.tictactoegame.ui.theme.blueCustom
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tictactoegame.gameScreen.component.GameState
import com.example.tictactoegame.gameScreen.component.VictoryType
import com.example.tictactoegame.gameScreen.component.WinDiagonalLine1
import com.example.tictactoegame.gameScreen.component.WinDiagonalLine2
import com.example.tictactoegame.gameScreen.component.WinHorizontalLine1
import com.example.tictactoegame.gameScreen.component.WinHorizontalLine2
import com.example.tictactoegame.gameScreen.component.WinHorizontalLine3
import com.example.tictactoegame.gameScreen.component.WinVerticalLine1
import com.example.tictactoegame.gameScreen.component.WinVerticalLine2
import com.example.tictactoegame.gameScreen.component.WinVerticalLine3

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Player 'O' : ${state.playerCircleCount}",
                fontSize = 16.sp
            )
            Text(
                text = "Draw : ${state.drawCount}",
                fontSize = 16.sp
            )
            Text(
                text = "Player 'X' : ${state.playerCrossCount}",
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

           LazyVerticalGrid(
               modifier = Modifier
                   .fillMaxWidth(0.9f)
                   .aspectRatio(1f),
               columns = GridCells.Fixed(3),
           ){
               viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                   item {
                       Column (
                           modifier = Modifier
                               .fillMaxWidth()
                               .aspectRatio(1f)
                               .clickable(
                                   interactionSource = MutableInteractionSource(),
                                   indication = null
                               ) {
                                   viewModel.onAction(UserAction.BoardCellTap(cellNo))
                               },
                           horizontalAlignment = CenterHorizontally,
                           verticalArrangement = Arrangement.Center
                       ){
                           val result = viewModel.boardItems[cellNo] != BoardCellValue.NONE

                           AnimatedVisibility(
                               visible = result,
                               enter = scaleIn(tween(1000))
                           ) {
                               if (boardCellValue == BoardCellValue.CIRCLE){
                                   Circle()
                               }else if (boardCellValue == BoardCellValue.CROSS){
                                   Cross()
                               }
                           }

                       }
                   }
               }
           }

           Column(
               modifier = Modifier.fillMaxWidth()
                   .aspectRatio(1f),
               horizontalAlignment = CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
               AnimatedVisibility(
                   visible = state.hasWon,
                   enter = fadeIn(tween(2000)),
               ) {
                   DrawVictoryLine(state = state)
               }
           }

       }

        Text(
            text = state.hintText,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic
        )


        Button(
            onClick = {
                viewModel.onAction(
                         UserAction.PlayAgainClick
                )
                },
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


@Composable
fun DrawVictoryLine(
    state: GameState
) {
    when(state.victoryType){
        VictoryType.HORIZONTAL1 -> WinHorizontalLine1()
        VictoryType.HORIZONTAL2 -> WinHorizontalLine2()
        VictoryType.HORIZONTAL3 -> WinHorizontalLine3()
        VictoryType.VERTICAL1 -> WinVerticalLine1()
        VictoryType.VERTICAL2 -> WinVerticalLine2()
        VictoryType.VERTICAL3 -> WinVerticalLine3()
        VictoryType.DIAGONAL1 -> WinDiagonalLine1()
        VictoryType.DIAGONAL2 -> WinDiagonalLine2()
        else -> {}
    }
}


@Preview
@Composable
fun Prev() {
    GameScreen(
        viewModel = GameViewModel()
    )
}