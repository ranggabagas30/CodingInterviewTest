import kotlin.math.*

fun main(args: Array<String>) {
    val arrayInteger = intArrayOf(1,2,3,4,5,6,7,8,9)    
    val arrayChar = "abcdeef"
    //fixedWindowSize(arrayInteger)
    variableWindowSize(arrayChar)
}

fun fixedWindowSize(arrayInteger: IntArray) {    
    var sum = 0 
    val k = 3
    var i = 0
    var j = 0    
    while (j < arrayInteger.size) {
        if (j - i + 1 < k) {
            sum += arrayInteger[j]
            j++
        } else {
            sum += arrayInteger[j]
            println("sum: $sum")
            sum -= arrayInteger[i]
            i++
            j++
        }
        println("i: $i, j: $j")
    }
}

fun variableWindowSize(arrayChar: String) {
    var i = 0
    var j = 0
    var ans = 0
    var charMap = hashMapOf<Char, Int>()
    var windowSize = 0
    while (j < arrayChar.length) {
        println("previous -> i: $i, j: $j, map: $charMap")
        incrementCharMapValue(charMap, arrayChar[j])
        windowSize = calculateWindowSize(i, j)

        if (charMap.size == windowSize) {
            ans = max(ans, windowSize)            
            j++
        } else {
            while(charMap.size < windowSize) {
                decrementCharMapValue(charMap, arrayChar[i])
                i++
                windowSize = calculateWindowSize(i, j)
            }

            if (charMap.size == windowSize) {
                ans = max(ans, windowSize)
            }
            j++
        }      
        println("after -> i: $i, j: $j, map: $charMap")          
    }
    println("longest substring: $ans")    
}

fun incrementCharMapValue(charMap: HashMap<Char, Int>, key: Char) {  
    var currentValue = charMap.get(key)?: 0
    currentValue += 1        
    charMap.put(key, currentValue)
}

fun decrementCharMapValue(charMap: HashMap<Char, Int>, key: Char) {
    var currentValue = charMap.get(key)?: 0
    currentValue -= 1
    if (currentValue <= 0) {
        charMap.remove(key)    
    } else {
        charMap.put(key, currentValue)
    }         
}

fun calculateWindowSize(i: Int, j: Int): Int {
    return j - i + 1
}