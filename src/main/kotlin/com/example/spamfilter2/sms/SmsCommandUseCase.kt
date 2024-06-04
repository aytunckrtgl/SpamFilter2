package com.example.springfilterkotlin.sms

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.springframework.web.client.RestTemplate

@Service
@Transactional
class SmsCommandUseCase(
    val smsPort: SmsPort,
    val spamPort: SpamPort,
    val restTemplate: RestTemplate
) {

    fun ekle(sms: Sms) {
        if (isSpam(sms.smsIcerigi)) {
            spamPort.ekle(sms)
        } else {
            smsPort.ekle(sms)
        }
    }

    private fun isSpam(smsIcerigi: String): Boolean {
        val url = "http://localhost:5000/classify"
        val response = restTemplate.postForObject(url, mapOf("message" to smsIcerigi), Map::class.java)
        return response?.get("spam") as? Boolean ?: false
    }

    fun smsGetir(numara: String): List<SmsJpaEntity> {
        return smsPort.getir(numara)
    }

    fun spamGetir(numara: String): List<SpamJpaEntity> {
        return spamPort.getir(numara)
    }

    fun smsBildir(sms: Sms) {
        spamPort.sil(sms)
        smsPort.ekle(sms)
        val url = "http://localhost:5000/smsbildir"
        val response = restTemplate.postForObject(url, mapOf("message" to sms.smsIcerigi), Map::class.java)
    }

    fun spamBildir(sms: Sms) {
        smsPort.sil(sms)
        spamPort.ekle(sms)
        val url = "http://localhost:5000/spambildir"
        val response = restTemplate.postForObject(url, mapOf("message" to sms.smsIcerigi), Map::class.java)
    }
}
