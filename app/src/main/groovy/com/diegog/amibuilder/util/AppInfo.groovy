package com.diegog.amibuilder.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * Author: dgutierrez
 * Representation of the app info
 */
class AppInfo {

    private String appVersion
    private String appName
    private String appDescription

    public AppInfo(String version) {

        this.appVersion = version
        this.appName = "ami-builder"
        this.appDescription = "Builds and manages AWS AMIs"
    }

    String getAppVersion() {
        return appVersion
    }

    void setAppVersion(String appVersion) {
        this.appVersion = appVersion
    }

    String getAppName() {
        return appName
    }

    void setAppName(String appName) {
        this.appName = appName
    }

    String getAppDescription() {
        return appDescription
    }

    void setAppDescription(String appDescription) {
        this.appDescription = appDescription
    }
}
