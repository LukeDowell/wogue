package org.badgrades.client.netty.encoder

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder
import org.badgrades.wogue.shared.model.Item
import org.badgrades.wogue.shared.model.Player
import org.badgrades.wogue.shared.util.LoggerDelegate

class ItemObjectEncoder : MessageToByteEncoder<Item>() {
    
    val log by LoggerDelegate()
    
    override fun encode(ctx: ChannelHandlerContext?, msg: Item?, out: ByteBuf?) {
        val msgJsonString = jacksonObjectMapper().writeValueAsString(msg)
        log.info("ItemObjectEncoder HIT, JSON: {}", msgJsonString)
        ByteBufUtil.writeUtf8(out, msgJsonString)
    }
}

class PlayerObjectEncoder : MessageToByteEncoder<Player>() {
    
    val log by LoggerDelegate()
    
    override fun encode(ctx: ChannelHandlerContext?, msg: Player?, out: ByteBuf?) {
        val msgJsonString = jacksonObjectMapper().writeValueAsString(msg)
        log.info("PlayerObjectEncoder HIT, JSON: {}", msgJsonString)
        ByteBufUtil.writeUtf8(out, msgJsonString)
    }
}