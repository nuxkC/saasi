package org.empresa.saas.data.repository

import kotlinx.coroutines.delay
import org.empresa.saas.core.util.Result
import org.empresa.saas.domain.model.CompanyAccess
import org.empresa.saas.domain.model.User
import org.empresa.saas.domain.model.UserRole
import org.empresa.saas.domain.model.UserStatus
import org.empresa.saas.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String): Result<User, String> {
        delay(1000) // Simular latencia de red
        return if (email == "test@empresa.org" && password == "password") {
            Result.Success(
                User(
                    id = "user-123",
                    email = "test@empresa.org",
                    displayName = "Test User",
                    name = "John Doe",
                    companyAccess = listOf(
                        CompanyAccess(
                            companyId = "comp-abc",
                            companyName = "Empresa ABC",
                            role = UserRole.TECHNICIAN
                        )
                    ),
                    status = UserStatus.ACTIVE
                )
            )
        } else {
            Result.Error("Credenciales inválidas")
        }
    }
}
