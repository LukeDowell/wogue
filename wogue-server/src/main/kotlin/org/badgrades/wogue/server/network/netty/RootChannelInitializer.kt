package org.badgrades.wogue.server.network.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
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
                
                // Inbound Adapters
                
                
                // Outbound Adapters. The last adapter will be the first adapter hit on outgoing calls
        )
        
        log.info("Channel with id: {} and address: {} initialized!",
                ch?.id(),
                ch?.remoteAddress())
    }
}