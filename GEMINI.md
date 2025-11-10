# Guía de Desarrollo de Aplicación Android SAAS (Noviembre 2025)

Este documento es la guía maestra y la fuente única de verdad para el desarrollo de la aplicación móvil SAAS para Android. Describe la arquitectura, la estructura del proyecto y las tecnologías a utilizar, siguiendo las directrices recomendadas por Google para aplicaciones nativas con Jetpack Compose.

---

## 1. Estructura de Archivos del Proyecto

El siguiente árbol de archivos representa la estructura completa del proyecto. Está basado en una arquitectura limpia y modular, optimizada para escalabilidad y mantenimiento dentro de un entorno Android nativo.

```
.
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── README.md
├── settings.gradle.kts
|
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
|
└── app/
    ├── build.gradle.kts
    └── src/
        └── main/
            ├── AndroidManifest.xml
            ├── kotlin/
            │   └── org/
            │       └── empresa/
            │           └── saas/
            │               ├── SaasApplication.kt
            │               ├── MainActivity.kt
            │               |
            │               ├── core/
            │               │   ├── util/
            │               │   │   ├── Result.kt
            │               │   │   └── ResourceManager.kt
            │               │   └── di/
            │               │       ├── AppModule.kt
            │               │       ├── DataModule.kt
            │               │       └── DomainModule.kt
            │               |
            │               ├── data/
            │               │   ├── datasource/
            │               │   │   ├── remote/
            │               │   │   │   ├── api/
            │               │   │   │   │   ├── AuthApi.kt
            │               │   │   │   │   ├── BreakdownApi.kt
            │               │   │   │   │   ├── CollectionApi.kt
            │               │   │   │   │   ├── InstallationApi.kt
            │               │   │   │   │   ├── LicenseApi.kt
            │               │   │   │   │   ├── LoanApi.kt
            │               │   │   │   │   ├── LocationApi.kt
            │               │   │   │   │   └── MachineApi.kt
            │               │   │   │   └── impl/
            │               │   │   │       ├── AuthRemoteDataSourceImpl.kt
            │               │   │   │       ├── BreakdownRemoteDataSourceImpl.kt
            │               │   │   │       ├── CollectionRemoteDataSourceImpl.kt
            │               │   │   │       ├── InstallationRemoteDataSourceImpl.kt
            │               │   │   │       ├── LicenseRemoteDataSourceImpl.kt
            │               │   │   │       ├── LoanRemoteDataSourceImpl.kt
            │               │   │   │       ├── LocationRemoteDataSourceImpl.kt
            │               │   │   │       └── MachineRemoteDataSourceImpl.kt
            │               │   │   └── local/
            │               │   │       ├── dao/
            │               │   │       │   ├── BreakdownDao.kt
            │               │   │       │   ├── CollectionDao.kt
            │               │   │       │   ├── InstallationDao.kt
            │               │   │       │   ├── LicenseDao.kt
            │               │   │       │   ├── LoanDao.kt
            │               │   │       │   ├── LocationDao.kt
            │               │   │       │   ├── MachineDao.kt
            │               │   │       │   └── UserDao.kt
            │               │   │       └── AppDatabase.kt
            │               │   ├── mapper/
            │               │   │   ├── BreakdownMapper.kt
            │               │   │   ├── CollectionMapper.kt
            │               │   │   ├── InstallationMapper.kt
            │               │   │   ├── LicenseMapper.kt
            │               │   │   ├── LoanMapper.kt
            │               │   │   ├── LocationMapper.kt
            │               │   │   ├── MachineMapper.kt
            │               │   │   └── UserMapper.kt
            │               │   ├── model/
            │               │   │   ├── BreakdownDto.kt
            │               │   │   ├── CollectionDto.kt
            │               │   │   ├── CompanyDto.kt
            │               │   │   ├── InstallationDto.kt
            │               │   │   ├── LicenseDto.kt
            │               │   │   ├── LoanDto.kt
            │               │   │   ├── LocationDto.kt
            │               │   │   ├── MachineDto.kt
            │               │   │   └── UserDto.kt
            │               │   └── repository/
            │               │       ├── AuthRepositoryImpl.kt
            │               │       ├── BreakdownRepositoryImpl.kt
            │               │       ├── CollectionRepositoryImpl.kt
            │               │       ├── InstallationRepositoryImpl.kt
            │               │       ├── LicenseRepositoryImpl.kt
            │               │       ├── LoanRepositoryImpl.kt
            │               │       ├── LocationRepositoryImpl.kt
            │               │       └── MachineRepositoryImpl.kt
            │               |
            │               ├── domain/
            │               │   ├── model/
            │               │   │   ├── AuditLog.kt
            │               │   │   ├── Breakdown.kt
            │               │   │   ├── Collection.kt
            │               │   │   ├── Company.kt
            │               │   │   ├── Installation.kt
            │               │   │   ├── License.kt
            │               │   │   ├── Loan.kt
            │               │   │   ├── Location.kt
            │               │   │   ├── Machine.kt
            │               │   │   ├── Shared.kt
            │               │   │   └── User.kt
            │               │   ├── repository/
            │               │   │   ├── AuthRepository.kt
            │               │   │   ├── BreakdownRepository.kt
            │               │   │   ├── CollectionRepository.kt
            │               │   │   ├── InstallationRepository.kt
            │               │   │   ├── LicenseRepository.kt
            │               │   │   ├── LoanRepository.kt
            │               │   │   ├── LocationRepository.kt
            │               │   │   └── MachineRepository.kt
            │               │   ├── usecase/
            │               │   │   ├── auth/
            │               │   │   │   ├── GetCurrentUserUseCase.kt
            │               │   │   │   ├── GetUsersUseCase.kt
            │               │   │   │   ├── InviteUserUseCase.kt
            │               │   │   │   ├── LoginUseCase.kt
            │               │   │   │   └── LogoutUseCase.kt
            │               │   │   ├── breakdown/
            │               │   │   │   ├── GetActiveBreakdownsUseCase.kt
            │               │   │   │   ├── GetBreakdownsForMachineUseCase.kt
            │               │   │   │   ├── ReportBreakdownUseCase.kt
            │               │   │   │   └── ResolveBreakdownUseCase.kt
            │               │   │   ├── collection/
            │               │   │   │   ├── GetCollectionsUseCase.kt
            │               │   │   │   ├── ReverseCollectionUseCase.kt
            │               │   │   │   └── SubmitCollectionUseCase.kt
            │               │   │   ├── installation/
            │               │   │   │   ├── CreateInstallationUseCase.kt
            │               │   │   │   └── GetInstallationsUseCase.kt
            │               │   │   ├── license/
            │               │   │   │   ├── CreateLicenseUseCase.kt
            │               │   │   │   └── GetLicensesUseCase.kt
            │               │   │   ├── loan/
            │               │   │   │   ├── CreateLoanUseCase.kt
            │               │   │   │   └── GetLoansForLocationUseCase.kt
            │               │   │   ├── location/
            │               │   │   │   ├── CreateLocationUseCase.kt
            │               │   │   │   ├── GetLocationDetailsUseCase.kt
            │               │   │   │   └── GetLocationsUseCase.kt
            │               │   │   └── machine/
            │               │   │       ├── AcquireCollectionLockUseCase.kt
            │               │   │       ├── CreateMachineUseCase.kt
            │               │   │       ├── GetMachineDetailsUseCase.kt
            │               │   │       ├── GetMachinesUseCase.kt
            │               │   │       └── ReleaseCollectionLockUseCase.kt
            │               │   └── validation/
            │               │       ├── BreakdownValidator.kt
            │               │       ├── CollectionValidator.kt
            │               │       ├── InstallationValidator.kt
            │               │       ├── LicenseValidator.kt
            │               │       ├── LoanValidator.kt
            │               │       ├── LocationValidator.kt
            │               │       ├── MachineValidator.kt
            │               │       ├── UserValidator.kt
            │               │       └── ValidationConstants.kt
            │               |
            │               └── presentation/
            │                   ├── navigation/
            │                   │   ├── AppNavigation.kt
            │                   │   └── Screen.kt
            │                   ├── theme/
            │                   │   ├── Color.kt
            │                   │   ├── Shape.kt
            │                   │   ├── Theme.kt
            │                   │   └── Typography.kt
            │                   ├── components/
            │                   │   ├── LoadingSpinner.kt
            │                   │   ├── ErrorMessage.kt
            │                   │   └── PageTitle.kt
            │                   ├── feature_auth/
            │                   │   ├── LoginScreen.kt
            │                   │   └── LoginViewModel.kt
            │                   ├── feature_dashboard/
            │                   │   ├── DashboardScreen.kt
            │                   │   └── DashboardViewModel.kt
            │                   ├── feature_machines/
            │                   │   ├── list/
            │                   │   │   ├── MachineListScreen.kt
            │                   │   │   └── MachineListViewModel.kt
            │                   │   └── detail/
            │                   │       ├── MachineDetailScreen.kt
            │                   │       └── MachineDetailViewModel.kt
            │                   ├── feature_locations/
            │                   │   ├── list/
            │                   │   │   ├── LocationListScreen.kt
            │                   │   │   └── LocationListViewModel.kt
            │                   │   └── detail/
            │                   │       ├── LocationDetailScreen.kt
            │                   │       └── LocationDetailViewModel.kt
            │                   └── feature_collections/
            │                       ├── select/
            │                       │   ├── SelectMachineForCollectionScreen.kt
            │                       │   └── SelectMachineViewModel.kt
            │                       └── collect/
            │                           ├── CollectionScreen.kt
            │                           └── CollectionViewModel.kt
            │
            └── res/
                ├── drawable/
                ├── mipmap-anydpi-v26/
                ├── mipmap-hdpi/
                ├── mipmap-mdpi/
                ├── mipmap-xhdpi/
                ├── mipmap-xxhdpi/
                ├── mipmap-xxxhdpi/
                └── values/
                    ├── colors.xml
                    ├── strings.xml
                    └── themes.xml
```

