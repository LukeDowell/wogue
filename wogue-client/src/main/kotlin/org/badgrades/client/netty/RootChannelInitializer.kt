package org.badgrades.client.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import org.badgrades.wogue.shared.util.LoggerDelegate

class RootChannelInitializer : ChannelInitializer<SocketChannel>() {
    
    val log by LoggerDelegate()
    
    override fun initChannel(ch: SocketChannel?) {
        
        log.info("Initializing channel with id: {} and address: {} ",
                ch?.id(),
                ch?.remoteAddress())
        
        ch?.writeAndFlush("Hello!")
        
        log.info("Done initializing channel with id: {} and address: {} ",
                ch?.id(),
                ch?.remoteAddress())
    }
}