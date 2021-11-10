package com.example.springboottemplate

import com.example.springboottemplate.domain.user.Role
import com.example.springboottemplate.domain.user.User
import com.example.springboottemplate.repository.user.RoleRepository
import com.example.springboottemplate.repository.user.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class JpaTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Test
    fun testAutoWireIsFine() {
        Assertions.assertNotNull(userRepository)

        val newUser = User()

        userRepository.save(newUser)
    }

    @Test
    fun testCreateAndPersistUser(){
        val newUser = User()

        Assertions.assertNull(newUser.id, "id should be null before persisting")
        userRepository.save(newUser)
        Assertions.assertNotNull(newUser.id, "id should not be null after persisting")

        val restoredUser = userRepository.findAll().first()
        Assertions.assertEquals(newUser.id, restoredUser.id, "id should be the same")

        Assertions.assertNull(newUser.name, "name should be null as it not assigned yet")
        newUser.name = "test"
        userRepository.save(newUser)

        val userWithName = userRepository.findAll().first()

        Assertions.assertEquals(newUser.name, userWithName.name, "name should be the same")
        Assertions.assertEquals(newUser.id, userWithName.id, "id should be the same")
    }

    @Test
    fun testCreateAndPersistRole(){
        val parentRole = Role(name = "parent")

        Assertions.assertNull(parentRole.id, "id should be null before persisting")
        roleRepository.saveAndFlush(parentRole)
        Assertions.assertNotNull(parentRole.id, "id should not be null after persisting")

        val childRole = Role(name = "child")
        childRole.parentRole = parentRole

        roleRepository.saveAndFlush(childRole)
        Assertions.assertNotNull(childRole.id, "id should not be null after persisting")
    }
}