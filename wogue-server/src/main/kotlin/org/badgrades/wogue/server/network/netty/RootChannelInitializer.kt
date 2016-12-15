package org.badgrades.wogue.server.network.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.serialization.ClassResolvers
import io.netty.handler.codec.serialization.ObjectDecoder
import io.netty.handler.codec.serialization.ObjectEncoder
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

/**
 * This is the root handler for all connections coming into our server
 */
class RootChannelInitializer : ChannelInitializer<SocketChannel>() {
    
    val log by LoggerDelegate()
    
    override fun initChannel(ch: SocketChannel?) {
        log.info("Initializing incoming connection with id: {} and address: {}",
                ch?.id(),
                ch?.remoteAddress())
        
        ch?.pipeline()?.addLast(
        
                // Outbound
                ObjectEncoder(),
                
                // Inbound
                ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                EventDispatcherAdapter()
        )
        
        log.info("Channel with id: {} and address: {} initialized!",
                ch?.id(),
                ch?.remoteAddress())
    
        val message = Message(
                Event.CHAT,
                "Hey dog"
        )
        ch?.writeAndFlush(message)
    }
}