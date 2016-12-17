package org.badgrades.client

import com.google.inject.Guice

class ClientMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Guice.createInjector(ClientModule())
        }
    }
}