import origami.Camera
import origami.Origami._
import origami.filters.cartoon.Cartoon2
object CartoonCam extends App {
  init()
  var cam = new Camera()
  cam.filter(new Cartoon2())
  cam.run()
}