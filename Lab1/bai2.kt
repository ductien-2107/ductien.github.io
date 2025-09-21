package com.example.bai1

import kotlin.math.PI

// class truu tuong
abstract class Dwelling {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double
}

// class tron
open class RoundHut(val residents: Int) : Dwelling() {
    override val buildingMaterial = "rom"
    override fun floorArea(): Double {
        return PI * 4 * 4 // r = 4
    }
}

// class vuong
class SquareCabin(val side: Int, val songuoi: Int) : Dwelling() {
    override val buildingMaterial = "go"
    override fun floorArea(): Double {
        return (side * side).toDouble()
    }
}

// class thap tron nhieu tang
class RoundTower(residents: Int, val floors: Int) : RoundHut(residents) {
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

fun main() {
    val squareCabin = SquareCabin(5, 6)
    val roundHut = RoundHut(3)
    val roundTower = RoundTower(4, 2)

    with(squareCabin) {
        println("Cabin vuong: suc chua $songuoi, vat lieu $buildingMaterial, dien tich ${floorArea()}")
    }

    with(roundHut) {
        println("Leu tron: so nguoi $residents, vat lieu $buildingMaterial, dien tich ${floorArea()}")
    }

    with(roundTower) {
        println("Thap tron: so tang $floors, vat lieu $buildingMaterial, dien tich ${floorArea()}")
    }

    // danh sach
    val numbers = listOf(1,2,3,4,5)
    println("ds so: $numbers, kich thuoc: ${numbers.size}, dau tien: ${numbers[0]}")
    println("dao nguoc: ${listOf("do", "xanh", "vang").reversed()}")

    val entrees = mutableListOf<String>()
    entrees.add("pho")
    entrees.add("bun")
    println("menu: $entrees")
    entrees[0] = "com tam"
    entrees.remove("bun")
    println("menu sau khi doi: $entrees")

    // loop for
    for (item in numbers) {
        println("so: $item")
    }

    // loop while
    var index = 0
    while (index < numbers.size) {
        println("so tai $index = ${numbers[index]}")
        index++
    }

    // string
    val name = "Android"
    println("do dai chuoi: ${name.length}")

    val number = 10
    val groups = 5
    println("$number nguoi")
    println("${number * groups} nguoi tat ca")

    // toan hoc
    val radius = 5
    println("dien tich hinh tron = ${PI * radius * radius}")

    // vararg
    addToppings("kem", "socola", "tra xanh")
}

fun addToppings(vararg toppings: String) {
    println("them topping: ${toppings.joinToString()}")
}
