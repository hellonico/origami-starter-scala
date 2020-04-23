import CannyFast.args
import org.opencv.core.Mat
import origami.Origami
import org.opencv.imgcodecs.Imgcodecs.{IMREAD_COLOR, imread, imwrite}
import org.opencv.imgproc.Imgproc.{THRESH_BINARY, THRESH_BINARY_INV, THRESH_TOZERO, THRESH_TOZERO_INV, threshold}
import origami.Origami.urlToMat

object BasicThresholding extends App {
    if(args.length==0) {
        println("Usage: BasicThresholding <url>")
        println("Example:")
        println("BasicThresholding https://raw.githubusercontent.com/hellonico/origami/master/doc/cat_in_bowl.jpeg")
    } else {
        Origami.init()
        var source = urlToMat(args.apply(0))
        val destination = new Mat(source.rows, source.cols, source.`type`)
        threshold(source, destination, 127, 255, THRESH_TOZERO)
        imwrite("ThreshZero.jpg", destination)
        threshold(source, destination, 127, 255, THRESH_TOZERO_INV)
        imwrite("ThreshZeroInv.jpg", destination)
        threshold(source, destination, 127, 255, THRESH_BINARY)
        imwrite("ThreshBinary.jpg", destination)
        threshold(source, destination, 127, 255, THRESH_BINARY_INV)
        imwrite("ThreshBinaryInv.jpg", destination)
    }
}