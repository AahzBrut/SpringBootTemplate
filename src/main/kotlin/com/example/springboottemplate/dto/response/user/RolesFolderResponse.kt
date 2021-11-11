package com.example.springboottemplate.dto.response.user

data class RolesFolderResponse(
    val id: Int? = null,
    val childFolders: List<RolesFolderResponse>? = emptyList(),
    val roles: List<RoleResponse>? = emptyList(),
    val name: String? = null,
    val description: String? = null,
)