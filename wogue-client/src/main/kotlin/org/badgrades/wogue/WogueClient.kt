package org.badgrades.wogue

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import org.badgrades.wogue.handler.TimeClientHandler
import org.badgrades.wogue.net.Network
import org.badgrades.wogue.util.LoggerDelegate

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
            bootstrap.handler(object : ChannelInitializer<SocketChannel>() {
                override fun initChannel(ch: SocketChannel?) {
                    ch?.pipeline()?.addLast(TimeClientHandler())
                }
            })

            // Start the client
            val future = bootstrap.connect(
                    Network.ADDRESS,
                    Network.TCP_PORT
            ).sync()

            log.info(
                    "Client started, address: {} , port: {}",
                    Network.ADDRESS,
                    Network.TCP_PORT
            )

            // Wait until the connection is closed
            future.channel()
                    .closeFuture()
                    .sync()

        } finally {

            workerGroup.shutdownGracefully()
            log.info("WorkerGroup shut down")

        }
        
        log.info("WogueClient started successfully!")
    }
}