package woopaca.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import woopaca.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public LogDemoController(LogDemoService logDemoService, ObjectProvider<MyLogger> myLoggerProvider) {
        this.logDemoService = logDemoService;
        this.myLoggerProvider = myLoggerProvider;
    }

    @RequestMapping("/log-demo")
    @ResponseBody // 문자 그대로 응답
    // Java에서 제공하는 표준 servlet 규약에 의한 요청을 받을 수 있다.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString(); // 클라이언트가 요청한 URL
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