---

## 2. Arquitectura Detallada y Plan de Desarrollo

### 2.1. Resumen y Filosofía Arquitectónica

La arquitectura sigue las directrices oficiales de Google para aplicaciones Android, basadas en los principios de **Clean Architecture**. El código se separa en tres capas principales dentro del paquete `org.empresa.saas`:

1.  **Domain:** Contiene la lógica de negocio, los modelos de datos principales y las interfaces de los repositorios. Es una capa de Kotlin puro, independiente del framework de Android.
2.  **Data:** Gestiona el origen de los datos (API remota, base de datos local) e implementa las interfaces de repositorio definidas en la capa de dominio.
3.  **Presentation:** La interfaz de usuario (UI) y la lógica de presentación. Utiliza el patrón **Model-View-ViewModel (MVVM)** con Jetpack Compose.

El objetivo es crear un código base **robusto, escalable, testeable y mantenible**, con un enfoque claro en la **fiabilidad offline** para las operaciones de campo.

### 2.2. Tecnologías y Dependencias

*   **Lenguaje y Plataforma:**
    *   **Kotlin:** Lenguaje de programación principal. Versión recomendada: 2.1.20.
    *   **Jetpack Compose:** Framework de UI declarativo nativo para Android.
*   **Arquitectura y Navegación:**
    *   **MVVM (Model-View-ViewModel):** Patrón de presentación.
    *   **androidx.lifecycle.ViewModel:** Componente de arquitectura para la lógica de UI y el estado.
    *   **androidx.navigation:navigation-compose:** Librería oficial para la navegación declarativa en Compose.
