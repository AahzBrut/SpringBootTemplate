package com.example.springboottemplate.dto.request.user

data class RolesFolderAddRequest(
    val id: Int? = null,
    val parentId: Int? = null,
    val name: String? = null,
    val description: String? = null,
)
