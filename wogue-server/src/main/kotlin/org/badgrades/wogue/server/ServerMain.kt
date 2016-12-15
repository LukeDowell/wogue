package org.badgrades.wogue.server

import com.google.inject.Guice

fun main(args: Array<String>) {
    Guice.createInjector(ServiceModule())
}