*   **Red y Datos:**
    *   **Ktor:** Cliente HTTP para comunicarse con las Firebase Functions.
    *   **Kotlinx Serialization:** Para serializar/deserializar JSON.
    *   **Firebase SDK for Android:** Para autenticación (Firebase Auth) y base de datos en la nube (Firestore).
    *   **Room:** Librería de persistencia para implementar la caché local en una base de datos SQLite.
*   **Inyección de Dependencias (DI):**
    *   **Koin:** Framework de DI ligero para Kotlin.
*   **Asincronía:**
    *   **Kotlin Coroutines & Flow:** Para gestionar operaciones asíncronas y flujos de datos reactivos.
*   **Validación:**
    *   **Akkurate:** Librería de validación declarativa para Kotlin, con un DSL expresivo y ligero.

### 2.3. Modelo de Datos Detallado (Kotlin)

Esta sección es la **fuente de la verdad** para los modelos de datos de la app, basada en los esquemas definidos en el backend.

#### 2.3.1. Tipos Base y Enums (`domain/model/Shared.kt`)

```kotlin
// domain/model/Shared.kt

import kotlinx.datetime.Instant

// Branded IDs para type safety
typealias UserId = String
typealias CompanyId = String
typealias LocationId = String
typealias MachineId = String
typealias BreakdownId = String
typealias LicenseId = String
typealias InstallationId = String
typealias CollectionId = String
typealias AuditLogId = String
typealias LoanId = String

// Enums basados en firestoreConstants.ts
enum class UserRole { ADMIN, TECHNICIAN, VIEWER, MANAGER, PENDING }
enum class UserStatus { ACTIVE, INACTIVE, PENDING }
enum class LocationStatus { ACTIVE, INACTIVE }
enum class MachineStatus { STORED, INSTALLED, NEED_REPAIR, RETIRED }
enum class LicenseStatus { ASSIGNED, AVAILABLE, INACTIVE, EXPIRED }
enum class InstallationStatus { ACTIVE, REMOVED }
enum class LoanStatus { ACTIVE, PAID, CANCELLED }
enum class BreakdownStatus { REPORTED, ASSIGNED, IN_PROGRESS, RESOLVED, CLOSED, CANNOT_REPRODUCE }
enum class BreakdownPriority { HIGH, MEDIUM, LOW }
enum class CollectionStatus { COMPLETED, REVERSED }
enum class AuditEventType { 
    USER_ACCESS_GRANTED, USER_ACCESS_REVOKED, USER_CREATED, USER_DELETED, USER_STATUS_UPDATED, USER_ROLE_UPDATED,
    COMPANY_CREATED, LOCATION_CREATED, LOCATION_UPDATED, LOCATION_STATUS_UPDATED, MACHINE_CREATED, MACHINE_UPDATED,
    MACHINE_RETIRED, MACHINE_STATUS_UPDATED, MACHINE_COUNTERS_UPDATED, MACHINE_COLLECTION_LOCK_ACQUIRED,
    MACHINE_COLLECTION_LOCK_RELEASED, BREAKDOWN_REPORTED, BREAKDOWN_STATUS_UPDATED, BREAKDOWN_RESOLVED,
    LICENSE_CREATED, LICENSE_UPDATED, LICENSE_STATUS_UPDATED, INSTALLATION_CREATED, INSTALLATION_REMOVED,
    COLLECTION_CREATED, COLLECTION_REVERSED, HOPPER_DEBT_ADJUSTED, HOPPER_DEBT_REVERSED, LOAN_CREATED,
    LOAN_UPDATED, LOAN_CANCELLED, LOAN_PAYMENT_APPLIED, LOAN_STATUS_UPDATED, LOAN_PAYMENT_REVERSED,
    SYSTEM_MAINTENANCE 
}
enum class AuditEntity { USER, COMPANY, LOCATION, MACHINE, BREAKDOWN, LICENSE, INSTALLATION, COLLECTION, LOAN, SYSTEM, NONE }
```

