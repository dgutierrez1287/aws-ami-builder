#
# Dockerfile for the app container for the
# ami-builder app
#

FROM centos:7
MAINTAINER Diego Gutierrez <dgutierrez1287@gmail.com>

# groovy version
ARG GROOVY_VERSION="2.4.7"
ENV GROOVY_VERSION ${GROOVY_VERSION}

# ami-builder version
ARG AMI_BUILDER_VERSION="0.1.0"
ENV AMI_BUILDER_VERSION ${AMI_BUILDER_VERSION}

# install tools
RUN yum install -y wget unzip && \
    yum clean all

# install JDK
RUN wget --quiet --no-cookies --no-check-certificate --header \
    "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" \
    "http://download.oracle.com/otn-pub/java/jdk/8u112-b15/jdk-8u112-linux-x64.rpm" && \
    rpm -ivh jdk-8u112-linux-x64.rpm && \
    echo "JAVA_HOME=/usr/java/latest" > /etc/profile.d/java.sh && \
    rm -f jdk-8u112-linux-x64.rpm

# install groovy
RUN wget --quiet https://dl.bintray.com/groovy/maven/apache-groovy-sdk-${GROOVY_VERSION}.zip && \
    unzip apache-groovy-sdk-${GROOVY_VERSION}.zip -d /opt && \
    ln -s /opt/groovy-${GROOVY_VERSION}/bin/groovy /usr/bin/groovy && \
    ln -s /opt/groovy-${GROOVY_VERSION}/bin/grape /usr/bin/grape && \
    ln -s /opt/groovy-${GROOVY_VERSION}/bin/groovyc /usr/bin/groovyc && \
    ln -s /opt/groovy-${GROOVY_VERSION}/bin/groovysh /usr/bin/groovysh && \
    echo "GROOVY_HOME=/opt/groovy-${GROOVY_VERSION}" > /etc/profile.d/groovy.sh && \
    rm -f apache-groovy-sdk-${GROOVY_VERSION}.zip

# create directory for jar since you cant volume mount a file
RUN mkdir /root/ami-builder

# copy the jar into the docker image for final build
COPY build/libs/ami-builder-${AMI_BUILDER_VERSION}.jar /root/ami-builder/ami-builder-${AMI_BUILDER_VERSION}.jar
WORKDIR /root/ami-builder

# env variables for runtime configuration
ENV ENVRIONMENT local
ENV AWS_ACCESS_KEY unset
ENV AWS_SECRET_KEY unset

# volume mount to mount jar in dev
VOLUME /root/ami-builder

# volume mount to mount logs
VOLUME /root/logs

# expose port
EXPOSE 8080

# Copy entrypoint script and set EntryPoint
COPY docker_resources/app/entrypoint.sh /root/entrypoint.sh
ENTRYPOINT ["/root/entrypoint.sh"]

