package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import com.google.inject.Provider
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class EventDispatcherAdapter
constructor(val eventNotifier: EventNotifier) : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val message = msg as Message
        log.info("CHANNEL READ HIT! {}", message.payload)
        eventNotifier.update(message)
    }
}

class EventDispatcherAdapterProvider
@Inject constructor(val eventNotifier: EventNotifier): Provider<EventDispatcherAdapter> {

    override fun get(): EventDispatcherAdapter {
        return EventDispatcherAdapter(eventNotifier = eventNotifier)
    }
}