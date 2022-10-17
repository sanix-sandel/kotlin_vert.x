import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.Router.router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.coroutines.CoroutineVerticle



fun main() {
    val vertx=Vertx.vertx()
    vertx.deployVerticle(ServerVerticle())
}

//db branch created