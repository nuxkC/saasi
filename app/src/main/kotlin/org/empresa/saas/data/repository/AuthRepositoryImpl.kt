package org.empresa.saas.data.repository

import org.empresa.saas.core.util.Result
import org.empresa.saas.data.datasource.remote.impl.AuthRemoteDataSource
import org.empresa.saas.data.mapper.toDomain
import org.empresa.saas.domain.model.User
import org.empresa.saas.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<User, String> {
        return when (val result = authRemoteDataSource.login(email, password)) {
            is Result.Success -> Result.Success(result.data.toDomain())
            is Result.Error -> Result.Error(result.error)
        }
    }
}
