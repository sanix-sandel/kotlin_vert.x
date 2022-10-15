import io.vertx.ext.web.Router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.coroutines.CoroutineVerticle


val json=json{
    obj("status" to "OK")
}
class ServerVerticle: CoroutineVerticle(){

    override suspend fun start(){
        val router =router()

        router.mountSubRouter("/cats", catsRouter())

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

    private fun router(): Router {
        val router= Router.router(vertx)

        return router
    }

    private fun catsRouter():Router{
        val router=Router.router(vertx)

        router.get("/").handler{
            ctx -> ctx.response().end("Getting")
        }

        router.delete("/:id").handler{
            ctx-> ctx.response().end(json.toString())
        }

        router.put("/:id").handler{
            ctx -> ctx.response().end(json.toString())
        }

        return router
    }
}