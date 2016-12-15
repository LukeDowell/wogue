package org.badgrades.wogue.shared.network

import java.io.Serializable

/**
 * All exchanges between the server and client are instances of this class
 */
class Message(
        val event: Event,
        val payload: Any
) : Serializable