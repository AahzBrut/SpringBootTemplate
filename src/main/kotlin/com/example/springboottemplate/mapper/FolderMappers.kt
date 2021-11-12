package com.example.springboottemplate.mapper

import com.example.springboottemplate.domain.user.Folder
import com.example.springboottemplate.domain.user.FolderItem
import com.example.springboottemplate.dto.request.FolderAddRequest
import com.example.springboottemplate.dto.request.FolderItemAddRequest
import com.example.springboottemplate.dto.response.FolderItemResponse
import com.example.springboottemplate.dto.response.FolderResponse

fun Folder.toFolderResponse(): FolderResponse =
    FolderResponse(
        id = this.id,
        name = this.name,
        description = this.description,
        childFolders = this.children.map { (it as Folder).toFolderResponse() },
        contents = this.contents.map { (it as FolderItem).toFolderItemResponse() }
    )

fun FolderAddRequest.toEntity(): Folder =
    Folder(
        parent = this.parentId?.let { Folder(it) },
        name = this.name,
        description = this.description
    )

fun FolderItemAddRequest.toEntity(): FolderItem =
    FolderItem(
        folder = this.folderId?.let { Folder(this.folderId) },
        name = this.name,
        description = this.description
    )

fun FolderItem.toFolderItemResponse(): FolderItemResponse =
    FolderItemResponse(
        id = this.id,
        folderId = this.folder?.id,
        name = this.name,
        description = this.description
    )