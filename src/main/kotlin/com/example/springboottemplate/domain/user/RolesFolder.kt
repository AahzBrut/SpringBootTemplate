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

@Entity(name = "ROLES_FOLDER")
@AttributeOverride(name = "id", column = Column(name = "ROLES_FOLDER_ID"))
class RolesFolder(

    id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    var parentFolder: RolesFolder? = null,

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "parentFolder")
    var childFolders: MutableList<RolesFolder> = mutableListOf(),

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "folder")
    var roles: MutableList<Role> = mutableListOf(),

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    ) : IdEntity<Int>(id)