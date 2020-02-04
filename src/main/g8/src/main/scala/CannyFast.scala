import org.opencv.imgcodecs.Imgcodecs._
import origami.Origami._
import origami.filters.Canny
object CannyFast extends App {
  if(args.length==0) {
    println("Usage: Main <url>")
    println("Example:")
    println("Main https://raw.githubusercontent.com/hellonico/origami/master/doc/cat_in_bowl.jpeg")
  } else {
    init()
    var mat = urlToMat(args.apply(0))
    mat = new Canny().apply(mat)
    imwrite("main.jpg", mat);
  }
}