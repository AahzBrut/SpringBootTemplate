package com.example.springboottemplate.repository.user

import com.example.springboottemplate.domain.user.RolesFolder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesFolderRepository : JpaRepository<RolesFolder, Int>