import com.lowagie.text.pdf.PdfReader;
import com.spire.pdf.PdfDocument;
import xxx.util.PDFWatermark;
import java.io.IOException;

/**
 *  @author: xxxx
 *  @Date: 2020/12/24 15:10
 *  @Description: pdf加水印
 */
public class PDFWatermarkTest {

    public static void main(String[] args) throws IOException {
        //原pdf文件路径
        String sourcePath = "D:\\test.pdf";
        //目标pdf文件路径
        String targetPath = "D:\\log\\Watermark22.pdf";
        //加载原pdf文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(sourcePath);
        PdfReader reader = new PdfReader(sourcePath);
        int total = reader.getNumberOfPages();
        for (int i = 0; i < total; i++) {
            PDFWatermark.AddTextWatermark(pdf.getPages().get(i), "已审阅");
        }
        //保存
        pdf.saveToFile(targetPath);
        PDFWatermark.addWatermark(sourcePath, "hahah");
        //关闭
        pdf.close();
    }

}
