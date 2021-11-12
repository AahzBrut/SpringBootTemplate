package com.example.springboottemplate.domain.user

import com.example.springboottemplate.domain.IdEntity
import javax.persistence.AttributeOverride
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "FOLDER_ITEM")
@AttributeOverride(name = "id", column = Column(name = "FOLDER_ITEM_ID"))
class FolderItem(

    id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLDER_ID")
    var folder: Folder? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null

): IdEntity<Long>(id)