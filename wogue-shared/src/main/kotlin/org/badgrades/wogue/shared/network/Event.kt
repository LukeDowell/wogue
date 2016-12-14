package org.badgrades.wogue.shared.network

/**
 * Flag for describing what kind of payload a message contains
 */
enum class Event(val sign: Byte) {
    
    CHAT(0x00),
    
    PLAYER_MOVED(0x01),
    
    PLAYER_JOINED(0x02);
    
    companion object {
    
        /**
         * Finds an event with the same sign value
         */
        fun fromSign(sign: Byte) : Event? {
            return Event.values()
                    .filter { it.sign == sign }
                    .firstOrNull()
        }
    }
}