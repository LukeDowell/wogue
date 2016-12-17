package org.badgrades.wogue.server.network.netty

import com.google.inject.Provider
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class LoginAdapter : ChannelInboundHandlerAdapter() {
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        super.channelRead(ctx, msg)
    }
}

class LoginAdapterProvider : Provider<LoginAdapter> {
    override fun get(): LoginAdapter {
        return LoginAdapter()
    }
}