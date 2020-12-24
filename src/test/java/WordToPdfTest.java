import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import xxx.WordToPdfUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *  @author: xxxx
 *  @Date: 2020/12/24 15:10
 *  @Description: excel转pdf测试用例
 */
public class WordToPdfTest {

    public static void main(String[] args) {
        String sourcePath = "D:\\CYD\\公司领导测评操作手册20201205.docx";
        String targetPath = "D:\\test.pdf";
        // 验证License
        if (!WordToPdfUtil.getLicense()) {
            return;
        }

        long old = System.currentTimeMillis();
        if (WordToPdfUtil.wordConvertToPdf(sourcePath,targetPath)) {
            long now = System.currentTimeMillis();
            System.out.println("word转pdf成功,共耗时：" + ((now - old) / 1000.0) + "秒");
        }

    }
}