# dmp

## data-science

### Installation

Please execute the following commands in the directory *data-science* to build the docker image for the data-science web application:

```
mvn clean install
```

```
docker build . -t datascience-web
```

To start the docker image execute the following command:

```
docker run -d -p 8080:8080 datascience-web
```