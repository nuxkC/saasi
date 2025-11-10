package org.empresa.saas.data.mapper

import org.empresa.saas.data.model.CompanyAccessDto
import org.empresa.saas.data.model.UserDto
import org.empresa.saas.data.model.UserProfileDto
import org.empresa.saas.domain.model.CompanyAccess
import org.empresa.saas.domain.model.User
import org.empresa.saas.domain.model.UserRole
import org.empresa.saas.domain.model.UserStatus

fun UserDto.toDomain(): User {
    return User(
        id = id,
        email = email,
        displayName = displayName,
        name = name,
        companyAccess = companyAccess.map { it.toDomain() },
        status = UserStatus.valueOf(status)
    )
}

fun UserProfileDto.toDomain(): User {
    return User(
        id = id,
        email = email,
        displayName = displayName,
        name = name,
        companyAccess = companyAccess.map { it.toDomain() },
        status = UserStatus.valueOf(status)
    )
}

fun CompanyAccessDto.toDomain(): CompanyAccess {
    return CompanyAccess(
        companyId = companyId,
        companyName = companyName,
        role = UserRole.valueOf(role)
    )
}
