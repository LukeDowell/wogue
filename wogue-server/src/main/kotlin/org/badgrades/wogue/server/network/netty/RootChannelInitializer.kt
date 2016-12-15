package org.badgrades.wogue.server.network.netty

import com.google.inject.Inject
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.json.JsonObjectDecoder
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.network.netty.JacksonDecoder
import org.badgrades.wogue.shared.network.netty.JacksonEncoder
import org.badgrades.wogue.shared.util.LoggerDelegate

/**
 * This is the root handler for all connections coming into our server
 */
class RootChannelInitializer
@Inject constructor(eventDispatcherAdapter: EventDispatcherAdapter): ChannelInitializer<SocketChannel>() {
    
    val log by LoggerDelegate()
    
    override fun initChannel(ch: SocketChannel?) {
        log.info("Initializing incoming connection with id: {} and address: {}",
                ch?.id(),
                ch?.remoteAddress())
        
        ch?.pipeline()?.addLast(
        
                // Inbound
                JsonObjectDecoder(),
                JacksonDecoder(),
                EventDispatcherAdapter(),

                // Outbound
                JacksonEncoder()
        )
        
        log.info("Channel with id: {} and address: {} initialized!",
                ch?.id(),
                ch?.remoteAddress())
    
        val message = Message(
                Event.CHAT_MESSAGE,
                "Hey dog"
        )
        ch?.writeAndFlush(message)
    }
}