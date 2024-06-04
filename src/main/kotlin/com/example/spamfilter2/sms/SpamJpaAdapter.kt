package com.example.springfilterkotlin.sms

import org.springframework.stereotype.Repository

@Repository
class SpamJpaAdapter(
    private val spamJpaRepository: SpamJpaRepository
) : SpamPort {

    override fun ekle(sms: Sms) {
        val spamJpaEntity = SpamJpaEntity(sms)
        spamJpaRepository.save(spamJpaEntity)

    }

    override fun getir(numara: String): List<SpamJpaEntity> {

        return spamJpaRepository.findAllByKime(numara)

    }
    override fun sil(sms: Sms) {
        spamJpaRepository.deleteById(SpamJpaEntity(sms).id)
    }
}
