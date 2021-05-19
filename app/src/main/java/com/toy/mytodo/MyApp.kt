package com.toy.mytodo

import android.app.Application
import android.content.Context

class MyApp: Application() {

    companion object{
        private val instance: MyApp= MyApp()

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun getInstance(): Application= instance
    }
}