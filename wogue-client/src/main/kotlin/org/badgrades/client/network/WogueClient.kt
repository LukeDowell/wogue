package org.badgrades.client.network

import com.google.inject.Inject
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import org.badgrades.client.network.netty.RootChannelInitializer
import org.badgrades.wogue.shared.util.LoggerDelegate
import org.badgrades.wogue.shared.util.Network

class WogueClient
@Inject constructor(
        rootChannelInitializer: RootChannelInitializer
) {

    val log by LoggerDelegate()
    val workerGroup = NioEventLoopGroup()
    val bootstrap: Bootstrap

    init {
        bootstrap = Bootstrap()
        bootstrap.group(workerGroup)
        bootstrap.channel(NioSocketChannel::class.java)
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
        bootstrap.handler(rootChannelInitializer)
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