package com.example.daggerdi

import dagger.BindsInstance
import dagger.Component

@Component(modules = [NotificationServiceModule::class, UserRepositoryModule::class])
interface UserRegistrationComponent {


    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent
    }
}