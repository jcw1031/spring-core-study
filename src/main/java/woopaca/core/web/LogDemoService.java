package woopaca.core.web;

import org.springframework.stereotype.Service;
import woopaca.core.common.MyLogger;

@Service
public class LogDemoService {

    private final MyLogger myLogger;

    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
