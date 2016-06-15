import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangyong on 2016/6/15.
 */
public class LogbackDemo {

    private static final Logger LOG = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        LOG.trace("Hello World!");
        LOG.debug("How are you today?");
        LOG.info("I am fine.");
        LOG.warn("I love programming.");
        LOG.error("I am programming.");
    }
}
