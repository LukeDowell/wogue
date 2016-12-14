package org.badgrades.client.network

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import org.badgrades.client.network.netty.RootChannelInitializer
import org.badgrades.wogue.shared.util.LoggerDelegate
import org.badgrades.wogue.shared.util.Network

class WogueClient {

    val log by LoggerDelegate()
    val workerGroup = NioEventLoopGroup()

    companion object {
        /**
         * Time in milliseconds to try connecting to the server
         */
        const val CONNECTION_TIMEOUT = 5000
    }

    init {
        log.info("WogueClient starting up...")

        try {
            val bootstrap = Bootstrap()
            bootstrap.group(workerGroup)
            bootstrap.channel(NioSocketChannel::class.java)
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
            bootstrap.handler(RootChannelInitializer())
            
            // We should call connect instead of bind, why?
            val channelFuture = bootstrap.connect(
                    Network.ADDRESS,
                    Network.TCP_PORT
            ).sync()
            
            // Wait until the connection is closed
            channelFuture.channel()
                    .closeFuture()
                    .sync()
        } finally {
            workerGroup.shutdownGracefully()
        }
        
        log.info("WogueClient started successfully!")
    }
}