package com.example.mainproject.commons.extensions

import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.configureToolbar(title: String, enableBackButton: Boolean){

    supportActionBar?.apply{
        this.title = title
        setDisplayHomeAsUpEnabled(enableBackButton)
    }
}

