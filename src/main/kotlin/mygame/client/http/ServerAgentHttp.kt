package mygame.client.http

import mygame.client.domain.User

class ServerAgentHttp: ServerAgent {
    override fun getUser(): User? {
        TODO("Not yet implemented")
    }

    override fun login(login: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signIn(name: String, login: String, password: String) {
       print("Ok")
    }

    override fun updateUser(name: String, login: String)  {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun logoutAll()  {
        TODO("Not yet implemented")
    }

    override fun removeUser()  {
        TODO("Not yet implemented")
    }
}