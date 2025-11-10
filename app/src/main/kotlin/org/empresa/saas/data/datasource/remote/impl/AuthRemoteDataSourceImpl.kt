package org.empresa.saas.data.datasource.remote.impl

import kotlinx.coroutines.delay
import org.empresa.saas.core.util.Result
import org.empresa.saas.data.model.UserDto
import org.empresa.saas.data.model.CompanyAccessDto

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Result<UserDto, String>
}

class AuthRemoteDataSourceImpl : AuthRemoteDataSource {
    override suspend fun login(email: String, password: String): Result<UserDto, String> {
        delay(1000) // Simular latencia de red de Firebase
        return if (email == "test@empresa.org" && password == "password") {
            Result.Success(
                UserDto(
                    id = "user-123",
                    email = "test@empresa.org",
                    displayName = "Test User",
                    name = "John Doe",
                    companyAccess = listOf(
                        CompanyAccessDto(
                            companyId = "comp-abc",
                            companyName = "Empresa ABC",
                            role = "TECHNICIAN"
                        )
                    ),
                    status = "ACTIVE"
                )
            )
        } else {
            Result.Error("Credenciales inválidas desde el 'backend'")
        }
    }
}
