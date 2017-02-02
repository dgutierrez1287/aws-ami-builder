package com.diegog.amibuilder.web

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController;

import com.diegog.amibuilder.util.AppHealthCheck

/**
 * Author: dgutierrez
 * This controller will act as a healthcheck endpoint
 */
@RestController
@RequestMapping("/api/healthcheck")
class HealthController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody AppHealthCheck index() {
        return new AppHealthCheck()
    }
}
