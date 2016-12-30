package org.badgrades.client.network

import io.netty.channel.Channel
import io.netty.util.concurrent.Future
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

/**
 *
 */
class NetworkService {
    val log by LoggerDelegate()
    private var channel: Channel? = null
    
    fun init(channel: Channel) {
        this.channel = channel
    }
    
    /**
     *
     */
    fun sendMessage(message: Message, callback: (Future<in Void>) -> Unit) {
        if (channel != null) {
            channel?.writeAndFlush(message)?.addListener { callback(it) }
        } else {
            log.warn("Channel null while attempting to send message: $message")
        }
    }
}