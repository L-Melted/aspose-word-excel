import xxx.util.PDFWatermark;

import java.io.IOException;

/**
 *  @author: xxx
 *  @Date: 2020/12/24 16:18
 *  @Description: aspose-pdf 加水印（不方便）
 */
public class AsposePDFWatermarkTest {
    public static void main(String[] args) throws IOException {
        //原pdf文件路径
        String sourcePath = "D:\\test.pdf";
        PDFWatermark.addWatermark(sourcePath, "已审核");
    }
}
