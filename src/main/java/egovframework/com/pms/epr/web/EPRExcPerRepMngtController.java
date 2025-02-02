package egovframework.com.pms.epr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pms/epr")
public class EPRExcPerRepMngtController {
    @GetMapping("/EPRExcPerRepMngt.do")
    public String showExecutionPerformancePage() {
        return "egovframework/com/pms/epr/EPRExcPerRepMngt";
    }
}
