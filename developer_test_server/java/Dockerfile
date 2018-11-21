FROM openjdk:11

# install maven
RUN ["apt-get", "update"]
RUN ["apt-get", "install", "--yes", "maven"]

WORKDIR /developer_test_server
ADD pom.xml /developer_test_server/pom.xml

# download maven dependencies
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /developer_test_server/src
RUN ["mvn", "package"]

EXPOSE 4567
CMD ["java", "-version"]
