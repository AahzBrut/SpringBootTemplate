package com.example.springboottemplate.dto.request

data class FolderItemAddRequest(
    val folderId: Int? = null,
    val name: String? = null,
    val description: String? = null,
)
