package org.badgrades.wogue.server.network

import com.google.inject.Inject
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import org.badgrades.wogue.server.network.netty.RootChannelInitializer
import org.badgrades.wogue.shared.util.LoggerDelegate
import org.badgrades.wogue.shared.util.Network.Companion.TCP_PORT


class WogueServer
@Inject constructor(rootChannelInitializer: RootChannelInitializer){

    val log by LoggerDelegate()

    val bossGroup = NioEventLoopGroup()
    val workerGroup = NioEventLoopGroup()
    
    init {
        log.info("Starting WogueServer on port={}", TCP_PORT)

        try {
            val bootStrap = ServerBootstrap()
            bootStrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel::class.java)
                    .childHandler(rootChannelInitializer)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)

            // Bind and start to accept incoming connections
            val channelFuture = bootStrap.bind(TCP_PORT).sync()
    
            log.info("Server started successfully!")
            
            // Wait until the server socket is closed
            channelFuture.channel().closeFuture().sync()
        } catch (e: Exception) {
            log.error("Error bootstrapping server! Shutting down. Error={}", e.message)
        } finally {
            workerGroup.shutdownGracefully()
            bossGroup.shutdownGracefully()
        }

        
    }
}