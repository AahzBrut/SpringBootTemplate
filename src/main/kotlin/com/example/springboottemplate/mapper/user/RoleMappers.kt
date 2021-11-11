package com.example.springboottemplate.mapper.user

import com.example.springboottemplate.domain.user.Role
import com.example.springboottemplate.domain.user.RolesFolder
import com.example.springboottemplate.dto.request.user.RoleAddRequest
import com.example.springboottemplate.dto.request.user.RolesFolderAddRequest
import com.example.springboottemplate.dto.response.user.RoleResponse
import com.example.springboottemplate.dto.response.user.RolesFolderResponse
import liquibase.pro.packaged.it


fun Role.toRoleResponse(): RoleResponse =
    RoleResponse(
        id = this.id,
        folderId = this.folder?.id,
        name = this.name,
        description = this.description
    )

fun RoleAddRequest.toRole(): Role =
    Role(
        folder = this.folderId?.let { RolesFolder(it) },
        name = this.name,
        description = this.description
    )

fun RolesFolder.toRolesFolderResponse(): RolesFolderResponse =
    RolesFolderResponse(
        id = this.id,
        childFolders = this.childFolders.map { it.toRolesFolderResponse() },
        roles = this.roles.map { it.toRoleResponse() },
        name = this.name,
        description = this.description
    )

fun RolesFolderAddRequest.toRolesFolder(): RolesFolder =
    RolesFolder(
        id = this.id,
        parentFolder = this.parentId?.let { RolesFolder(it) },
        name = this.name,
        description = this.description
    )