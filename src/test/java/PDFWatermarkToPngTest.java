import com.lowagie.text.pdf.PdfReader;
import com.spire.pdf.PdfDocument;
import xxx.util.PDFWatermark;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  @author: xxxx
 *  @Date: 2020/12/24 15:10
 *  @Description: pdf加水印
 */
public class PDFWatermarkToPngTest {
    public static void main(String[] args) throws IOException {
        String sourcePath = "D:\\log\\Watermark22.pdf";
        String targetPath = "D:\\log\\";
        PdfDocument pdf1 = new PdfDocument();
        pdf1.loadFromFile(sourcePath);
        PdfReader reader = new PdfReader(sourcePath);
        BufferedImage image;
        int total1 = reader.getNumberOfPages();
        for(int i =0 ; i<total1;i++){
            image = pdf1.saveAsImage(i);//将每一页pdf拆分出来保存为图片
            File file = new File(String.format(targetPath+"Watermark33"+i+".png",i));
            ImageIO.write(image,"PNG",file);
            PDFWatermark.fileCopyRightWay(targetPath+"Watermark33"+i+".png",targetPath+"测试3_"+i+".png");//对图片进行重命名
        }
        pdf1.close();

    }

}
