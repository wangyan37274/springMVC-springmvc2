package com.wangyan.springmvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

/**
 * @Auther: wangyan
 * @Date: 2019/2/12
 * @Description: com.wangyan.springmvc.test
 * @version: 1.0
 */
@Controller
public class springMVCtest {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String val = messageSource.getMessage("i18n.user",null,locale);
        System.out.println(val);
        return "i18n";
    }

    /**
     * 文件上传
     */
    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("desc:"+ desc);
        System.out.println("OriginalFilename:"+ file.getOriginalFilename());
        System.out.println("InputStream:"+ file.getInputStream());
        return "success";
    }
}
