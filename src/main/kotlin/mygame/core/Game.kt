package mygame.core

import mygame.core.entities.Entity

class Game {
    fun start() {}

    fun update() {}

    fun render(deltaTime: Int): List<Entity> {
        return emptyList()
    }

    fun destroy() {}
}