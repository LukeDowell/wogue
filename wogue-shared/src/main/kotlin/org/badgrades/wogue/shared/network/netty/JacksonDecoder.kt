package org.badgrades.wogue.shared.network.netty

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class JacksonDecoder : ByteToMessageDecoder() {
    
    val log by LoggerDelegate()
    
    override fun decode(ctx: ChannelHandlerContext?, msg: ByteBuf?, out: MutableList<Any>?) {
        log.info("Decode hit")
        val byteArray = msg?.array()
        log.info("Decode Hit {}", byteArray)
        val message = jacksonObjectMapper().readValue(byteArray, Message::class.java)
        log.info("Message decoded! {} {}", message.event, message.payload)
        out?.add(message)
    }
}