package org.badgrades.client.gui

import com.google.inject.Inject
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import org.badgrades.client.game.ClientController
import org.badgrades.client.network.NetworkService
import org.badgrades.wogue.shared.util.LoggerDelegate

class InputHandler
@Inject constructor(
        val clientController: ClientController
) {

    val log by LoggerDelegate()

    /**
     *
     */
    fun handleInputChat(text: String) : EventHandler<KeyEvent> {
        val inputChatEventHandler = EventHandler<KeyEvent> {
            log.info("Text input event! $text")
        }
        return inputChatEventHandler
    }
}