package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.user.RoleAddRequest
import com.example.springboottemplate.dto.request.user.RolesFolderAddRequest
import com.example.springboottemplate.dto.response.user.RoleResponse
import com.example.springboottemplate.dto.response.user.RolesFolderResponse
import com.example.springboottemplate.service.RoleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

const val GetAllRoles = "/roles"
const val AddRole = "/roles"
const val DeleteRole = "/roles/{id}"
const val GetRole = "/roles/{id}"

const val GetRolesFolder = "/roles-folder/{id}"
const val AddRolesFolder = "/roles-folder"
const val DeleteRolesFolder = "/roles-folder/{id}"

@RestController
class RoleController(
    private val roleService: RoleService,
) {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(GetAllRoles, produces = ["application/json"])
    fun getAllRoles(): List<RoleResponse> {
        return roleService.getAllRoles()
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(AddRole, consumes = ["application/json"], produces = ["application/json"])
    fun addNewRole(@RequestBody request: RoleAddRequest): RoleResponse {
        return roleService.addNewRole(request)
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(DeleteRole)
    fun deleteRole(@PathVariable id: Short) {
        roleService.deleteRole(id)
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(GetRole, produces = ["application/json"])
    fun getRole(@PathVariable id: Short) : RoleResponse {
        return roleService.getRole(id)
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(GetRolesFolder, produces = ["application/json"])
    fun getRolesFolder(@PathVariable id: Int) : RolesFolderResponse {
        return roleService.getFolder(id)
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(AddRolesFolder, consumes = ["application/json"], produces = ["application/json"])
    fun addRolesFolder(@RequestBody request: RolesFolderAddRequest) : RolesFolderResponse {
        return roleService.addFolder(request)
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(DeleteRolesFolder)
    fun deleteRolesFolder(@PathVariable id: Int) {
        roleService.deleteFolder(id)
    }
}
