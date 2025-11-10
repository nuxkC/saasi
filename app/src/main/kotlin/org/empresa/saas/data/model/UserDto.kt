package org.empresa.saas.data.model

import kotlinx.serialization.Serializable
import org.empresa.saas.domain.model.CompanyId
import org.empresa.saas.domain.model.UserId

@Serializable
data class UserProfileDto(
    val id: UserId,
    val email: String,
    val displayName: String,
    val name: String,
    val companyAccess: List<CompanyAccessDto>,
    val status: String
)

@Serializable
data class CompanyAccessDto(
    val companyId: CompanyId,
    val companyName: String,
    val role: String
)
