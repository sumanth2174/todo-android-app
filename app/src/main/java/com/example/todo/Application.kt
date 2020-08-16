package com.example.todo

import android.app.Application
import android.content.Context

class BaseApplication: Application()  {
    companion object {
        private var applicationContext: Context? = null

        fun getInstance() = applicationContext!!

        private fun initialise(application: Application) {
            applicationContext = application
        }

    }

    override fun onCreate() {
        super.onCreate()
        initialise(this)
    }
}