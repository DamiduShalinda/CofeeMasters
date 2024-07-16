package com.damidu.cofeemasters

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class  DataManager(app : Application) : AndroidViewModel(app){

    var menu: List<Category> by mutableStateOf(listOf())
    private var cart: List<ItemInCart> by mutableStateOf(listOf())

    init {
        fetchMenuData()
    }

    private fun fetchMenuData(): Unit {

        try {
            viewModelScope.launch {
                menu =  API.menuService.fetchMenu()
            }
        } catch (ex : Exception){
            println(ex.message)
        }
    }

    fun cartAdd(product: Product): Unit {
        var found = false
        cart.forEach{
            if (product.id == it.product.id){
                found = true
            }
        }
        if (!found){
            cart = listOf(*cart.toTypedArray() , ItemInCart(product , 1))
        }
    }

    fun cartRemove(product: Product) : Unit {
        val aux = cart.toMutableList()
        aux.removeAll{it.product.id==product.id}
        cart = listOf(*aux.toTypedArray())
    }

    fun cartClear() : Unit {
        cart = listOf()
    }


}