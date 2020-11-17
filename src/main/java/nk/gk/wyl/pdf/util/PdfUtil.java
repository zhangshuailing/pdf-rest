package nk.gk.wyl.pdf.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

public class PdfUtil {
    public static void main(String[] args) {

        String path = "F:\\zsl\\测试文档\\1212.pdf";
        File file = new File(path);
        try {
            System.out.println(getTxtByPdf(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * pdf 文件转文本
     * @param inputStream
     * @return
     */
    public static String getTxtByPdf(InputStream inputStream){
        String value = "";
        // 编码方式
        String encoding = "UTF-8";
        PDDocument document = null;
        try {
            document = PDDocument.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFTextStripper stripper = null;
        try {
            stripper = new PDFTextStripper();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            value = stripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(document!=null){
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
