package com.example.bai1
fun main() {
    println("hello kotlin")
    println("code test thu ne")

    val tuoi = 20
    val ten = "Duc Tien"
    var solan = 6
    var giatri: Int = 4

    println("nay ${ten} da ${tuoi} tuoi roi nha")

    val songuyen: Int = -10
    val chuoi: String = "demo"
    val phamvi: IntRange = 1..6
    val laVui: Boolean = true
    println("kieu du lieu: $songuyen, $chuoi, $phamvi, $laVui")

    chaohHoi()
    veDuongVien("-", 5)

    val ketqua = gieoXucXac()
    println("xuc xac ra so: $ketqua")

    val a = 10
    val b = 3
    println("a+b=${a+b}, a-b=${a-b}, a*b=${a*b}, a/b=${a/b}")

    val soNgauNhien = (1..6).random()
    println("so random: $soNgauNhien")

    veDuongVienMacDinh()
    veBanhKem(tuoi = 5, tang = 2)

    val so = 4
    if (so > 4) {
        println("so lon hon 4")
    } else if (so == 4) {
        println("so bang 4")
    } else {
        println("so nho hon 4")
    }

    val gieo = (1..6).random()
    val soMayMan = 4
    println("gieo duoc: $gieo")
    when (gieo) {
        soMayMan -> println("trung so may man")
        1 -> println("ra so 1 r, hoi xui")
        2 -> println("ra so 2, thu lai")
        3 -> println("ra so 3, chua an thua")
        4 -> println("ra so 4, sat nut")
        5 -> println("ra so 5, gan trung")
        6 -> println("ra so 6, choi tiep")
    }

    val tainguyen = when (gieo) {
        1 -> "hinh_1"
        2 -> "hinh_2"
        3 -> "hinh_3"
        4 -> "hinh_4"
        5 -> "hinh_5"
        else -> "hinh_6"
    }
    println("hinh ung voi $gieo la: $tainguyen")

    val xucxac1 = XucXacDonGian()
    xucxac1.gieo()

    val xucxac2 = XucXac(6)
    println("gieo xuc xac 6 mat: ${xucxac2.gieo()}")
}

fun chaohHoi() {
    println("hello tu 1 function nho nho")
}

fun veDuongVien(kytu: String, solan: Int) {
    repeat(solan) {
        print(kytu)
    }
    println()
}

fun gieoXucXac(): Int {
    return (1..6).random()
}

fun veDuongVienMacDinh() {
    repeat(10) {
        print("=")
    }
    println()
}

fun veBanhKem(tuoi: Int, tang: Int) {
    repeat(tang) {
        repeat(tuoi + 2) {
            print("@")
        }
        println()
    }
}

class XucXacDonGian {
    var somat = 6
    fun gieo() {
        val so = (1..somat).random()
        println("gieo xuc xac don gian ra: $so")
    }
}

class XucXac(val somat: Int) {
    fun gieo(): Int {
        return (1..somat).random()
    }
}
