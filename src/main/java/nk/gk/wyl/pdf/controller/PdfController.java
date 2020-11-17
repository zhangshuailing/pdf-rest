package nk.gk.wyl.pdf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nk.gk.wyl.pdf.api.PdfService;
import nk.gk.wyl.pdf.entitty.result.Response;
import nk.gk.wyl.pdf.util.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/pdf")
@Api(tags = "pdf接口")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @PostMapping(value = "uploadTxt",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ApiOperation(value = "pdf文件上传返回文本")
    public @ResponseBody
    Response uploadTxt(MultipartFile file){
        try {
            CommonValidator.checkFile(file);
            return new Response().success(pdfService.getTxtByPdf(file));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response().error(e.getMessage());
        }
    }
}
