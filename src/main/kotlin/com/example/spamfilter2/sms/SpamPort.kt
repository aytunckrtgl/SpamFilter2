package com.example.springfilterkotlin.sms

interface SpamPort {

    fun ekle(sms: Sms)

    fun getir(numara: String): List<SpamJpaEntity>

    fun sil(sms: Sms)
}
