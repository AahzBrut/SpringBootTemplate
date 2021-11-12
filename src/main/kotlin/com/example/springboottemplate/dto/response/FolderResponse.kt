package com.example.springboottemplate.dto.response

data class FolderResponse(
    val id: Int? = null,
    val childFolders: List<FolderResponse> = emptyList(),
    val contents: List<FolderItemResponse> = emptyList(),
    val name: String? = null,
    val description: String? = null,
)
