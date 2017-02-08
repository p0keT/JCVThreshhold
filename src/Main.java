import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_imgproc.*;
import com.sun.javafx.scene.layout.region.Margins;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.googlecode.javacv.cpp.opencv_core.CV_8UC1;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvSize;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_FONT_LIGHT;
import static com.googlecode.javacv.cpp.opencv_highgui.cvConvertImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedImage bImage = null;
        IplImage image = cvLoadImage("subtrect.jpg",CV_8UC1);
        CvMat src = image.asCvMat();
        CvMat dst = new CvMat();
        //адаптивний алгоритм
        //cvAdaptiveThreshold(src, src, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 9, 20);
        //звичайний алгоритм
        cvThreshold(src,src,0,255,CV_THRESH_BINARY+CV_THRESH_OTSU);
        final CanvasFrame canvas = new CanvasFrame("Demo");
        //вивід на екран
        canvas.showImage(image);
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);


        //--------------------------------------------------------------
        //FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("1.mp4");

        //grabber.start();

        //IplImage frame;
        //final CanvasFrame canvas = new CanvasFrame("Demo");

        /* показываем картинку в нашем фрейме */
      /*  while(true){
            frame = grabber.grab();
            BufferedImage image = frame.getBufferedImage();

            CvMat src = frame.asCvMat();
            CvMat src2 = new CvMat();
            cvCvtColor(src,src2,CV_BGR2GRAY);

            //src = CvMat.create(frame.asCvMat().rows(),src.cols(),frame.depth(),CV_8UC1);
            //cvCvtColor(src, src, CV_BGR2GRAY);
            long start2 = System.currentTimeMillis();
            //cvAdaptiveThreshold(src, src, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 9, 20);
            //cvThreshold(src,src,0,255,CV_THRESH_BINARY+CV_THRESH_OTSU);
            long finish2 = System.currentTimeMillis();
            System.out.println("Image thresh: " + (finish2-start2) + " ms");
            canvas.showImage(src.asIplImage());
            canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);


            //System.out.println("FPS: " + 1000/(finish2-start2));

            //grabber.stop();
        }*/

    }

}