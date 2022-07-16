package mygame.server

import com.sun.net.httpserver.HttpServer
import mygame.server.handlers.LoginHandler
import java.net.InetSocketAddress
import java.util.concurrent.Executors
import java.util.logging.Level
import java.util.logging.Logger

class Server {
    val logger = Logger.getAnonymousLogger()
    val http = HttpServer.create(InetSocketAddress("localhost", 8080), 0)

    init {
        http.createContext("/login", LoginHandler())
        http.executor = Executors.newFixedThreadPool(10)
        http.start()
        println("Server starting at http://localhost:8080")
    }
}