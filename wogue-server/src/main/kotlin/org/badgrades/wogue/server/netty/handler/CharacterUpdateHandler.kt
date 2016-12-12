package org.badgrades.wogue.server.netty.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.util.LoggerDelegate

class CharacterUpdateHandler : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelActive(ctx: ChannelHandlerContext?) {
        log.info("Channel active called, channel name: {}", ctx?.name())
    }
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        log.info("Message received: {}", msg)
    }
}