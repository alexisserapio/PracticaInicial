package com.alexisserapio.android14.practicas.explicitintent

import java.io.Serializable

data class Person(
    var name: String,
    var lastName: String,
    var age: Int,
    var isMarried: Boolean,
    var gender: Char,
    var discountCode: Byte
): Serializable