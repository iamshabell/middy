package com.example.ebiximiddler


import  androidx.compose.runtime.*


// length => 9
// start with 63 or 65
open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errMessage: (String) -> String,
) {
    var text by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    fun validate() {
         error = if (isValid()) {
             null
         } else {
            errMessage(text)
        }
    }


    fun isValid() = validator(text)

}