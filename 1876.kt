fun main(args: Array<String>) {
    //val input = "xyzzaz"
    ///val input = "xyzazb"
    val input = "xyzaz"
    val output = countGoodSubstrings(input)
    println("$output")
}

fun countGoodSubstrings(s: String): Int {
    var start = 0
    var end = 2    
    val goodSubStringList = mutableListOf<String>() 

    while (end <= s.lastIndex) {
        val subString = s.substring(start, end + 1)
        val isGoodSubString = checkUniqueCharacter(subString)        
        if (isGoodSubString)
            goodSubStringList.add(subString)
        start++
        end++
    }
    return goodSubStringList.size
}

fun checkUniqueCharacter(subString: String): Boolean {
    val charMap = hashMapOf<Char, Int>() 
    for (e in subString) {
        if (charMap.get(e) != null) {
            return false; 
        } else {
            charMap.put(e, 1)
        }
    }
    return true
}

// test case 
// 
// "xyzzaz"
// subString = x 
// subString = xy 
// subString = xyz
// >> check unqiue substring
// goodSubString = xyz
// subString = yzz
// >> check unique substring 
// subString = zza 

// "xyzazb"
// subString = x 
// subString = xy
// subString = xyz
// goodSubString = xyz
// subString = yza
// goodSubString = yza
// subString = zaz
// subString = azb 
// goodSubString = azb 