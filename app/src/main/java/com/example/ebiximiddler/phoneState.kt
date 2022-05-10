package com.example.ebiximiddler

import java.util.regex.Pattern

class PhoneState: TextFieldState(
    validator = ::isStartWith,
    errMessage= ::phoneErrMsg,
) {

}

private const val STARTS_WITH_ST = "63"
private const val STARTS_WITH_SF = "65"

private fun isStartWith(phone: String): Boolean {
    return phone.startsWith(STARTS_WITH_ST) || phone.startsWith(STARTS_WITH_SF)
}


private fun phoneErrMsg(phone: String) = "Phone should starts with 63 or 65"

