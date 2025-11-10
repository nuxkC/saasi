package org.empresa.saas.domain.usecase.auth

import org.empresa.saas.core.util.Result
import org.empresa.saas.domain.model.User
import org.empresa.saas.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User, String> {
        return authRepository.login(email, password)
    }
}
