package com.example.smarthouse

import java.lang.reflect.Constructor

fun main(){

    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")


    println("Device name : ${smartTvDevice.name}")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()

}
class SmartTvDevice(deviceName: String, deviceCategory: String):SmartDevice(name = deviceName, category = deviceCategory){

}

open class SmartDevice(val name: String, val category: String ){

    var deviceStatus = "online"

    fun turnOn(){
        println("Smart device is turned on.")
    }

    fun turnOff(){
        println("Smart device is turned off.")
    }
}

//test fix