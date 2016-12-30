package org.badgrades.client.game

import com.google.inject.Inject
import org.badgrades.client.network.NetworkService

/**
 * Created by luke on 12/16/2016.
 */
class ClientController
@Inject constructor(val networkService: NetworkService) {
    
    var game: Game? = null

    fun init(game: Game) {
        this.game = game
    }

    fun handleChat() {
        
    }
    
    fun handleMove() {
        
    }
}