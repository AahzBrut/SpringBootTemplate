package com.example.springboottemplate.service

import com.example.springboottemplate.dto.request.FolderItemAddRequest
import com.example.springboottemplate.service.domain.FolderItemDomainService
import org.springframework.stereotype.Service

@Service
class FolderItemService(
    private val folderItemDomainService: FolderItemDomainService
) {

    fun addNew(request: FolderItemAddRequest) {
        folderItemDomainService.addNew(request)
    }


}