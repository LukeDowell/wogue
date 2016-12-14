package org.badgrades.wogue.shared.network

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled

/**
 * Utility functions related to messages
 */
class MessageUtil() {
    companion object {
        
        /**
         * Converts a message to a bytebuf
         */
        fun toByteBuf(message: Message): ByteBuf {
            
            return Unpooled.buffer()
        }
    
        /**
         * Converts a bytebuf to a message. Throws an exception
         * if the byte buf is not formatted correctly.
         */
        fun fromByteBuf(byteBuf: ByteBuf): Message? {
            
            val sign = byteBuf.readByte()
            val event = Event.fromSign(sign)
            
            return null
        }
    }
}