package org.badgrades.client.gui

import com.google.inject.AbstractModule

/**
 * Created by luke on 12/29/2016.
 */
class GuiModule : AbstractModule() {
    override fun configure() {
        bind(GameRenderer::class.java).asEagerSingleton()
        bind(ClientFrame::class.java).asEagerSingleton()
        bind(InputHandler::class.java).asEagerSingleton()
    }
}