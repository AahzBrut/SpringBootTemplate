package com.example.springboottemplate.dto.request.user

data class RoleAddRequest(
    val id: Short? = null,
    val parentId: Short? = null,
    val name: String? = null,
    val description: String? = null,
)
