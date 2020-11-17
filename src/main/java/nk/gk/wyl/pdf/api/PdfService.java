package nk.gk.wyl.pdf.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface PdfService {
    /**
     * 根据pdf 文件获取文本
     * @param file
     * @return
     * @throws Exception
     */
    String getTxtByPdf(MultipartFile file) throws Exception;

    /**
     * 根据文件流获取文本
     * @param inputStream 文件流
     * @return
     * @throws Exception
     */
    String getTxtByPdf(InputStream inputStream) throws Exception;
}
