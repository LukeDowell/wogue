package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import com.google.inject.Provider
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.model.Player
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import java.awt.Point

class LoginAdapter
constructor(val eventDispatcherAdapter: EventDispatcherAdapter): ChannelInboundHandlerAdapter() {
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val approvalMessage = Message(
                Event.LOGIN_ACCEPTED,
                Player(
                        ctx?.channel()?.id()?.asShortText() ?: "Default",
                        Point(1, 1)
                )
        )
        ctx?.writeAndFlush(approvalMessage)
        
        ctx?.pipeline()?.remove(this)
        ctx?.pipeline()?.addLast(eventDispatcherAdapter)
    }
}

class LoginAdapterProvider
@Inject constructor(val eventDispatcherAdapterProvider: EventDispatcherAdapterProvider): Provider<LoginAdapter> {
    
    override fun get(): LoginAdapter {
        return LoginAdapter(eventDispatcherAdapter = eventDispatcherAdapterProvider.get())
    }
}