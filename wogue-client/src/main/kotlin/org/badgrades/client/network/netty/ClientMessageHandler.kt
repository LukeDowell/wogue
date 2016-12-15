package org.badgrades.client.network.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class ClientMessageHandler : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val message = msg as Message
        log.info("Channel READ! {}", message.payload)
        
        val response = Message(
                Event.CHAT_MESSAGE,
                "Waddup fam"
        )
        ctx?.writeAndFlush(response)
    }
    
    @Suppress("OverridingDeprecatedMember")
    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        log.warn("Exception caught, reason: {}" , cause?.message)
    }
}