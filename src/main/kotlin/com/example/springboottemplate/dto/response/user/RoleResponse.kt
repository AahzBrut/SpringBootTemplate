package com.example.springboottemplate.dto.response.user

data class RoleResponse(
    val id: Short? = null,
    val parentId: Short? = null,
    val childRoles: List<RoleResponse> = emptyList(),
    val name: String? = null,
    val description : String? = null,
)
