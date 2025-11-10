package org.empresa.saas.domain.model

data class User(
    val id: UserId,
    val email: String,
    val displayName: String,
    val name: String,
    val companyAccess: List<CompanyAccess>,
    val status: UserStatus
)

data class CompanyAccess(
    val companyId: CompanyId,
    val companyName: String,
    val role: UserRole
)
