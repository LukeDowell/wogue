package org.badgrades.wogue.shared.network

/**
 * Flag for describing what kind of payload a message contains
 */
enum class Event {
    
    ALL, // Special event indicating that a listener would be interested in all events
    
    CHAT_MESSAGE,
    
    PLAYER_MOVED,
    PLAYER_JOINED,

    LOGIN_REQUEST,
    LOGIN_ACCEPTED,
    LOGIN_DENIED,

    ACTION_NOT_ALLOWED //
}