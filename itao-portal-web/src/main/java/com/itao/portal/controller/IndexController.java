package com.itao.portal.controller;

import com.itao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String index(Model model){
        String adJson = contentService.getContentList();
        model.addAttribute("ad1", adJson);
        return "index";
    }
}