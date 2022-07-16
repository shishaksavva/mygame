package mygame.server.handlers


import com.fasterxml.jackson.databind.ObjectMapper
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

class LoginHandler: AppHandler() {
    data class RequestData(val name: String = "")

    override fun handle(ctx: AppHandler.Context) {
        val name: String = ctx.getData<RequestData>().name

        print(name)

        ctx.response(object {
                val name = name
                val age = 20
            }
        )
    }
}