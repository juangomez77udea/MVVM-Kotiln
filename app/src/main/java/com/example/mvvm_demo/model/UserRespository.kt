package com.example.mvvm_demo.model

import kotlinx.coroutines.delay

class UserRespository {

    fun fetchUserData(): UserData{

        return UserData("Fulanito", 28 )
    }
}