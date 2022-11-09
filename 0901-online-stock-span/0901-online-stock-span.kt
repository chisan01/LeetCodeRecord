class StockSpanner(
    val priceOf: MutableList<Int> = mutableListOf(),
    val spanSizeOf: MutableList<Int> = mutableListOf()
) {
    fun next(price: Int): Int {
        var spanSize = 1
        var prevStock = priceOf.lastIndex
        while (prevStock >= 0) {
            if(priceOf[prevStock] > price) break
            spanSize += spanSizeOf[prevStock]
            prevStock -= spanSizeOf[prevStock]
        }
        priceOf.add(price)
        spanSizeOf.add(spanSize)
        return spanSize
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */