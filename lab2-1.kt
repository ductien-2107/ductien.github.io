package com.example.smarthome

// lop cha
open class SmartDevice(
    val name: String,
    val category: String,
    val deviceType: String
) {
    var deviceStatus: String = "off"

    fun turnOn() {
        deviceStatus = "on"
        println("$name da duoc bat")
    }

    fun turnOff() {
        deviceStatus = "off"
        println("$name da tat")
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// lop con SmartTv
class SmartTvDevice(
    name: String,
    category: String,
    deviceType: String = "TV"
) : SmartDevice(name, category, deviceType) {

    private var volume: Int = 50
    private var channel: Int = 1

    fun increaseVolume() {
        if (deviceStatus == "on" && volume < 100) {
            volume++
            println("Volume tang len: $volume")
        }
    }

    fun decreaseVolume() {
        if (deviceStatus == "on" && volume > 0) {
            volume--
            println("Volume giam xuong: $volume")
        }
    }

    fun nextChannel() {
        if (deviceStatus == "on") {
            channel++
            println("Chuyen den kenh: $channel")
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on" && channel > 1) {
            channel--
            println("Quay lai kenh: $channel")
        }
    }

    fun printTvStatus() {
        println("TV: volume=$volume, channel=$channel, status=$deviceStatus")
    }
}

// lop con SmartLight
class SmartLightDevice(
    name: String,
    category: String,
    deviceType: String = "Light"
) : SmartDevice(name, category, deviceType) {

    private var brightness: Int = 100

    fun increaseBrightness() {
        if (deviceStatus == "on" && brightness < 100) {
            brightness += 10
            println("Do sang tang len: $brightness%")
        }
    }

    fun decreaseBrightness() {
        if (deviceStatus == "on" && brightness > 0) {
            brightness -= 10
            println("Do sang giam xuong: $brightness%")
        }
    }

    fun printLightStatus() {
        println("Light: brightness=$brightness, status=$deviceStatus")
    }
}

// SmartHome
class SmartHome(
    private val tv: SmartTvDevice,
    private val light: SmartLightDevice
) {
    private var deviceTurnOnCount: Int = 0

    fun turnOnTv() {
        if (tv.deviceStatus != "on") {
            tv.turnOn()
            deviceTurnOnCount++
        }
    }

    fun turnOnLight() {
        if (light.deviceStatus != "on") {
            light.turnOn()
            deviceTurnOnCount++
        }
    }

    fun turnOffTv() {
        if (tv.deviceStatus == "on") {
            tv.turnOff()
            deviceTurnOnCount--
        }
    }

    fun turnOffLight() {
        if (light.deviceStatus == "on") {
            light.turnOff()
            deviceTurnOnCount--
        }
    }

    fun decreaseTvVolume() {
        if (tv.deviceStatus == "on") tv.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        if (tv.deviceStatus == "on") tv.previousChannel()
    }

    fun printSmartTvInfo() {
        tv.printDeviceInfo()
        tv.printTvStatus()
    }

    fun printSmartLightInfo() {
        light.printDeviceInfo()
        light.printLightStatus()
    }

    fun decreaseLightBrightness() {
        if (light.deviceStatus == "on") light.decreaseBrightness()
    }

    fun printDeviceCount() {
        println("So thiet bi dang bat: $deviceTurnOnCount")
    }
}

fun main() {
    val smartTv = SmartTvDevice("Samsung TV", "Living Room")
    val smartLight = SmartLightDevice("Philips Light", "Living Room")
    val smartHome = SmartHome(smartTv, smartLight)

    // bat thiet bi
    smartHome.turnOnTv()
    smartHome.turnOnLight()
    smartHome.printDeviceCount()

    // su dung tv
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()

    // su dung light
    smartHome.decreaseLightBrightness()
    smartHome.printSmartLightInfo()

    // tat thiet bi
    smartHome.turnOffTv()
    smartHome.turnOffLight()
    smartHome.printDeviceCount()
}
