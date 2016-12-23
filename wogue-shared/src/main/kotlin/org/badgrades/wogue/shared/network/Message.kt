package org.badgrades.wogue.shared.network

import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * All exchanges between the server and client are instances of this class
 */
class Message(
        val event: Event,
        
        @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="class")
        val payload: Any
)