package com.kawal.mvvm.data.model

import java.util.*

data class District(val id: String, val district_name: String,
                    val created_at: Date, val updated_at: Date) {

    override fun toString(): String {
        return this.district_name
    }
}