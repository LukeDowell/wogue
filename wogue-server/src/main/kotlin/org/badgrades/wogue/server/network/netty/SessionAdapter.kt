package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.server.domain.impl.DefaultPlayerSession
import org.badgrades.wogue.server.network.SessionManager
import org.badgrades.wogue.shared.model.Player
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import java.awt.Point
import java.util.*

/**
 * Builds a player session, adds to the session manager and modifies the context pipeline.
 * Eventually we will c
 */
class SessionAdapter
@Inject constructor(val eventDispatcherAdapter: EventDispatcherAdapter,
                    val sessionManager: SessionManager): ChannelInboundHandlerAdapter() {
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val channel = ctx?.channel() as Channel
        val player = Player(
                channel.id().asShortText() ?: "DefaultPlayer",
                Point(
                        Random().nextInt(10),
                        Random().nextInt(10)
                )
        )
        val approvalMessage = Message(
                Event.LOGIN_ACCEPTED,
                player
                
        )
        ctx.writeAndFlush(approvalMessage)
        
        val session = DefaultPlayerSession(
                player = player,
                channel = channel
        )
        sessionManager.addSession(session)
        
        ctx.pipeline().remove(this)
        ctx.pipeline().addLast(eventDispatcherAdapter)
    }
}