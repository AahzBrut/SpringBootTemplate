package com.example.springboottemplate.service

import com.example.springboottemplate.dto.request.user.RoleAddRequest
import com.example.springboottemplate.dto.request.user.RolesFolderAddRequest
import com.example.springboottemplate.dto.response.user.RoleResponse
import com.example.springboottemplate.dto.response.user.RolesFolderResponse
import com.example.springboottemplate.service.domain.RoleDomainService
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleDomainService: RoleDomainService
) {

    fun getAllRoles() : List<RoleResponse> =
        roleDomainService.getAllRoles()

    fun addNewRole(request: RoleAddRequest): RoleResponse =
        roleDomainService.addNewRole(request)

    fun deleteRole(id: Short) {
        roleDomainService.deleteRole(id)
    }

    fun getRole(id: Short) : RoleResponse =
        roleDomainService.getRole(id)

    fun getFolder(id: Int): RolesFolderResponse {
        return roleDomainService.getFolder(id)
    }

    fun addFolder(request: RolesFolderAddRequest): RolesFolderResponse {
        return roleDomainService.addFolder(request)
    }

    fun deleteFolder(id: Int) {
        roleDomainService.deleteFolder(id)
    }

}