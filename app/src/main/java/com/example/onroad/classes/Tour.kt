package com.example.onroad.classes

class Tour {
    var ownerOperator:TourOperator? = null
    var tourDesctiprion:String = ""
    var tourName:String = ""
    var tourRating:Float = 0.0F

    constructor(){}

    constructor(ownerOperator: TourOperator,
                tourText:String,
                tourName:String,
                tourRating:Float
                ){

        this.ownerOperator = ownerOperator
        this.tourDesctiprion = tourText
        this.tourName = tourName
        this.tourRating = tourRating
    }
}