package org.badgrades.client.network.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.badgrades.wogue.shared.model.ChatMessage
import org.badgrades.wogue.shared.model.Player
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

class ClientMessageHandler : ChannelInboundHandlerAdapter() {
    
    val log by LoggerDelegate()
    
    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        val message = msg as Message
        
        when(message.event) {
            
            Event.LOGIN_ACCEPTED -> {
                val player = message.payload as Player
                log.info("Player Set! $player")
            }
            
            Event.CHAT_MESSAGE -> {
                val chatMessage = message.payload as ChatMessage
                log.info("${chatMessage.authorName} : ${chatMessage.content}")
            }
            
            else -> println(message)
        }
    }
    
    @Suppress("OverridingDeprecatedMember")
    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {
        log.warn("Exception caught, reason: {}" , cause?.message)
    }
}