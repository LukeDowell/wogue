package org.badgrades.wogue.shared.model

import java.awt.Point

data class Player(val name: String,
                  val position: Point) : Entity()