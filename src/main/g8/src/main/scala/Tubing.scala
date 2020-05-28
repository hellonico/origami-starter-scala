import origami.Camera
import origami.Origami.init
import origami.video.YouTubeHandler

object Tubing extends App {
  init()
  val _ =  new YouTubeHandler
  new Camera().device("youtube://cbP2N1BQdYc").run()
}
