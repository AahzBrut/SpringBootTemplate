package com.example.springboottemplate.mapper.user

import com.example.springboottemplate.domain.user.Role
import com.example.springboottemplate.dto.request.user.RoleAddRequest
import com.example.springboottemplate.dto.response.user.RoleResponse


fun Role.toRoleResponse(): RoleResponse {
    return RoleResponse(
        id = this.id,
        parentId = this.parentRole?.id,
        childRoles = this.childRoles.map { it.toRoleResponse() },
        name = this.name,
        description = this.description
    )
}

fun RoleAddRequest.toRole(): Role {
    return Role(
        parentRole = this.parentId?.let { Role(id = this.parentId) },
        name = this.name,
        description = this.description
    )
}