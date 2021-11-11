package com.example.springboottemplate.domain.user

import com.example.springboottemplate.domain.IdEntity
import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "ROLE")
@AttributeOverride(name = "id", column = Column(name = "ROLE_ID"))
class Role(

    id: Short? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLDER_ID")
    var folder : RolesFolder? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    ) : IdEntity<Short>(id)