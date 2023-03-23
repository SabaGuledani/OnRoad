package com.example.onroad.classes

class TourOperator:User {
    var car:String = "car model"
    //status 1 means Driver, 2 guide, 3 Driver-Guide, Int is for saving space in
    //database
    var status:Int = 1
    var rating:Float = 0.0F


    constructor()
    constructor(useruid:String,
                name:String,
                surname:String,
                number:String,
                number2:String,
                email:String,
                languages:ArrayList<String>,
                country:String,
                car:String,
                status:Int,
                rating:Float){
        this.useruid = useruid
        this.name = name
        this.surname = surname
        this.languages = languages
        this.number=number
        this.number2 = number2
        this.email = email
        this.car = car
        this.status = status
        this.rating = rating
        this.country = country
    }
}