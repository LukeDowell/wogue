package org.badgrades.client.game

import com.google.inject.AbstractModule

class GameModule : AbstractModule() {
    
    override fun configure() {
        bind(ClientController::class.java).asEagerSingleton()
    }
    
}