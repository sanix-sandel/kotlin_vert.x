import io.vertx.core.Vertx

fun main() {
    val vertx= Vertx.vertx()
    vertx.createHttpServer().requestHandler{
        ctx ->ctx.response().end("OK")
    }.listen(8081)

    println("Open http://localhost:8081")
}