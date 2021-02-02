package com.strangecoder.region

import com.strangecoder.region.models.Language


object Utils {

    fun listToString(list: List<String>): String {
        var stringRes = ""
        for (item in list) {
            stringRes += "$item "
        }
        return stringRes
    }

    fun objectListToString(list: List<Language>): String {
        var stringRes = ""
        for (item in list) {
            stringRes += "${item.name} "
        }
        return stringRes
    }
}