#### 2.3.2. Modelos por Entidad

##### UserProfile
*   **DTO (`data/model/UserDto.kt`)**:
    ```kotlin
    @Serializable
    data class UserProfileDto(val id: UserId, val email: String, val displayName: String, val name: String, val companyAccess: List<CompanyAccessDto>, val status: String)
    @Serializable
    data class CompanyAccessDto(val companyId: CompanyId, val companyName: String, val role: String)
    ```
*   **Dominio (`domain/model/User.kt`)**:
    ```kotlin
    data class User(val id: UserId, val email: String, val displayName: String, val name: String, val companyAccess: List<CompanyAccess>, val status: UserStatus)
    data class CompanyAccess(val companyId: CompanyId, val companyName: String, val role: UserRole)
    ```

##### Machine
*   **DTO (`data/model/MachineDto.kt`)**:
    ```kotlin
    @Serializable
    data class MachineDto(val id: MachineId, val serialNumber: String, val model: String, val manufacturer: String, val status: String, val lastEntryCounter: Long, val lastExitCounter: Long, val lastCollectionDate: Long? = null, val collectionLock: CollectionLockDto? = null)
    @Serializable
    data class CollectionLockDto(val technicianId: UserId, val lockedAt: Long)
    ```
*   **Dominio (`domain/model/Machine.kt`)**:
    ```kotlin
    data class Machine(val id: MachineId, val serialNumber: String, val model: String, val status: MachineStatus, val lastEntryCounter: Long, val lastExitCounter: Long, val isLocked: Boolean)
    ```

##### Breakdown
*   **DTO (`data/model/BreakdownDto.kt`)**:
    ```kotlin
    @Serializable
    data class BreakdownDto(
        val id: BreakdownId, 
        val machineId: MachineId, 
        val reportedAt: Long, 
        val reportedByUserId: UserId, 
        val locationId: LocationId,
        val installationId: InstallationId,
        val description: String, 
        val status: String, 
        val assignedTechnicianId: UserId? = null,
        val priority: String, 
        val resolutionNotes: String? = null,
        val resolvedAt: Long? = null,
        val updatedByUserId: UserId? = null
    )
    ```
*   **Dominio (`domain/model/Breakdown.kt`)**:
    ```kotlin
    data class Breakdown(
        val id: BreakdownId, 
        val machineId: MachineId, 
        val locationId: LocationId,
        val reportedAt: Instant, 
        val description: String, 
        val status: BreakdownStatus, 
        val priority: BreakdownPriority,
        val assignedTechnicianId: UserId? = null
    )
    ```

##### Location
*   **DTO (`data/model/LocationDto.kt`)**:
    ```kotlin
    @Serializable
    data class CreateLocationDto(val name: String, val address: String, val cif: String, val contactPerson: String, val revenueSharePercentage: Double, val maxMachines: Int)
    @Serializable
    data class UpdateLocationDto(val name: String, val address: String, val cif: String, val contactPerson: String, val revenueSharePercentage: Double, val maxMachines: Int)
    ```
*   **Dominio (`domain/model/Location.kt`)**:
    ```kotlin
    data class Location(val id: LocationId, val name: String, val address: String, val cif: String, val contactPerson: String, val revenueSharePercentage: Double, val maxMachines: Int, val activeMachineCount: Int, val status: LocationStatus)
    ```

##### License
*   **DTO (`data/model/LicenseDto.kt`)**:
    ```kotlin
    @Serializable
    data class CreateLicenseDto(val licenseNumber: String, val validUntil: Long)
    ```
*   **Dominio (`domain/model/License.kt`)**:
    ```kotlin
    data class License(val id: LicenseId, val licenseNumber: String, val validUntil: Instant, val status: LicenseStatus)
    ```

##### Installation
*   **DTO (`data/model/InstallationDto.kt`)**:
    ```kotlin
    @Serializable
    data class CreateInstallationDto(val locationId: LocationId, val machineId: MachineId, val licenseId: LicenseId, val hopperDebt: Double?, val weeklyFee: Double)
    ```
*   **Dominio (`domain/model/Installation.kt`)**:
    ```kotlin
    data class Installation(val id: InstallationId, val locationId: LocationId, val machineId: MachineId, val licenseId: LicenseId, val installationDate: Instant, val hopperDebt: Double, val weeklyFee: Double, val removalDate: Instant?, val status: InstallationStatus)
    ```

##### Collection
*   **DTO (`data/model/CollectionDto.kt`)**:
    ```kotlin
    @Serializable
    data class CreateCollectionInputDto(val installationId: InstallationId, val machineId: MachineId, val locationId: LocationId, val entryCounterActual: Int, val exitCounterActual: Int, val extractionDenominations: Map<String, Int>?, val hopperDebtPaymentApplied: Double?, val loanPaymentsApplied: List<LoanPaymentDto>?, val notes: String?)
    @Serializable
    data class LoanPaymentDto(val loanId: LoanId, val amount: Double)
    ```
