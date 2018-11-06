FROM openjdk:8-jre
MAINTAINER TBME Labs <info@tbmelabs.ch>

ENTRYPOINT ["/usr/bin/java", "-jar", "/home/gateway/gateway.jar"]

ARG JAR_FILE
ADD target/${JAR_FILE} /home/gateway/gateway.jar

RUN useradd -ms /bin/bash gateway
RUN chown gateway /home/gateway/gateway.jar

EXPOSE 8080

USER gateway
WORKDIR /home/gateway
