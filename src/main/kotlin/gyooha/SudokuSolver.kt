package gyooha

private class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        SudokuSolver(board).solve(0, 0)
        board.forEach {
            it.forEach { print("$it, ") }
            println()
        }
    }
}

private fun main() {
    val problem = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    Solution().solveSudoku(problem)
}

private class SudokuSolver(private val board: Array<CharArray>) {
    private val N = 9

    private fun isLegal(num: Char, row: Int, col: Int): Boolean {
        val colList = mutableListOf<Char>()
        val sqrList = mutableListOf<Char>()
        val sqrSize = 3
        val sqrInitRow = row - row % sqrSize
        val sqrInitCol = col - col % sqrSize

        for (i in sqrInitRow until sqrInitRow + sqrSize) {
            for (j in sqrInitCol until sqrInitCol + sqrSize) {
                sqrList.add(board[i][j])
            }
        }

        board.forEach { colList.add(it[col]) }

        if (num in board[row] || num in colList || num in sqrList) {
            return false
        }

        return true
    }

    fun solve(_row: Int, _col: Int): Boolean {
        var row = _row
        var col = _col
        if (col == N) {
            if (row == N - 1) {
                return true
            } else {
                row += 1
                col = 0
            }
        }

        if (board[row][col] != '.') {
            return solve(row, col + 1)
        }

        for (num in '1'..'9') {
            if (isLegal(num, row, col)) {
                board[row][col] = num
                if (solve(row, col + 1)) return true
            }
            board[row][col] = '.'
        }
        return false
    }
}