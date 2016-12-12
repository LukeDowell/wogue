package org.badgrades.client.netty.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import java.util.*


class TimeClientHandler : ChannelInboundHandlerAdapter() {
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val m = msg as ByteBuf // (1)
        try {
            
            val currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L
            println(Date(currentTimeMillis))
            ctx?.close()
            
        } finally {
            m.release()
        }
    }
}