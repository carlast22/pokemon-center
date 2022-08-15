FROM azul/zulu-openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pokemon-center-auth.jar
ENTRYPOINT ["java","-jar","/pokemon-center-auth.jar"]
