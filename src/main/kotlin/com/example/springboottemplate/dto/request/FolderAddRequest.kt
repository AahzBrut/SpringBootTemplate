package com.example.springboottemplate.dto.request

data class FolderAddRequest(
    val parentId: Int? = null,
    val name: String? = null,
    val description: String? = null
)
