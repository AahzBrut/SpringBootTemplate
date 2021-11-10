package com.example.springboottemplate.repository.user

import com.example.springboottemplate.domain.user.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Short>
