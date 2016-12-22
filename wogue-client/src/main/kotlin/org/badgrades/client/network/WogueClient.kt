package org.badgrades.client.network

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import org.badgrades.client.network.netty.RootChannelInitializer
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate
import org.badgrades.wogue.shared.util.Network

class WogueClient {

    val log by LoggerDelegate()
    val workerGroup = NioEventLoopGroup()
    val bootstrap: Bootstrap

    init {
        bootstrap = Bootstrap()
        bootstrap.group(workerGroup)
        bootstrap.channel(NioSocketChannel::class.java)
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
        bootstrap.handler(RootChannelInitializer())
    }

    fun connect(address: String = Network.ADDRESS, port: Int = Network.TCP_PORT) {
        log.info("WogueClient starting up...")

        try {
            // We should call connect instead of bind, why?
            val channelFuture = bootstrap.connect(
                    address,
                    port
            ).sync()
            
            log.info("WogueClient started successfully!")
            
            log.info("Requesting session...")
            ClientService.channel?.writeAndFlush(
                    Message(
                            Event.ALL,
                            "Give me a session ;_;"
                    )
            )

            // Wait until the connection is closed
            channelFuture.channel()
                    .closeFuture()
                    .sync()
        } catch (e: Exception) {
            log.error("Error performing client connection! Message: {}" , e.message)
        } finally {
            workerGroup.shutdownGracefully()
        }
    }
}