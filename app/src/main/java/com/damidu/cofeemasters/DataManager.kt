package com.damidu.cofeemasters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class  DataManager{

    private var menu: List<Category> by mutableStateOf(listOf())
    private var cart: List<ItemInCart> by mutableStateOf(listOf())

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