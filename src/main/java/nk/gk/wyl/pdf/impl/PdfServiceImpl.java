package nk.gk.wyl.pdf.impl;

import nk.gk.wyl.pdf.api.PdfService;
import nk.gk.wyl.pdf.util.PdfUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class PdfServiceImpl implements PdfService {
    /**
     * 根据pdf 文件获取文本
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public String getTxtByPdf(MultipartFile file) throws Exception {
        return getTxtByPdf(file.getInputStream());
    }

    /**
     * 根据文件流获取文本
     *
     * @param inputStream 文件流
     * @return
     * @throws Exception
     */
    @Override
    public String getTxtByPdf(InputStream inputStream) throws Exception {
        return PdfUtil.getTxtByPdf(inputStream);
    }
}
