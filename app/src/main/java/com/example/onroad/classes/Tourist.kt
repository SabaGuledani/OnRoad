package com.example.onroad.classes

class Tourist:User {
    constructor(useruid:String,
                name:String,
                surname:String,
                number:String,
                number2:String,
                email:String,
                languages:ArrayList<String>,
                country:String,
                ){
        this.useruid = useruid
        this.name = name
        this.surname = surname
        this.languages = languages
        this.number=number
        this.number2 = number2
        this.email = email
        this.country = country
    }
}