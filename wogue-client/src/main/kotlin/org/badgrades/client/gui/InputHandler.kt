package org.badgrades.client.gui

import com.google.inject.Inject
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import org.badgrades.client.game.ClientController
import org.badgrades.client.network.NetworkService

class InputHandler
@Inject constructor(
        clientController: ClientController,
        networkService: NetworkService
) {
    
    /**
     *
     */
    val inputChatEventHandler = EventHandler<KeyEvent> {
        
    }
}