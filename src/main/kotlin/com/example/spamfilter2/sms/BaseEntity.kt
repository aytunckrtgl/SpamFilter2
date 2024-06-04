package com.example.springfilterkotlin.sms

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
abstract class BaseEntity(id: UUID) : Serializable, Comparable<BaseEntity> {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  var id: UUID = id
    protected set

  @Version protected var version: Int = 0

  @CreatedDate protected var createdDate: LocalDateTime = LocalDateTime.now()

  @LastModifiedDate protected var lastModifiedDate: LocalDateTime = LocalDateTime.now()

  fun copyFrom(other: BaseEntity) {
    this.id = other.id
    this.version = other.version
    this.createdDate = other.createdDate
    this.lastModifiedDate = other.lastModifiedDate
  }

  override fun equals(other: Any?): Boolean {
    var obj = other
    if (this === obj) {
      return true
    }
    if (obj == null) {
      return false
    }
    if (obj is HibernateProxy) {
      obj = obj.hibernateLazyInitializer.implementation
    }
    if (javaClass != obj!!.javaClass) {
      return false
    }
    val other = obj as? BaseEntity
    return id == other!!.id
  }

  override fun hashCode(): Int {
    val prime = 31
    var result = 1
    result = prime * result + id.hashCode()
    return result
  }

  override fun compareTo(other: BaseEntity) = id.compareTo(other.id)

  companion object {
    private const val serialVersionUID: Long = 65484949685L
  }
}
