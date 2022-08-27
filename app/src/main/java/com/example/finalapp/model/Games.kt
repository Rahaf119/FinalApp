package com.example.finalapp.model


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Games (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId : Int )