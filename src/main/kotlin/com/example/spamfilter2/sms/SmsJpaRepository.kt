package com.example.springfilterkotlin.sms
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

import java.util.*

interface SmsJpaRepository : CrudRepository<SmsJpaEntity, UUID>, JpaSpecificationExecutor<SmsJpaEntity> {
    fun findAllByKime(numara: String): List<SmsJpaEntity>
}


