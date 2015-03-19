package com.project.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by mcmahok8 on 30/12/2014.
 */

@Controller
class RootController {
    @RequestMapping("/")
    @ResponseBody
    def home() {
        return "Hello World!";
    }
}
