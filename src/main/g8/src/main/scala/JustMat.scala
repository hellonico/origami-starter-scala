import org.opencv.core.{CvType, Mat}
import origami.Origami._
object JustMat extends App {
    init()
    var mat = Mat.eye(3,3, CvType.CV_8UC1)
    println(mat.dump())
}