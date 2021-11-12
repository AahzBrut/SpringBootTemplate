package com.example.springboottemplate.service

import com.example.springboottemplate.dto.request.FolderAddRequest
import com.example.springboottemplate.dto.response.FolderResponse
import com.example.springboottemplate.service.domain.FolderDomainService
import org.springframework.stereotype.Service

@Service
class FolderService(
    private val folderDomainService: FolderDomainService
) {

    fun getAll(): List<FolderResponse>{
        return folderDomainService.getAll()
    }

    fun addNew(request: FolderAddRequest){
        return folderDomainService.addNew(request)
    }
}