package com.kawal.mvvm.data.model

import java.util.*

data class Village(val id: String, val village_name: String,
                   val created_at: Date, val updated_at: Date) {

    override fun toString(): String {
        return this.village_name
    }
}
