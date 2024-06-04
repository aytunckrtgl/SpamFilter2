package com.example.springfilterkotlin.sms

import java.util.*


data class SmsEkleCommand(
    val kimden: String,
     val kime: String,
     val smsIcerigi: String
) {
    fun toDomainEntity(): Sms {
        return Sms(
            UUID.randomUUID(),
            kimden,
            kime,
            smsIcerigi)
    }
}
