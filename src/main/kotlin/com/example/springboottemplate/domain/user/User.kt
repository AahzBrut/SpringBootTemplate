package com.example.springboottemplate.domain.user

import com.example.springboottemplate.domain.IdEntity
import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "USER")
@AttributeOverride(name = "id", column = Column(name = "USER_ID"))
class User(

    id: Int? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "FIRST_NAME")
    var firstName: String? = null,

    @Column(name = "PATRONYMIC")
    var patronymic: String? = null,

    @Column(name = "LAST_NAME")
    var lastName: String? = null,

) : IdEntity<Int>(id)