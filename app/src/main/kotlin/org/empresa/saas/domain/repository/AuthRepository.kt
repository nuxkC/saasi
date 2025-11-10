package org.empresa.saas.domain.repository

import org.empresa.saas.domain.model.User
import org.empresa.saas.core.util.Result

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User, String>
}
