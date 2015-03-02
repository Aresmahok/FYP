package controllers

import services.DeweysDad
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import services.DeweysDad

/**
 * Created by mcmahok8 on 30/12/2014.
 */

@Controller
class RootController {
    @Autowired
    DeweysDad deweysDad

    @RequestMapping("/")
    @ResponseBody
    def home() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{version}/didTheWrongKidDie")
    @ResponseBody
    def check(@PathVariable String version, @RequestParam(required = true) String name){

        boolean didTheWrongKidDie = deweysDad.didTheWrongKidDie(name)
        [
                didTheWrongKidDieBool : didTheWrongKidDie
        ]

    }
}
