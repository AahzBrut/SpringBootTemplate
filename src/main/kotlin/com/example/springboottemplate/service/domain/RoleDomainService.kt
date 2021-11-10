package com.example.springboottemplate.service.domain

import com.example.springboottemplate.dto.request.user.RoleAddRequest
import com.example.springboottemplate.dto.response.user.RoleResponse
import com.example.springboottemplate.mapper.user.toRole
import com.example.springboottemplate.mapper.user.toRoleResponse
import com.example.springboottemplate.repository.user.RoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoleDomainService(
    private val roleRepository: RoleRepository
) {

    @Transactional
    fun getAllRoles(): List<RoleResponse> =
        roleRepository.findAll().map { it.toRoleResponse() }

    @Transactional
    fun addNewRole(request: RoleAddRequest) : RoleResponse =
        roleRepository.save(request.toRole()).toRoleResponse()

    @Transactional
    fun deleteRole(id: Short) {
        roleRepository.deleteById(id)
    }

    @Transactional
    fun getRole(id: Short) : RoleResponse =
        roleRepository.getById(id).toRoleResponse()
}