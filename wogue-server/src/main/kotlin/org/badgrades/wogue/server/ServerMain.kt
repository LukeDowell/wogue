package org.badgrades.wogue.server

import com.google.inject.Guice

class ServerMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Guice.createInjector(ServerModule())
        }
    }
}