package org.badgrades.client

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import org.badgrades.client.network.WogueClient

class ClientModule : AbstractModule() {
    override fun configure() {
        bind(WogueClient::class.java).`in`(Singleton::class.java)
    }
}