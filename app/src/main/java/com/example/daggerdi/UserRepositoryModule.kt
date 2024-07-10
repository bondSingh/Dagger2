package com.example.daggerdi

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun getUserRepository(sqlRepository: SQLRepository): UserRepository

}