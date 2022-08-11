FROM azul/zulu-openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pokemon-center.jar
ENTRYPOINT ["java","-jar","/pokemon-center.jar"]
