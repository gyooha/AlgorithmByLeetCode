/*
*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
* */

private class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val x = mutableMapOf<Char, Int>()
        val y = mutableMapOf<Char, Int>()
        val z = mutableMapOf<Char, Int>()
        board.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c != '.') x[c] = (x[c] ?: 0) + 1

                if (i % 3 == 0 && j % 3 == 0) {
                    // 3x3
                    for (yIndex in i..i + 2) {
                        for (xIndex in j..j + 2) {
                            val cc = board[yIndex][xIndex]
                            if (cc != '.') z[cc] = (z[cc] ?: 0) + 1
                        }
                    }
                    if (z.values.firstOrNull { it > 1 } != null) {
                        return false
                    }
                    z.clear()
                }
            }
            if (x.values.firstOrNull { it > 1 } != null) {
                return false
            }
            x.clear()
            for (j in board.indices) {
                val c = board[j][i]
                if (c != '.') y[c] = (y[c] ?: 0) + 1
            }
            if (y.values.firstOrNull { it > 1 } != null) {
                return false
            }
            y.clear()
        }
        return true
    }
}

fun main() {
    /*val problem = arrayOf(
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
    println("result ${Solution().isValidSudoku(problem)}")*/

    /* val problem2 = arrayOf(
         charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
         charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
         charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
         charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
         charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
         charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
         charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
         charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
         charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
     )
     println("result2 ${Solution().isValidSudoku(problem2)}")*/

    /*val problem3 = arrayOf(
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '6'),
        charArrayOf('.', '.', '.', '.', '1', '4', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '9', '2', '.', '.'),
        charArrayOf('5', '.', '.', '.', '.', '2', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '3', '.'),
        charArrayOf('.', '.', '.', '5', '4', '.', '.', '.', '.'),
        charArrayOf('3', '.', '.', '.', '.', '.', '4', '2', '.'),
        charArrayOf('.', '.', '.', '2', '7', '.', '6', '.', '.')
    )*/

    val problem4 = arrayOf(
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
    println("result4 ${Solution().isValidSudoku(problem4)}")
}