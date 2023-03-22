package com.example.onroad.classes

class Driver {
    var name:String = "name"
    var car:String = "car model"
    var service:String = "tour guide or driver"
    var rating:Int = 0

    constructor()
    constructor(name:String,
                car:String,
                service:String,
                rating:Int){
        this.name = name
        this.car = car
        this.service= service
        this.rating = rating

    }
}