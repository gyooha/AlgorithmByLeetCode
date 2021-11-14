package gyooha

class DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 0) return 0
        return (dividend.toDouble() / divisor.toDouble()).toInt()
    }
}

fun main() {
    DivideTwoIntegers().apply {
        println(divide(-2147483648, -1))
        println(divide(2147483647, 2))
    }
}