package org.badgrades.wogue.shared.network

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * All exchanges between the server and client are instances of this class
 */
class Message(
        @JsonProperty val event: Event,
        @JsonProperty val payload: Any
)