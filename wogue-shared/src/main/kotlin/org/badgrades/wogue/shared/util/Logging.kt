package org.badgrades.wogue.shared.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KProperty

class LoggerDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        val loggerName = thisRef?.javaClass?.simpleName ?: "WogueLogger"
        return LoggerFactory.getLogger(loggerName)
    }
}