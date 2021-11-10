package com.example.springboottemplate.domain

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY
import org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class IdEntity<T : Serializable>(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @GenericGenerator(
        name = "sequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
            Parameter(name = CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_SEQ")
        ]
    )
    @Column(name = "ID")
    var id: T? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IdEntity<*>) return false

        return id != null && id == other.id
    }

    override fun hashCode() = Int.MAX_VALUE
}
