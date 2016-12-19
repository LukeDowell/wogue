package org.badgrades.wogue.server.service

import com.google.inject.AbstractModule

class ServiceModule : AbstractModule() {
    override fun configure() {
        bind(PlayerService::class.java).asEagerSingleton()
        bind(RoomService::class.java).asEagerSingleton()
    }
}