package org.badgrades.wogue.shared.model

/**
 * Defines a single map in our world. Could contain players, objects, NPCs, items, spell effects, etc
 */
class Map : Entity() {
    
    /**
     * All of the players on this map
     */
    val players: MutableSet<Player> = mutableSetOf()
    
    /**
     * All of the items on this map. An item in this list implies that the item
     * is laying on the floor and is able to be interacted with by players
     */
    val items: MutableSet<Item> = mutableSetOf()
}