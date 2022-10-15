import io.vertx.ext.web.Router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.coroutines.CoroutineVerticle

val json= json{
    obj(
        "status" to "OK"
    )
}


class ServerVerticle: CoroutineVerticle(){

    override suspend fun start(){
        val router =router()
        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8081)
        println("Open http://localhost:8081/status")

    }

    private fun router(): Router {
        val router= Router.router(vertx)

        router.get("/status").handler{
                ctx->ctx.response()
            .setStatusCode(200)
            .end(json.toString())
        }
        return router
    }
}