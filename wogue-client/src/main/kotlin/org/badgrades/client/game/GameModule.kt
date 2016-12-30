package org.badgrades.client.game

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import org.badgrades.client.game.impl.ClientControllerImpl

class GameModule : AbstractModule() {
    
    override fun configure() {
        bind(ClientController::class.java).to(ClientControllerImpl::class.java).`in`(Singleton::class.java)
    }
    
}