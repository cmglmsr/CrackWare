package com.crackware.erasmus.web.controller;

import com.crackware.erasmus.data.services.helper.ExcelHelper;
import com.crackware.erasmus.data.services.helper.ExcelService;
import com.crackware.erasmus.data.services.helper.SchoolsHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;


@Controller
@RequestMapping("/student/excel")
/**
 * Controller class for handling Excel file and school operations
 */
public class TestController {


    private final ExcelService fileService;

    // Constructor for AdminController class
    public TestController(ExcelService fileService, SchoolsHelper sh) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (ExcelHelper.hasExcelFormat(file)){
                fileService.save(file);
                System.out.println("[+] File upload successful.");
            }
        }catch (Exception e){
            System.out.println("[-] File upload error.");
            System.out.println(e.getMessage());
        }
    }
}
