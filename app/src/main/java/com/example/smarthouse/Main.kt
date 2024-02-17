package com.example.smarthouse

import java.lang.reflect.Constructor

fun main() {

    //val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")

    var smartDevice : SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()


//    println("Device name : ${smartDevice.name}")
//    println("Category name : ${smartDevice.category}")
//    smartDevice.turnOn()
//    smartDevice.turnOff()

}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Tv"
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber = 1
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        channelNumber++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn(){
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is \" +\n" +
                "                \"set to $channelNumber.")
    }

    override fun turnOff(){
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, category: String) :
    SmartDevice(name = deviceName, category = category) {

    override val deviceType = "Smart Light"
    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff(){
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off. The brightness level is $brightnessLevel.")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        turnOffTv()
        turnOffLight()
    }
}

open class SmartDevice(val name: String, val category: String) {


    var deviceStatus = "online"

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "On"
        //println("Smart device is turned on.")
    }

    open fun turnOff() {
        deviceStatus = "Off"
        //println("Smart device is turned off.")
    }
}

//test fix new branch