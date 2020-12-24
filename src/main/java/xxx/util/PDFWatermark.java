package xxx.util;

import com.aspose.pdf.*;
import com.lowagie.text.pdf.PdfReader;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;

public class PDFWatermark {

    /**
     * @param page      要添加水印的页面
     * @param imageFile 水印图片路径
     */
    public static void AddImageWatermark(PdfPageBase page, String imageFile) {
        page.setBackgroundImage(imageFile);
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(page.getClientSize().getWidth() / 2 - 100, page.getClientSize().getHeight() / 2 - 100, 200, 200);
        page.setBackgroundRegion(rect);
    }

    /**
     * @param page          要添加水印的页面
     * @param textWatermark 水印文字
     */
    public static void AddTextWatermark(PdfPageBase page, String textWatermark) {
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(page.getCanvas().getClientSize().getWidth() / 3, page.getCanvas().getClientSize().getHeight() / 3);
        PdfTilingBrush brush = new PdfTilingBrush(dimension2D);
        brush.getGraphics().setTransparency(0.3F);
        brush.getGraphics().save();
        brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);
        brush.getGraphics().rotateTransform(-45);
        brush.getGraphics().drawString(textWatermark, new PdfTrueTypeFont(new Font("新宋体", Font.PLAIN, 30), true), PdfBrushes.getGray(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));
        brush.getGraphics().restore();
        brush.getGraphics().setTransparency(1);
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getClientSize());
        page.getCanvas().drawRectangle(brush, loRect);
    }

    /**
     * @param sourceFile 需要重新重命名的图片路径
     * @param targetPath 重命名的图片路径保存地址
     */
    public static void fileCopyRightWay(String sourceFile, String targetPath) {
        try {
            //读取源地址文件的字节流
            FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(targetPath);
            byte[] bs = new byte[1026];
            int count = 0;
            while ((count = in.read(bs, 0, bs.length)) != -1) {
                //把读取到的字节流写入到目的地址的文件里面
                out.write(bs, 0, count);
            }
            //刷新下输出流
            out.flush();
            // 关闭输入流和输出流
            out.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加水印
     *
     * @param filepath [文件路径]
     * @param data     [水印文字内容]
     */
    public static void addWatermark(String filepath, String data) {

        Document pdfDocument = new Document(filepath);
        TextStamp textStamp = new TextStamp(data);
        textStamp.setBackground(true);
        textStamp.setXIndent(100);
        textStamp.setYIndent(100);
        textStamp.setRotateAngle(50);

        textStamp.getTextState().setFont(FontRepository.findFont("Arial"));
        textStamp.getTextState().setFontSize(34.0F);
        textStamp.getTextState().setFontStyle(FontStyles.Italic);
//        textStamp.getTextState().setForegroundColor(Color.getLightGray());

        TextStamp textStamp1 = new TextStamp(data);
        textStamp1.setBackground(true);
        textStamp1.setXIndent(300);//设置位置
        textStamp1.setYIndent(300);
        textStamp1.setRotateAngle(50);//设置旋转角度
        textStamp1.getTextState().setFont(FontRepository.findFont("Arial"));
        textStamp1.getTextState().setFontSize(34.0F);//设置字体大小
        textStamp1.getTextState().setFontStyle(FontStyles.Italic);
//        textStamp1.getTextState().setForegroundColor(Color.LIGHT_GRAY);//设置字体颜色

        TextStamp textStamp2 = new TextStamp(data);
        textStamp2.setBackground(true);
        textStamp2.setXIndent(500);
        textStamp2.setYIndent(500);
        textStamp2.setRotateAngle(50);
        textStamp2.getTextState().setFont(FontRepository.findFont("Arial"));
        textStamp2.getTextState().setFontSize(34.0F);
        textStamp2.getTextState().setFontStyle(FontStyles.Italic);
//        textStamp2.getTextState().setForegroundColor(Color.getLightGray());


        PageCollection pages = pdfDocument.getPages();
        int size = pages.size();
        for (int i = 1; i <= size; i++) {
            pages.get_Item(i).addStamp(textStamp);
            pages.get_Item(i).addStamp(textStamp1);
            pages.get_Item(i).addStamp(textStamp2);
        }
        pdfDocument.save(filepath);
    }

}