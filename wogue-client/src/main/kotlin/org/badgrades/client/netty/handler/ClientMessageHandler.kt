package org.badgrades.client.netty.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.model.Entity
import org.badgrades.wogue.shared.util.LoggerDelegate

class ClientMessageHandler : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        if (msg is ByteBuf) {
            log.info("ByteBuf received from context: {} ,  {}",
                    ctx?.name(),
                    msg.toString())
            
            val msgBytes = ByteArray(msg.readableBytes(), { _ -> msg.readByte() })
            log.info("Message received! {}" , String(msgBytes))
        }
        
        if (msg is Entity) {
            log.info("Entity received from context: {} , uuid: {}",
                    ctx?.name(),
                    msg.id.toString())
        } else {
            log.info("Unhandled message sent {}", msg)
        }
    }
    
    @Suppress("OverridingDeprecatedMember")
    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        log.warn("Exception caught, reason: {}" , cause?.message)
    }
}