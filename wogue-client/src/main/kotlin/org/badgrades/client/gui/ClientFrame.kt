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

class ClientFrame
@Inject constructor(
        val inputHandler: InputHandler,
        val gameRenderer: GameRenderer
): Application() {
    
    val canvas = Canvas()
    val submitButton = Button()
    val chatField = TextField()
    val inputField = TextField()
    
    companion object {
        const val WIDTH = 500.0
        const val HEIGHT = 900.0
        
        @JvmStatic
        fun main(args: Array<String>) {
            launch(ClientFrame::class.java)
        }
    }
    
    override fun start(primaryStage: Stage?) {
        val stage = primaryStage as Stage
        
        canvas.width = 400.0
        canvas.height = 400.0
        canvas.graphicsContext2D?.fill = Color.BLACK
        canvas.graphicsContext2D?.fillRect(
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
        
        stage.title = "Client :^)"
        stage.scene = scene
        
        setupEventHandlers()
        setupRenderer()
        stage.show()
    }
    
    fun setupEventHandlers() {
        inputField.onKeyReleased = inputHandler.inputChatEventHandler
    }
    
    fun setupRenderer() {
        
    }
}
