package com.kawal.mvvm.data.model

data class Voter(val district: District?, val village: Village?) {
    constructor(id: String, name: String,
                address: String, district_id: String,
                village_id: String, district_fixed: String,
                nik: String, phone_number: String,
                photo_path: String, coordinator_name: String)
            : this(null, null) {}
}