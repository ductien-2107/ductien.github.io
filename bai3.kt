package com.example.bai1

fun main() {
    // tao ds va chuyen thanh set
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("set tu numbers: $setOfNumbers")

    // dinh nghia set
    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("giao nhau: ${set1.intersect(set2)}")
    println("hop nhau: ${set1.union(set2)}")

    // map co the thay doi
    val peopleAges = mutableMapOf(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    peopleAges.forEach { println("${it.key} la ${it.value}") }
    println(peopleAges.map { "${it.key} la ${it.value}" }.joinToString(", "))

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("ten ngan hon 4: $filteredNames")

    // thao tac voi list
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println("loc theo b: $filteredWords")

    // let
    val letter: String? = "A"
    letter?.let {
        println("gia tri la $it")
    }

    // apply
    val sb = StringBuilder().apply {
        append("hello ")
        append("kotlin")
    }
    println(sb.toString())

    // thuoc tinh du phong
    val game = Game()
    println("tu bi xao: ${game.currentScrambledWord}")

    // lambda
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("5*3 = ${triple(5)}")

    // elvis
    var quantity: Int? = null
    println(quantity ?: 0)
    quantity = 4
    println(quantity ?: 0)
}

// class demo companion object
class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}

// class demo property fallback
class Game {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
}
