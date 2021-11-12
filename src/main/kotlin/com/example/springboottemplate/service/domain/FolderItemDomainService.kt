package com.example.springboottemplate.service.domain

import com.example.springboottemplate.dto.request.FolderItemAddRequest
import com.example.springboottemplate.mapper.toEntity
import com.example.springboottemplate.repository.user.FolderItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FolderItemDomainService(
    private val folderItemRepository: FolderItemRepository
) {

    @Transactional
    fun addNew(request: FolderItemAddRequest) {
        folderItemRepository.save(request.toEntity())
    }

}