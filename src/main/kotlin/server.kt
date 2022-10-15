import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj

fun main() {

    val json=json{
        obj(
            "status" to "OK"
        )
    }


    val vertx= Vertx.vertx()

    //router
    val router=Router.router(vertx)

    router.get("/status").handler{
        ctx->ctx.response()
        .setStatusCode(200)
        .end(json.toString())
    }

    vertx.createHttpServer()
        .requestHandler(router)
        .listen(8081)



    println("Open http://localhost:8081/status")
}