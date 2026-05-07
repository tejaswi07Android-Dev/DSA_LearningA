import kotlin.math.pow

fun main() {
    /*//    println(sum(2.0,3.0))
    //    println(power(2.0,3.0))

        val fn: (Double, Double) -> Double = ::sum
        val fn2: (Double, Double) -> Double = ::power
    //    calculator(2.0,3.0,fn2)


        val lambdaIsOdd: (Int) -> Boolean = { a: Int ->
            a % 2 != 0
        }

        val divisible: (Int, Int) -> Boolean = { a: Int, b: Int ->
            a % b == 0
        }
    //    println(lambdaIsOdd(6))
    //    println(divisible(6,3))

        val sum = calculate(3, 5) { x, y -> x + y }
        val multiply = calculate(3, 5) { x, y -> x * y }

        println(sum)
        println(multiply)*/

    val list = listOf(1, 2, 3, 4, 5, 6)
    val list3 = listOf(1, 2, 3)
    val listS = listOf("hi", "", "android", "", "kotlin")
    val word = "banana"

    val data = listOf(listOf(5, 1, 3), listOf(2, 3, 9), listOf(1, 4, 6))
    val nRes = data.flatMap { it }.distinct().sorted()


    val result = list.filter { it % 2 == 0 }.map { it * it }
    val res = listS.filter { it.isNotEmpty() }.map { it.uppercase() }
    val ans = list3.fold(10) {acc, i -> acc+i}
    val freq = word.groupingBy { it }.eachCount()


    val zipK = list3.zip(listOf("A","B","C")){n,s -> "$n$s"}

    list3.onEach { println(it) }
    
    val mapN = list.map { if(it%2 ==0) it*2 else it}
//    val combineN = Combine(list, list3){a, b -> a+b}

    val lamB = { a: Int, b: Int -> a*b}
    println(mapN)


}


fun sum(a: Double, b: Double): Double {
    return a + b
}

fun power(a: Double, b: Double): Double {
    return a.pow(b)
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) {
    println(gn(a, b))
}

fun calculate(a: Int, b: Int, gn: (Int, Int) -> Int): Int {
    return gn(a, b)
}

fun testFun(a: Int, b: Int): (Int, Int) -> Int {
    return ::subtract
}