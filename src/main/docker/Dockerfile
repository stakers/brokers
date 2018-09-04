FROM ubuntu:14.04
MAINTAINER javacodegeeks

RUN apt-get update && apt-get install -y python-software-properties software-properties-common
RUN add-apt-repository ppa:webupd8team/java

RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections

RUN apt-get update && apt-get install -y oracle-java8-installer maven

ADD . /usr/local/springboot
RUN cd /usr/local/springboot &&  mvn install
CMD ["java", "-cp", "C:\Users\tiyakubu\Documents\NetBeansProjects\springboot\target\springboot-0.0.1-SNAPSHOT.jar", "SpringBoot"]
