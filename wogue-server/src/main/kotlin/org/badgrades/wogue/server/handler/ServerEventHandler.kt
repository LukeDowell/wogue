package org.badgrades.wogue.server.handler

import org.badgrades.wogue.server.network.event.EventObserver
import org.badgrades.wogue.shared.network.Message

/**
 * Controllers for various kinds of events. Should these be singletons?
 */
abstract class ServerEventHandler : EventObserver