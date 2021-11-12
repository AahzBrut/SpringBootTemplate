package com.example.springboottemplate.service.domain

import com.example.springboottemplate.dto.request.FolderAddRequest
import com.example.springboottemplate.dto.response.FolderResponse
import com.example.springboottemplate.mapper.toEntity
import com.example.springboottemplate.mapper.toFolderResponse
import com.example.springboottemplate.repository.user.FolderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FolderDomainService(
    private val folderRepository: FolderRepository
) {

    @Transactional
    fun getAll(): List<FolderResponse> {
        return folderRepository.findAll().map { it.toFolderResponse() }
    }

    @Transactional
    fun addNew(request: FolderAddRequest) {
        folderRepository.save(request.toEntity())
    }


}