FROM openjdk:17
COPY target/01-Mini-project-user-management-0.0.1-SNAPSHOT.jar  /user/app/
WORKDIR  /user/app
ENTRYPOINT ["java", "-jar", "01-Mini-project-user-management-0.0.1-SNAPSHOT.jar"]
