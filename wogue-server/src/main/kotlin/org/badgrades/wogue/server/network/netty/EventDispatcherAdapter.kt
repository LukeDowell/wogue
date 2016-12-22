package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.server.event.SessionEventNotifier
import org.badgrades.wogue.server.network.SessionManager
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class EventDispatcherAdapter
@Inject constructor(
        val eventNotifier: SessionEventNotifier,
        val sessionManager: SessionManager
) : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val channel = ctx?.channel() as Channel
        val message = msg as Message
        val session = sessionManager.getSessionFromChannel(channel)
        
        if(session != null) {
            eventNotifier.update(message, session)
        } else {
            log.warn("PlayerSession could not be found for channel with id: {}, message discarded: {}",
                    ctx.channel().id().asShortText(),
                    message)
        }
    }
}