package com.example.bai4

import kotlinx.coroutines.*

// ham tam ngung
suspend fun layGiaTri(): Double {
    delay(500L) // gia lap xu ly cham
    return 3.14
}

// ham tam ngung goi ham khac
suspend fun xuLyGiaTri(): Double {
    val v = layGiaTri()
    return v + 10
}

// doi tuong don
object QuanLyDuLieu {
    fun layDuLieu(): String = "Du lieu da duoc nap"
}

// enum class
enum class TrangThai {
    BAT_DAU, DANG_CHAY, HOAN_TAT, LOI
}

fun main() = runBlocking {
    println("=== BAT DAU ===")

    // tao job voi GlobalScope
    val job: Job = GlobalScope.launch {
        val kq = layGiaTri()
        println("Gia tri tu GlobalScope: $kq")
    }

    delay(800L)
    job.cancel() // huy job
    println("Job da bi huy")

    // goi truc tiep trong runBlocking
    val kq1 = layGiaTri()
    println("Gia tri tu runBlocking: $kq1")

    // goi ham xu ly
    val kq2 = xuLyGiaTri()
    println("Gia tri sau xu ly: $kq2")

    // async await
    val deferred = async { layGiaTri() }
    println("Gia tri tu async-await: ${deferred.await()}")

    // doi tuong don
    println(QuanLyDuLieu.layDuLieu())

    // enum
    val trangThai = TrangThai.DANG_CHAY
    when (trangThai) {
        TrangThai.BAT_DAU -> println("Chuong trinh bat dau")
        TrangThai.DANG_CHAY -> println("Chuong trinh dang chay")
        TrangThai.HOAN_TAT -> println("Chuong trinh hoan tat")
        TrangThai.LOI -> println("Chuong trinh gap loi")
    }

    // thu try catch
    try {
        val x = "abc".toInt() // loi ep kieu
        println("Ket qua: $x")
    } catch (e: Exception) {
        println("Gap ngoai le: ${e.message}")
    }

    println("=== KET THUC ===")
}
