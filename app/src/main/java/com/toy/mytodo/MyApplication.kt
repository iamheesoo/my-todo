package com.toy.mytodo

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    companion object{
        private val instance: MyApplication= MyApplication()

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun getInstance(): Application= instance
    }
}