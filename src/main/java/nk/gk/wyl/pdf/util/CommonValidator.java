package nk.gk.wyl.pdf.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 参数校验
 * @Author: zhangshuailing
 * @CreateDate: 2020/8/29 9:45
 * @UpdateUser: zhangshuailing
 * @UpdateDate: 2020/8/29 9:45
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CommonValidator {


    /**
     * 校验doc docx
     * @param file 文件
     * @throws Exception 异常信息
     */
    public static String checkFile(MultipartFile file) throws Exception {
        String name = file.getOriginalFilename();

        if(name.lastIndexOf(".")==-1){
            throw new Exception("上传文件格式必须是: pdf");
        }
        String suffix = name.substring(name.lastIndexOf(".")+1,name.length());
        if(!"pdf".equals(suffix.toLowerCase())){
            throw new Exception("上传文件格式必须是: pdf");
        }
        long size = file.getSize();
        if(size==0){
            throw new Exception("上传的文件为空");
        }
        return suffix.toLowerCase();
    }

}
