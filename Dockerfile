FROM maven:3-jdk-8

RUN mkdir -p /opt/app

ADD . /opt/app

WORKDIR /opt/app

RUN mvn clean install -P frontend

EXPOSE 8080

WORKDIR /target

ENTRYPOINT ["java","-jar","/opt/app/target/telegram-bot.jar"]
