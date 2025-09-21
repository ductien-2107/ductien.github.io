package com.example.bai1

// lop thiet ke doi tuong
class DienThoaiThongMinh {
    var ten: String = "Dien thoai vo danh"
    var pin: Int = 100

    fun goiDien(so: String) {
        println("Dang goi den so $so ...")
    }

    fun sacPin() {
        pin = 100
        println("Pin da duoc sac day")
    }
}

fun main() {
    // tao doi tuong tu lop
    val dienThoai1 = DienThoaiThongMinh()
    dienThoai1.ten = "Galaxy A55"
    dienThoai1.pin = 75

    println("Thong tin dien thoai: ${dienThoai1.ten}, pin: ${dienThoai1.pin}%")

    // su dung phuong thuc
    dienThoai1.goiDien("0123456789")
    dienThoai1.sacPin()
    println("Pin hien tai: ${dienThoai1.pin}%")

    // tao them doi tuong khac
    val dienThoai2 = DienThoaiThongMinh()
    dienThoai2.ten = "iPhone 16"
    dienThoai2.pin = 50
    println("Thong tin dien thoai 2: ${dienThoai2.ten}, pin: ${dienThoai2.pin}%")
}
