import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.rssanalizier.app.RssAnalizerApplication

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new RssAnalizerApplication, "/home/*")
    println("Server Started")
  }
}