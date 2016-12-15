package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class EventDispatcherAdapter
@Inject constructor(eventNotifier: EventNotifier) : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val message = msg as Message
        log.info("CHANNEL READ HIT! {}", message.payload)
    }
    
    override fun channelActive(ctx: ChannelHandlerContext?) {
        log.info("CHANNEL ACTIVE HIT")
        super.channelActive(ctx)
    }
}