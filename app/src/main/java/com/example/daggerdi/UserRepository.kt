package com.example.daggerdi

import android.util.Log
import com.example.daggerdi.Constants.Companion.TAG
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email:String, password : String)
}

class SQLRepository @Inject constructor(): UserRepository {
    override fun saveUser(email:String, password : String){
        Log.d(TAG, "User saved in DB")
    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser(email:String, password : String){
        Log.d(TAG, "User saved in Firebase")
    }
}