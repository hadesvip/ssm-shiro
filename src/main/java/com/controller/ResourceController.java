package com.controller;

import com.bean.Resource;
import com.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2016/7/14.
 */
@RestController
public class ResourceController {

    private final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    @RequestMapping("/resources")
    public HttpResult<Resource> resources() {
        LOGGER.info("[resources request]");

        HttpResult<Resource> result = HttpResult.fail();


        return result;
    }

}
