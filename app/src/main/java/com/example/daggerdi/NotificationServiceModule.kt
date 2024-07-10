package com.example.daggerdi

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule() {

    @Named("message")
    @Provides
    fun getMessageService(retryCount: Int) :NotificationService{
        return MessageService(retryCount)
    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService) :NotificationService{
        return emailService
    }
}