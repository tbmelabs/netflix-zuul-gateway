FROM openjdk:8-jre
MAINTAINER TBME Labs <info@tbmelabs.ch>

ENTRYPOINT ["/usr/bin/java", "-jar", "/home/netflix-zuul-gateway/netflix-zuul-gateway.jar"]

ARG JAR_FILE
ADD target/${JAR_FILE} /home/netflix-zuul-gateway/netflix-zuul-gateway.jar

RUN useradd -ms /bin/bash netflix-zuul-gateway
RUN chown netflix-zuul-gateway /home/netflix-zuul-gateway/netflix-zuul-gateway.jar

EXPOSE 8080

USER netflix-zuul-gateway
WORKDIR /home/netflix-zuul-gateway
