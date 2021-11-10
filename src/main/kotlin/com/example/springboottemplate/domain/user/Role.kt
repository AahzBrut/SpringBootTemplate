package com.example.springboottemplate.domain.user

import com.example.springboottemplate.domain.IdEntity
import javax.persistence.AttributeOverride
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "ROLE")
@AttributeOverride(name = "id", column = Column(name = "ROLE_ID"))
class Role(

    id: Short? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    var parentRole : Role? = null,

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "parentRole")
    var childRoles : MutableList<Role> = mutableListOf(),

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    ) : IdEntity<Short>(id)