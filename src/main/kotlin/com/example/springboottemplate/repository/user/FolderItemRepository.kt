package com.example.springboottemplate.repository.user

import com.example.springboottemplate.domain.user.FolderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FolderItemRepository: JpaRepository<FolderItem, Long>