package com.example.springfilterkotlin.sms

import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SmsJpaAdapter(
    private val smsJpaRepository: SmsJpaRepository
) : SmsPort {

    override fun ekle(sms: Sms) {
        val smsJpaEntity = SmsJpaEntity(sms)
        smsJpaRepository.save(smsJpaEntity)

    }

    override fun getir(numara: String): List<SmsJpaEntity> {

        return smsJpaRepository.findAllByKime(numara)

    }

    override fun sil(sms: Sms) {
        smsJpaRepository.deleteById(SmsJpaEntity(sms).id)
    }
}
