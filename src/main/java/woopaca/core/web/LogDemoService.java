package woopaca.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import woopaca.core.common.MyLogger;

@Service
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public LogDemoService(ObjectProvider<MyLogger> myLoggerProvider) {
        this.myLoggerProvider = myLoggerProvider;
    }

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
