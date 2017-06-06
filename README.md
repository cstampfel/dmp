# dmp

## data-science

### Installation

Please execute the following command in the directory *data-science* to build the application from source code:

```
mvn clean install
```

Execute the following command in the directory *data-science/build* to build the docker image for the data-science web application:

```
docker build . -t datascience-web
```

To start the docker image execute the following command:

```
docker run -d -p 8080:8080 datascience-web
```