*   **Dominio (`domain/model/Collection.kt`)**:
    ```kotlin
    data class Collection(val id: CollectionId, val machineId: MachineId, val locationId: LocationId, val userId: UserId, val collectionDate: Instant, val grossRevenueEuros: Double, val companyShareAmount: Double, val finalClientPayout: Double, val status: CollectionStatus)
    ```

##### Loan
*   **DTO (`data/model/LoanDto.kt`)**:
    ```kotlin
    @Serializable
    data class CreateLoanDto(val locationId: LocationId, val loanAmount: Double, val description: String)
    ```
*   **Dominio (`domain/model/Loan.kt`)**:
    ```kotlin
    data class Loan(val id: LoanId, val locationId: LocationId, val loanAmount: Double, val remainingBalance: Double, val loanDate: Instant, val description: String?, val status: LoanStatus)
    ```

##### CompanyInfo
*   **Dominio (`domain/model/Company.kt`)**:
    ```kotlin
    data class CompanyInfo(val name: String, val cif: String, val address: String)
    ```

### 2.4. API (Data Source) y Casos de Uso

#### 2.4.1. Contrato de la API Remota (`data/datasource/remote/api/`)

```kotlin
// AuthApi.kt
interface AuthApi {
    // Login y Logout son manejados por la librería de Firebase Auth
    suspend fun inviteUser(companyId: CompanyId, email: String, role: UserRole): Result<Unit>
    suspend fun updateUserRole(companyId: CompanyId, userId: UserId, newRole: UserRole): Result<Unit>
    suspend fun getUsers(companyId: CompanyId, role: UserRole?): List<UserProfileDto>
}

// MachineApi.kt
interface MachineApi {
    suspend fun getMachines(companyId: CompanyId): List<MachineDto>
    suspend fun getMachineById(companyId: CompanyId, machineId: MachineId): MachineDto
    suspend fun createMachine(companyId: CompanyId, machine: MachineDto): MachineDto
    suspend fun updateMachine(companyId: CompanyId, machineId: MachineId, machine: MachineDto): MachineDto
    suspend fun retireMachine(companyId: CompanyId, machineId: MachineId): Result<Unit>
    suspend fun acquireCollectionLock(companyId: CompanyId, machineId: MachineId): Result<Unit>
    suspend fun releaseCollectionLock(companyId: CompanyId, machineId: MachineId): Result<Unit>
}

// BreakdownApi.kt
interface BreakdownApi {
    suspend fun reportBreakdown(companyId: CompanyId, breakdown: BreakdownDto): BreakdownDto
    suspend fun resolveBreakdown(companyId: CompanyId, breakdownId: BreakdownId, notes: String): Result<Unit>
    suspend fun getBreakdownsForMachine(companyId: CompanyId, machineId: MachineId): List<BreakdownDto>
    suspend fun getBreakdowns(companyId: CompanyId): List<BreakdownDto>
}

// CollectionApi.kt
interface CollectionApi {
    suspend fun saveAndValidateCollection(companyId: CompanyId, collectionData: CreateCollectionInputDto): Result<Unit>
    suspend fun reverseCollection(companyId: CompanyId, collectionId: CollectionId, reason: String): Result<Unit>
    suspend fun getCollections(companyId: CompanyId, machineId: MachineId?): List<CollectionDto>
}

// LocationApi.kt
interface LocationApi {
    suspend fun createLocation(companyId: CompanyId, location: CreateLocationDto): LocationDto
    suspend fun updateLocation(companyId: CompanyId, locationId: LocationId, location: UpdateLocationDto): LocationDto
    suspend fun getLocations(companyId: CompanyId): List<LocationDto>
    suspend fun getLocationById(companyId: CompanyId, locationId: LocationId): LocationDto
}

// LicenseApi.kt
interface LicenseApi {
    suspend fun createLicense(companyId: CompanyId, license: CreateLicenseDto): LicenseDto
    suspend fun updateLicense(companyId: CompanyId, licenseId: LicenseId, license: CreateLicenseDto): LicenseDto
    suspend fun getLicenses(companyId: CompanyId): List<LicenseDto>
}

// InstallationApi.kt
interface InstallationApi {
    suspend fun createInstallation(companyId: CompanyId, installation: CreateInstallationDto): InstallationDto
    suspend fun removeInstallation(companyId: CompanyId, installationId: InstallationId): Result<Unit>
    suspend fun getInstallations(companyId: CompanyId): List<InstallationDto>
}

// LoanApi.kt
interface LoanApi {
    suspend fun createLoan(companyId: CompanyId, loan: CreateLoanDto): LoanDto
    suspend fun applyLoanPayment(companyId: CompanyId, loanId: LoanId, amount: Double): Result<Unit>
    suspend fun getLoans(companyId: CompanyId, locationId: LocationId?): List<LoanDto>
}
```

#### 2.4.2. Casos de Uso (`domain/usecase/`)

Los casos de uso encapsulan una única acción de negocio.

