package org.badgrades.wogue.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.util.LoggerDelegate

/**
 * Discards and logs any message received
 * Created by luke on 12/10/2016.
 */
class DiscardServerHandler : ChannelInboundHandlerAdapter() {

    val log by LoggerDelegate()

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val message = msg as? ByteBuf
        message?.release()

        log.info("Received and discarded byte buffer of size {}", message?.array()?.size)
    }
}