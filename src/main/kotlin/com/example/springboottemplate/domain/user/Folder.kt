package com.example.springboottemplate.domain.user

import com.example.springboottemplate.domain.HierEntity
import com.example.springboottemplate.domain.IdEntity
import javax.persistence.AttributeOverride
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany


@Entity(name = "FOLDER")
@AttributeOverride(name = "id", column = Column(name = "FOLDER_ID"))
class Folder(

    id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Folder::class)
    @JoinColumn(name = "PARENT_ID")
    override var parent: HierEntity<Int, Long>? = null,

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "parent", targetEntity = Folder::class)
    override var children: MutableList<HierEntity<Int, Long>> = mutableListOf(),

    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "folder", targetEntity = FolderItem::class)
    override var contents: MutableList<IdEntity<Long>> = mutableListOf(),

    @Column(name="NAME")
    override var name: String? = null,

    @Column(name = "DESCRIPTION")
    override var description: String? = null,

) : HierEntity<Int, Long>(id)