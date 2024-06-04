package com.example.springfilterkotlin.sms

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import java.util.*

interface SpamJpaRepository : CrudRepository<SpamJpaEntity, UUID>, JpaSpecificationExecutor<SpamJpaEntity> {
    fun findAllByKime(numara: String): List<SpamJpaEntity>
}
