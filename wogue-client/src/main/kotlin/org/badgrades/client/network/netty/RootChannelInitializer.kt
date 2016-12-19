package org.badgrades.client.network.netty

import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.json.JsonObjectDecoder
import org.badgrades.wogue.shared.network.netty.JacksonDecoder
import org.badgrades.wogue.shared.network.netty.JacksonEncoder
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.nio.charset.Charset

class RootChannelInitializer : ChannelInitializer<SocketChannel>() {
    
    val log by LoggerDelegate()
    
    override fun initChannel(ch: SocketChannel?) {
        
        log.info("Initializing channel with id: {} and address: {} ",
                ch?.id(),
                ch?.remoteAddress())
        
        ch?.pipeline()?.addLast(
        
                // Outbound
                JacksonEncoder(),
                
                // Inbound
                JacksonDecoder(),
                JsonObjectDecoder(),
                ClientMessageHandler()
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