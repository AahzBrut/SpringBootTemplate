package com.example.springboottemplate.repository.user

import com.example.springboottemplate.domain.user.Folder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FolderRepository: JpaRepository<Folder, Int>