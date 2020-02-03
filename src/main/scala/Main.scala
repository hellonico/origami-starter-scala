import org.opencv.imgcodecs.Imgcodecs
import origami.Origami._
import origami.filters.Canny
object Main extends App {
  init()
  var mat = urlToMat("https://raw.githubusercontent.com/hellonico/origami/master/doc/cat_in_bowl.jpeg")
  mat = new Canny().apply(mat)
  Imgcodecs.imwrite("test.jpg", mat);
}