package com.example.core.nav

sealed class Routes(val name: String){
    data object Home: Routes("home")
    data object Details: Routes("details/{id}"){
        fun createRoute(id: Int): String = "details/$id"
    }
}