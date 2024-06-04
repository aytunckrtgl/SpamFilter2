package com.example.springfilterkotlin.sms


interface SmsPort {

    fun ekle(sms: Sms)
    fun getir(numara: String): List<SmsJpaEntity>

    fun sil(sms: Sms)
}
