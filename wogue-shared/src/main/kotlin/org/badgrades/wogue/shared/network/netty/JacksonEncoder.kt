package org.badgrades.wogue.shared.network.netty

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class JacksonEncoder : MessageToByteEncoder<Message>() {
    
    val log by LoggerDelegate()
    
    override fun encode(ctx: ChannelHandlerContext?, msg: Message?, out: ByteBuf?) {
        log.info("Encode hit")
        
        val byteArray = jacksonObjectMapper().writeValueAsBytes(msg)
        
        log.info("Message encoded {}", byteArray)
        out?.writeBytes(byteArray)
    }
}