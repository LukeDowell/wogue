package org.badgrades.client.network.netty

import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.json.JsonObjectDecoder
import org.badgrades.client.network.netty.ClientMessageHandler
import org.badgrades.wogue.shared.network.ItemObjectEncoder
import org.badgrades.wogue.shared.network.PlayerObjectEncoder
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.nio.charset.Charset

class RootChannelInitializer : ChannelInitializer<SocketChannel>() {
    
    val log by LoggerDelegate()
    
    override fun initChannel(ch: SocketChannel?) {
        
        log.info("Initializing channel with id: {} and address: {} ",
                ch?.id(),
                ch?.remoteAddress())
        
        ch?.pipeline()?.addLast(
                // Inbound Adapter
                JsonObjectDecoder(),
                ClientMessageHandler(),
                
                // Outbound Adapter, note that the last adapter is the first hit in the pipeline
                ItemObjectEncoder(),
                PlayerObjectEncoder()
        )
        
        log.info("Done initializing channel with id: {} and address: {} ",
                ch?.id(),
                ch?.remoteAddress())
    }
    
    override fun channelActive(ctx: ChannelHandlerContext?) {
        val byteBuffer = Unpooled.copiedBuffer("Hello!", Charset.forName("UTF-8"))
        ctx?.writeAndFlush(byteBuffer)?.addListener { log.info("ByteBuffer sent: {}", byteBuffer) }
    }
}