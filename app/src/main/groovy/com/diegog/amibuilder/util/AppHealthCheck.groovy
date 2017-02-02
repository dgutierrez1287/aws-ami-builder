package com.diegog.amibuilder.util

/**
 * Author: dgutierrez
 * Representation of the app healthcheck
 */
class AppHealthCheck {

    private String status

    public AppHealthCheck() {
        status = "UP"
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }
}
