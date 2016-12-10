package org.badgrades.wogue.handler

import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.util.LoggerDelegate

/**
 * Created by luke on 12/10/2016.
 */
class TimeServerHandler : ChannelInboundHandlerAdapter() {

    val log by LoggerDelegate()

    override fun channelActive(ctx: ChannelHandlerContext?) {
        val time = ctx?.alloc()?.buffer(4)
        time?.writeInt((System.currentTimeMillis() / 1000L + 2208988800L).toInt())

        val future = ctx?.writeAndFlush(time)
        future?.addListener {
            ChannelFutureListener { channelFuture ->
                assert(future == channelFuture)
                ctx.close()
            }
        }
    }
}