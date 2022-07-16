package mygame.client.http

import mygame.client.domain.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.test.*

class ServerAgentHttpTest {
    val serverAgent = ServerAgentHttp()

    val userName = "Sherlok Holms"
    val userLogin = "Sherlok"
    val userPassword = "12345678"

    @Before
    fun singInUser() {
        try {
            serverAgent.signIn(userName, userLogin, userPassword)

            if (serverAgent.getUser() == null) {
                assertFails("После регистрации пользователь не сохраняется в приложении", {})
                return
            }
        } catch (e: Exception) {
            assertFails("Пользователь не может зарегистрироваться", {})
        }
    }

    @After
    fun removeUser() {
        serverAgent.removeUser()
        assertNull(serverAgent.getUser(), "При удалении пользователя, он не удаляется из системы")
    }

    @Test
    fun signIn() {
        val user = serverAgent.getUser() as User
        assertNotNull(user, "после регистрации у пользователя должен быть ID")
    }

    @Test
    fun signInData() {
        val user = serverAgent.getUser() as User
        assertNotNull(user.id, "после регистрации у пользователя должен быть ID")
        assertEquals(user.name, userName, "после регистрации у пользователя не правильное имя")
        assertEquals(user.login, userLogin, "после регистрации у пользователя не правильный логин")
    }

    @Test
    fun loginAndLogout() {
        serverAgent.logout()
        assertNull(serverAgent.getUser(), "После выхода пользователь не сохраняется в приложении")
        serverAgent.login(userLogin, userPassword)
        assertNotNull(serverAgent.getUser(), "После входа пользователь появляется в приложении")
    }

    @Test
    fun update() {
        serverAgent.updateUser(userName+1, userLogin+"new")
        serverAgent.logout()
        serverAgent.login(userLogin+"new", userPassword)
        assertNotNull(serverAgent.getUser(), "Пользователь не может зайти по новому логину")
        assertNotNull(serverAgent.getUser()!!.name, "Имя пользователя не обновляется")
    }
}