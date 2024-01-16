package com.example.tictactoegame.gameScreen.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoegame.ui.theme.Aqua

@Composable
fun BoardBase() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.DarkGray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/3f,
                y = 0f
            ),
            end = Offset(
                x =  size.width * 1/3f,
                y = size.height
            )
        )

        drawLine(
            color = Color.DarkGray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 2/3f,
                y = 0f
            ),
            end = Offset(
                x =  size.width * 2/3f,
                y = size.height
            )
        )

        drawLine(
            color = Color.DarkGray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/3f
            ),
            end = Offset(
                x =  size.width,
                y = size.height * 1/3f
            )
        )

        drawLine(
            color = Color.DarkGray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 2/3f
            ),
            end = Offset(
                x =  size.width,
                y = size.height * 2/3f
            )
        )
    }

}


@Composable
fun Cross() {

    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)
    ){
        drawLine(
            color = Color.Red,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = 0f
            ),
            end = Offset(
                x = size.width,
                y = size.height
            )
        )

        drawLine(
            color = Color.Red,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height
            ),
            end = Offset(
                x = size.width,
                y = 0f
            )
        )
    }
}


@Composable
fun Circle() {

    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)
    ){
        drawCircle(
            color = Aqua,
            style = Stroke(width = 20f)
        )

    }
}


@Composable
fun WinHorizontalLine1() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/6f
            ),
            end = Offset(
                x = size.width,
                y = size.height * 1/6f
            )
        )
    }
}

@Composable
fun WinHorizontalLine2() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/2f
            ),
            end = Offset(
                x = size.width,
                y = size.height * 1/2f
            )
        )
    }
}


@Composable
fun WinHorizontalLine3() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 5/6f
            ),
            end = Offset(
                x = size.width,
                y = size.height * 5/6f
            )
        )
    }
}

@Composable
fun WinVerticalLine1() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/6f,
                y = 0f
            ),
            end = Offset(
                x = size.width * 1/6f,
                y = size.height
            )
        )
    }
}

@Composable
fun WinVerticalLine2() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/2f,
                y = 0f
            ),
            end = Offset(
                x = size.width * 1/2f,
                y = size.height
            )
        )
    }
}


@Composable
fun WinVerticalLine3() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 5/6f,
                y = 0f
            ),
            end = Offset(
                x = size.width * 5/6f,
                y = size.height
            )
        )
    }
}


@Composable
fun WinDiagonalLine1() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = 0f
            ),
            end = Offset(
                x = size.width,
                y = size.height
            )
        )
    }
}


@Composable
fun WinDiagonalLine2() {

    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(10.dp)
    ){
        drawLine(
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height
            ),
            end = Offset(
                x = size.width,
                y = 0f
            )
        )
    }
}

@Preview
@Composable
fun Preview() {


    WinHorizontalLine1()
    WinHorizontalLine2()
    WinHorizontalLine3()
    WinVerticalLine1()
    WinVerticalLine2()
    WinVerticalLine3()
    WinDiagonalLine1()
    WinDiagonalLine2()


}