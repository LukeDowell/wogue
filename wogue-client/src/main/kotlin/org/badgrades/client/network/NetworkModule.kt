package org.badgrades.client.network

import com.google.inject.AbstractModule
import com.google.inject.Singleton

class NetworkModule : AbstractModule() {
    override fun configure() {
        bind(NetworkService::class.java).`in`(Singleton::class.java)
        bind(WogueClient::class.java).`in`(Singleton::class.java)
    }
}