*   **`auth/`**: `LoginUseCase`, `LogoutUseCase`, `GetCurrentUserUseCase`, `InviteUserUseCase`, `GetUsersUseCase`.
*   **`machine/`**: `GetMachinesUseCase`, `GetMachineDetailsUseCase`, `AcquireCollectionLockUseCase`, `ReleaseCollectionLockUseCase`, `CreateMachineUseCase`.
*   **`breakdown/`**: `ReportBreakdownUseCase`, `ResolveBreakdownUseCase`, `GetBreakdownsForMachineUseCase`, `GetActiveBreakdownsUseCase`.
*   **`collection/`**: `SubmitCollectionUseCase`, `GetCollectionsUseCase`, `ReverseCollectionUseCase`.
*   **`location/`**: `GetLocationsUseCase`, `CreateLocationUseCase`, `GetLocationDetailsUseCase`.
*   **`license/`**: `GetLicensesUseCase`, `CreateLicenseUseCase`.
*   **`installation/`**: `GetInstallationsUseCase`, `CreateInstallationUseCase`.
*   **`loan/`**: `CreateLoanUseCase`, `GetLoansForLocationUseCase`.

**Ejemplo de implementación:**
```kotlin
// domain/usecase/machine/AcquireCollectionLockUseCase.kt
class AcquireCollectionLockUseCase(private val machineRepository: MachineRepository) {
    suspend operator fun invoke(companyId: CompanyId, machineId: MachineId): Result<Unit> {
        return machineRepository.acquireCollectionLock(companyId, machineId)
    }
}
```

### 2.5. Estrategia de Validación (Completa)

La validación de datos de entrada en el cliente es crucial para proporcionar feedback instantáneo al usuario y para reducir la carga en el backend. Se utiliza **Akkurate** para un DSL más expresivo y Kotlin-nativo.

#### 2.5.1. Replicación de Constantes de Validación

```kotlin
// domain/validation/ValidationConstants.kt

object ValidationRules {
    // === USER & AUTHENTICATION ===
    const val EMAIL_MIN_LENGTH = 5
    const val PASSWORD_MIN_LENGTH = 8
    const val PASSWORD_MIN_LENGTH_LEGACY = 6
    const val DISPLAY_NAME_MIN_LENGTH = 2
    const val DISPLAY_NAME_MAX_LENGTH = 100
    const val FULL_NAME_MIN_LENGTH = 2
    const val FULL_NAME_MAX_LENGTH = 150

    // === COMPANY ===
    const val COMPANY_NAME_MIN_LENGTH = 2
    const val COMPANY_NAME_MAX_LENGTH = 200

    // === LOCATION ===
    const val NAME_MIN_LENGTH = 2
    const val NAME_MAX_LENGTH = 200
    const val ADDRESS_MIN_LENGTH = 5
    const val ADDRESS_MAX_LENGTH = 300
    const val CIF_LENGTH = 9
    const val CONTACT_PERSON_MIN_LENGTH = 2
    const val CONTACT_PERSON_MAX_LENGTH = 150
    const val REVENUE_SHARE_MIN = 0.0
    const val REVENUE_SHARE_MAX = 100.0
    const val WEEKLY_FEE_MIN = 0.0
    const val MAX_MACHINES_MIN = 0
    const val HOPPER_DEBT_MIN = 0.0

    // === MACHINE ===
    const val SERIAL_NUMBER_MIN_LENGTH = 1
    const val SERIAL_NUMBER_MAX_LENGTH = 50
    const val MODEL_MIN_LENGTH = 1
    const val MODEL_MAX_LENGTH = 100
    const val MANUFACTURER_MIN_LENGTH = 1
    const val MANUFACTURER_MAX_LENGTH = 100
    const val COUNTER_MIN = 0
    const val COUNTER_MAX = 999999999

    // === LICENSE ===
    const val LICENSE_NUMBER_MIN_LENGTH = 3
    const val LICENSE_NUMBER_MAX_LENGTH = 50

    // === BREAKDOWN ===
    const val DESCRIPTION_MIN_LENGTH = 10
    const val DESCRIPTION_MAX_LENGTH = 500
    const val RESOLUTION_NOTES_MIN_LENGTH = 10
    const val RESOLUTION_NOTES_MAX_LENGTH = 1000

    // === LOAN ===
    const val LOAN_AMOUNT_MIN = 0.01
    const val LOAN_AMOUNT_MAX = 999999.99
    const val REMAINING_BALANCE_MIN = 0.0
    const val LOAN_DESCRIPTION_MAX_LENGTH = 500

    // === COLLECTION ===
    const val NOTES_MAX_LENGTH = 500
    const val HOPPER_DEBT_PAYMENT_MIN = 0.0
    const val LOAN_PAYMENT_MIN = 0.01
}

object ValidationPatterns {
    val CIF_REGEX = Regex("^[A-Z]\\d{8}$")
    val SERIAL_NUMBER_REGEX = Regex("^[A-Z0-9-]+$", RegexOption.IGNORE_CASE)
    val LICENSE_NUMBER_REGEX = Regex("^[A-Z0-9-/]+$", RegexOption.IGNORE_CASE)
}
```

