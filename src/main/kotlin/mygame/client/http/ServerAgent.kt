package mygame.client.http

import mygame.client.domain.User

interface ServerAgent {
    fun getUser(): User?
    fun login(login: String, password: String)
    fun signIn(name: String, login: String, password: String)
    fun updateUser(name: String, login: String)
    fun logout()
    fun logoutAll()
    fun removeUser()
}