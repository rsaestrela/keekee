package me.estrela.keekee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@CrossOrigin
class KeekeeController() {

    @Autowired
    private lateinit var worker: Worker

    @RequestMapping("/")
    fun index(): String {
        worker.start()
        return "index"
    }

}