#### 2.5.2. Implementación con Akkurate (Completa)

```kotlin
// domain/validation/UserValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.InviteUserDto // Asumiendo un DTO para la invitación

val validateInviteUser = Validator<InviteUserDto> {
    InviteUserDto::email {
        matches(Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) { "El formato del email no es válido." }
    }
}
```
```kotlin
// domain/validation/LocationValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateLocationDto

val validateCreateLocation = Validator<CreateLocationDto> {
    CreateLocationDto::name {
        length { min(ValidationRules.NAME_MIN_LENGTH) }
        length { max(ValidationRules.NAME_MAX_LENGTH) }
    }
    CreateLocationDto::address {
        length { min(ValidationRules.ADDRESS_MIN_LENGTH) }
        length { max(ValidationRules.ADDRESS_MAX_LENGTH) }
    }
    CreateLocationDto::cif {
        length { eq(ValidationRules.CIF_LENGTH) }
        matches(ValidationPatterns.CIF_REGEX) { "El formato del CIF no es válido (e.g., A12345678)." }
    }
    CreateLocationDto::contactPerson {
        length { min(ValidationRules.CONTACT_PERSON_MIN_LENGTH) }
        length { max(ValidationRules.CONTACT_PERSON_MAX_LENGTH) }
    }
    CreateLocationDto::revenueSharePercentage {
        greaterThanOrEqualTo(ValidationRules.REVENUE_SHARE_MIN)
        lessThanOrEqualTo(ValidationRules.REVENUE_SHARE_MAX)
    }
    CreateLocationDto::maxMachines {
        greaterThanOrEqualTo(ValidationRules.MAX_MACHINES_MIN)
    }
}
```
```kotlin
// domain/validation/MachineValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateMachineDto

val validateNewMachine = Validator<CreateMachineDto> {
    CreateMachineDto::serialNumber {
        length { min(ValidationRules.SERIAL_NUMBER_MIN_LENGTH) } { "El número de serie es obligatorio." }
        length { max(ValidationRules.SERIAL_NUMBER_MAX_LENGTH) } { "El número de serie es demasiado largo." }
        matches(ValidationPatterns.SERIAL_NUMBER_REGEX) { "El número de serie contiene caracteres no válidos." }
    }
    CreateMachineDto::model {
        length { min(ValidationRules.MODEL_MIN_LENGTH) } { "El modelo es obligatorio." }
        length { max(ValidationRules.MODEL_MAX_LENGTH) } { "El nombre del modelo es demasiado largo." }
    }
    CreateMachineDto::manufacturer {
        length { min(ValidationRules.MANUFACTURER_MIN_LENGTH) } { "El fabricante es obligatorio." }
        length { max(ValidationRules.MANUFACTURER_MAX_LENGTH) } { "El nombre del fabricante es demasiado largo." }
    }
}
```
```kotlin
// domain/validation/LicenseValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateLicenseDto

val validateCreateLicense = Validator<CreateLicenseDto> {
    CreateLicenseDto::licenseNumber {
        length { min(ValidationRules.LICENSE_NUMBER_MIN_LENGTH) }
        length { max(ValidationRules.LICENSE_NUMBER_MAX_LENGTH) }
        matches(ValidationPatterns.LICENSE_NUMBER_REGEX) { "El número de licencia contiene caracteres no válidos." }
    }
}
```
```kotlin
// domain/validation/InstallationValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateInstallationDto

val validateCreateInstallation = Validator<CreateInstallationDto> {
    CreateInstallationDto::locationId {
        length { min(1) } { "Debe seleccionar un local." }
    }
    CreateInstallationDto::machineId {
        length { min(1) } { "Debe seleccionar una máquina." }
    }
    CreateInstallationDto::licenseId {
        length { min(1) } { "Debe seleccionar una licencia." }
    }
    CreateInstallationDto::weeklyFee {
        greaterThanOrEqualTo(ValidationRules.WEEKLY_FEE_MIN)
    }
}
```
```kotlin
// domain/validation/BreakdownValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.ReportBreakdownDto // DTO específico para el reporte

val validateBreakdownReport = Validator<ReportBreakdownDto> {
    ReportBreakdownDto::description {
        length { min(ValidationRules.DESCRIPTION_MIN_LENGTH) } { "La descripción debe tener al menos ${ValidationRules.DESCRIPTION_MIN_LENGTH} caracteres." }
        length { max(ValidationRules.DESCRIPTION_MAX_LENGTH) } { "La descripción no puede exceder los ${ValidationRules.DESCRIPTION_MAX_LENGTH} caracteres." }
    }
}
```
```kotlin
// domain/validation/LoanValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateLoanDto

val validateCreateLoan = Validator<CreateLoanDto> {
    CreateLoanDto::locationId {
        length { min(1) } { "Debe seleccionar un local." }
    }
    CreateLoanDto::loanAmount {
        greaterThanOrEqualTo(ValidationRules.LOAN_AMOUNT_MIN)
        lessThanOrEqualTo(ValidationRules.LOAN_AMOUNT_MAX)
    }
    CreateLoanDto::description {
        length { max(ValidationRules.LOAN_DESCRIPTION_MAX_LENGTH) }
    }
}
```
```kotlin
// domain/validation/CollectionValidator.kt
import dev.nesk.akkurate.Validator
import com.empresa.saas.data.model.CreateCollectionInputDto

val validateCollectionInput = Validator<CreateCollectionInputDto> {
    CreateCollectionInputDto::entryCounterActual {
        greaterThanOrEqualTo(ValidationRules.COUNTER_MIN)
    }
    CreateCollectionInputDto::exitCounterActual {
        greaterThanOrEqualTo(ValidationRules.COUNTER_MIN)
    }
    CreateCollectionInputDto::notes ifNotNull {
        length { max(ValidationRules.NOTES_MAX_LENGTH) }
    }
}
```

