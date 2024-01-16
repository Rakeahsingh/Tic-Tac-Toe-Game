package com.example.tictactoegame.gameScreen.component

sealed class UserAction {

    data object PlayAgainClick: UserAction()

    data class BoardCellTap(val cellNo: Int): UserAction()
}