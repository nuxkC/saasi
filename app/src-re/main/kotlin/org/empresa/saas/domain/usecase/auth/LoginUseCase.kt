package org.empresa.saas.domain.usecase.auth

import org.empresa.saas.core.util.Result
import org.empresa.saas.domain.model.User
import org.empresa.saas.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User, String> {
        // Aquí se podrían añadir validaciones de negocio si fueran necesarias
        return authRepository.login(email, password)
    }
}
