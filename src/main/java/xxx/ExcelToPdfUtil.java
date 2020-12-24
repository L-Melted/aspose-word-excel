package xxx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

/**
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms512m -Xmx512m(参考值)<br>
 */
public class ExcelToPdfUtil {

    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = ExcelToPdfUtil.class.getClassLoader().getResourceAsStream("\\license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 支持DOC, DOCX, OOXML, RTF, HTML, OpenDocument, PDF, EPUB, XPS, SWF等相互转换<br>
     *
     * @param excelfilePath [原始excel路径]
     * @param pdfFilePath   [输出路径]
     */

    public static Boolean excelConvertToPdf(String excelfilePath, String pdfFilePath) {
        // 验证License
        if (!getLicense()) {
            return false;
        }

        try {
            // 原始excel路径
            Workbook wb = new Workbook(excelfilePath);
            // 输出路径
            File pdfFile = new File(pdfFilePath);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            wb.save(fileOS, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}