#### 2.5.3. Uso en Casos de Uso

```kotlin
// domain/usecase/machine/CreateMachineUseCase.kt

class CreateMachineUseCase(
    private val machineRepository: MachineRepository
) {
    suspend operator fun invoke(companyId: CompanyId, machineData: CreateMachineDto): Result<Machine> {
        val validationResult = validateNewMachine(machineData)
        if (validationResult.isInvalid) {
            return Result.Error(ValidationException(validationResult.violations))
        }
        return machineRepository.createMachine(companyId, machineData)
    }
}
```

### 2.6. Features y Pantallas de la App

La app se centrará en las necesidades del `TECHNICIAN` y `MANAGER`. Los ViewModels usan `androidx.lifecycle.ViewModel` con `viewModelScope` para la asincronía. La navegación se maneja con `androidx.navigation:navigation-compose`.

*   **Feature: Autenticación**
    *   `LoginScreen`: Pantalla de inicio de sesión.
*   **Feature: Dashboard**
    *   `DashboardScreen`: Vista principal con KPIs rápidos.
*   **Feature: Máquinas (`machines`)**
    *   `MachineListScreen`: Lista de todas las máquinas con filtros.
    *   `MachineDetailScreen`: Detalles de una máquina (Info, Averías, Recaudaciones).
*   **Feature: Averías (`breakdowns`)**
    *   `BreakdownListScreen`: Lista de averías activas, priorizadas.
    *   `ReportBreakdownScreen`: Formulario para reportar una nueva avería.
    *   `ResolveBreakdownScreen`: Formulario para resolver una avería.
*   **Feature: Recaudaciones (`collections`)**
    *   `SelectMachineForCollectionScreen`: Pantalla para buscar y seleccionar una máquina.
    *   `CollectionScreen`: Pantalla para realizar la recaudación (bloqueo, contadores, desglose).
*   **Feature: Locales (`locations`)**
    *   `LocationListScreen`: Lista de locales.
    *   `LocationDetailScreen`: Detalles de un local y máquinas instaladas.

### 2.7. Estrategia de Offline-First

1.  **Caché con Room:** Se usará para almacenar una copia de los datos esenciales (máquinas, locales, averías pendientes). La configuración se realiza con entidades anotadas (`@Entity`) y DAOs con queries `suspend` o que devuelven `Flow`.
2.  **Cola de Acciones (Outbox Pattern):** Las acciones que modifican datos (reportar avería, crear recaudación) se guardarán en una tabla local. Un `WorkManager` o un servicio en segundo plano se encargará de sincronizarlas con el backend cuando haya conexión.

### 2.8. Flujo End-to-End: Realizar una Recaudación

1.  **Técnico en `SelectMachineForCollectionScreen`:** Busca y selecciona una máquina.
2.  **Navegación a `CollectionScreen`:** Se pasa el `machineId` como argumento en la ruta de `NavController`.
3.  **`CollectionViewModel.onStart()` (usando `viewModelScope`):**
    *   Muestra un overlay de "Bloqueando máquina...".
    *   Llama a `acquireCollectionLockUseCase(companyId, machineId)`.
    *   Si falla, muestra error. Si tiene éxito, carga los detalles de la máquina.
4.  **Técnico introduce datos:** Rellena contadores y desglose de monedas en la UI de Compose.
5.  **Técnico pulsa "Guardar":**
    *   `CollectionViewModel.onSave()` es llamado.
    *   Llama a `submitCollectionUseCase(collection)`.
6.  **`SubmitCollectionUseCase`:**
    *   Valida los datos con el validador de Akkurate.
    *   Si es válido, llama a `collectionRepository.submitCollection(collection)`.
7.  **`CollectionRepositoryImpl` (Offline):**
    *   Guarda la recaudación en la tabla local de "acciones pendientes" usando Room.
    *   Devuelve `Result.Success` inmediatamente a la UI.
    *   El `WorkManager` se activa para intentar enviar la recaudación al backend.
8.  **`CollectionViewModel`:**
    *   Recibe `Result.Success`.
    *   Muestra un `Snackbar` o `Toast` de "Recaudación guardada y pendiente de sincronización".
    *   Navega a la pantalla anterior usando `navController.popBackStack()`.
9.  **Flujo de Cancelación:** Si el técnico cancela, el `ViewModel` llama a `releaseCollectionLockUseCase` para liberar el bloqueo en el backend.
