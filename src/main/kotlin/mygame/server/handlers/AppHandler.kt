package mygame.server.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

abstract class AppHandler: HttpHandler {
    data class Context(val exchange: HttpExchange) {
        val mapper: ObjectMapper = ObjectMapper()

        inline fun <reified T>getData(): T {
            return mapper.readValue(String(exchange.requestBody.readAllBytes()), T::class.java)
        }

        fun response(data: Any? = null) {
            val out = exchange.responseBody
            if (data != null) {
                exchange.sendResponseHeaders(200, mapper.writeValueAsString(data).length.toLong())
                out.write(mapper.writeValueAsBytes(data))
            }
            out.flush()
            out.close()
        }
    }

    override fun handle(exchange: HttpExchange?) {
        if (exchange == null) return
        try {
            handle(Context(exchange))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    abstract fun handle(ctx: Context)
}