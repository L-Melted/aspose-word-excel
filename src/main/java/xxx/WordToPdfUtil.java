package xxx;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms512m -Xmx512m(参考值)<br>
 */
public class WordToPdfUtil {

    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = WordToPdfUtil.class.getClassLoader().getResourceAsStream("\\license.xml");
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
     * @param wordfilePath [原始excel路径]
     * @param pdfFilePath  [输出路径]
     */
    public static Boolean wordConvertToPdf(String wordfilePath, String pdfFilePath) {
        // 验证License
        if (!getLicense()) {
            return false;
        }

        try {
            // 原始word路径
            Document doc = new Document(wordfilePath);
            // 输出路径
            File pdfFile = new File(pdfFilePath);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            doc.save(fileOS, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}