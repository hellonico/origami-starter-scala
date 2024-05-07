import java.util

import org.opencv.core.{Core, Mat, Point, Scalar, Size}
import org.opencv.dnn.Net
import org.opencv.imgproc.Imgproc
import origami.{Camera, Dnn}
import origami.Origami._

object CaffeCam extends App {
  init()

  val list = Dnn.readNetFromSpec("networks.caffe:convnet-age:1.0.0")
  val _net: Net = list.get(0).asInstanceOf[Net]
  _net.setPreferableBackend(org.opencv.dnn.Dnn.DNN_BACKEND_OPENCV)
  val labels: util.List[String] = list.get(2).asInstanceOf[java.util.List[String]]

  val age = new origami.Filter {
    override def apply(f: Mat): Mat = {
      val inputBlob = org.opencv.dnn.Dnn.blobFromImage(f, 1, new Size(256, 256), new Scalar(0), true, true)
      _net.setInput(inputBlob)
      val result = _net.forward()
      val minmax = Core.minMaxLoc(result)
      val label = labels.get(minmax.maxLoc.x.toInt)
      Imgproc.putText(f, label , new Point(100,100),1,2, new Scalar(0,0,0));
      f
    }
  }

  val cam = new Camera()
  cam.device(0).filter(age).run()
}