FROM ubuntu


# Install java
RUN \
  apt-get update && \
  apt-get install -y software-properties-common && \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Install mongodb
RUN \
  apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10 && \
  echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' > /etc/apt/sources.list.d/mongodb.list && \
  apt-get update && \
  apt-get install -y mongodb-org && \
  rm -rf /var/lib/apt/lists/*
RUN mkdir -p /data/db
RUN mkdir -p /app

COPY ["./start.sh", "/app/start.sh"]
COPY ["./datascience-importer.jar", "/app/datascience-importer.jar"]
COPY ["./datascience-web.jar", "/app/datascience-web.jar"]

RUN chmod ug+x /app/start.sh

ENTRYPOINT ["/app/start.sh"]