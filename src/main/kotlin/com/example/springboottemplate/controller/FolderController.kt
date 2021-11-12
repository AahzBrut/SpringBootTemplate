package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.FolderAddRequest
import com.example.springboottemplate.dto.request.FolderItemAddRequest
import com.example.springboottemplate.dto.response.FolderResponse
import com.example.springboottemplate.service.FolderItemService
import com.example.springboottemplate.service.FolderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

const val GetAllFolders = "/folders"
const val AddFolder = "/folders"
const val AddFolderItem = "/folders/items"

@RestController
class FolderController(
    private val folderService: FolderService,
    private val folderItemService: FolderItemService
) {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(GetAllFolders, produces = ["application/json"])
    fun getAllFolders(): List<FolderResponse> {
        return folderService.getAll()
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(AddFolder, consumes = ["application/json"], produces = ["application/json"])
    fun addNewFolder(@RequestBody request: FolderAddRequest) {
        folderService.addNew(request)
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(AddFolderItem, consumes = ["application/json"], produces = ["application/json"])
    fun addNewFolderItem(@RequestBody request: FolderItemAddRequest) {
        folderItemService.addNew(request)
    }
}