package com.example.daggerdi

import android.util.Log
import com.example.daggerdi.Constants.Companion.TAG
import javax.inject.Inject


interface NotificationService{
    fun send(to: String, from:String, body:String)
}

class EmailService @Inject constructor() :NotificationService{
    override fun send(to: String, from:String, body:String){
        Log.d(TAG, "Email Sent")
    }
}

class MessageService(private val retryCount: Int) : NotificationService{
    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "Message Sent with retry $retryCount")
    }

}