package org.badgrades.client.gui

import com.google.inject.Inject
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import org.badgrades.wogue.shared.util.LoggerDelegate

class ClientFrame : Application() {

    val log by LoggerDelegate()
    val canvas = Canvas()
    val submitButton = Button()
    val chatField = TextField()
    val inputField = TextField()
    @Inject val gameRenderer: GameRenderer? = null
    @Inject val inputHandler: InputHandler? = null

    companion object {
        const val WIDTH = 500.0
        const val HEIGHT = 900.0
    }

    fun initialize() {
        log.info("Initializing ClientFrame")
        launch(ClientFrame::class.java)
    }
    
    override fun start(primaryStage: Stage) {
        log.info("ClientFrame setup starting...")
        canvas.width = 400.0
        canvas.height = 400.0
        canvas.graphicsContext2D.fill = Color.BLACK
        canvas.graphicsContext2D.fillRect(
                0.0,
                0.0,
                canvas.width,
                canvas.height
        )
        
        submitButton.text = "SEND"
        
        chatField.isEditable = false
        chatField.minHeight = 150.0
        
        val grid = GridPane()
        grid.alignment = Pos.TOP_LEFT
        grid.hgap = 10.0
        grid.vgap = 10.0
        grid.padding = Insets(
                10.0,
                10.0,
                10.0,
                10.0
        )
        
        grid.add(canvas, 0, 0)
        grid.add(chatField, 0, 1)
        grid.add(inputField, 0, 2)
    
        val scene = Scene(grid)
        
        primaryStage.title = "Client :^)"
        primaryStage.scene = scene
        
        setupEventHandlers()
        setupRenderer()
        primaryStage.show()
        log.info("ClientFrame setup complete")
    }
    
    fun setupEventHandlers() {
        inputField.onKeyReleased = inputHandler?.handleInputChat(inputField.text)
    }
    
    fun setupRenderer() {
        
    }
}
