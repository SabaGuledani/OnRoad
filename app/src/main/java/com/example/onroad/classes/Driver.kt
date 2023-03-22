package com.example.onroad.classes

class Driver {
    var name:String = "name"
    var car:String = "car model"
    var status:String = "tour guide or driver"
    var rating:Float = 0.0F

    constructor()
    constructor(name:String,
                car:String,
                status:String,
                rating:Float){
        this.name = name
        this.car = car
        this.status= status
        this.rating = rating

    }
}