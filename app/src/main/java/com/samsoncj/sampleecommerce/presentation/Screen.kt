package com.samsoncj.sampleecommerce.presentation

sealed class Screen(val route:String){
    object HomeScreen:Screen("home_screen")
}