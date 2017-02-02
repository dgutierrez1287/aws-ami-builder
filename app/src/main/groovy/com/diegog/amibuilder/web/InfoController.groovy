package com.diegog.amibuilder.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController;

import com.diegog.amibuilder.util.AppInfo

/**
 * Author: dgutierrez
 * This controller will act as a information endpoint
 */
@Configuration
@RestController
@RequestMapping("/api/info")
class InfoController {

    @Value('${info.build.version}')
    private String appVersion

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody AppInfo index() {
        return new AppInfo(appVersion)
    }
}
