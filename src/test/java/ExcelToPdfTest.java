import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import xxx.ExcelToPdfUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *  @author: xxxx
 *  @Date: 2020/12/24 15:10
 *  @Description: excel转pdf测试用例
 */
public class ExcelToPdfTest {

    public static void main(String[] args) {
        String sourcePath = "D:\\test.xlsx";
        String targetPath = "D:\\test.pdf";
        // 验证License
        if (!ExcelToPdfUtil.getLicense()) {
            return;
        }

        long old = System.currentTimeMillis();
        if (ExcelToPdfUtil.excelConvertToPdf(sourcePath, targetPath)) {
            long now = System.currentTimeMillis();
            System.out.println("Excel转Pdf成功，共耗时：" + ((now - old) / 1000.0) + "秒");
        }

    }
}