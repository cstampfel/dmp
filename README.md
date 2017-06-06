# dmp

## License

The content is licensed under [Creative Commons License CC BY 3.0 AT](https://creativecommons.org/licenses/by/3.0/at/deed.de)

## data-science

### Installation

Please execute the following command in directory *data-science* to build the application from source code:

```
mvn clean install
```

Execute the following command in directory *data-science/build* to build the docker image for the data-science web application:

```
docker build . -t datascience-web
```

To start the docker image execute the following command:

```
docker run -d -p 8080:8080 datascience-web
```

### Website

You can view the website if you open http://localhost:8080 in your favorite web browser.

## dmp-web

### Installation

Please execute the following command in directory *dmp-web* to build the docker image for the dmp-web application:

```
docker build . -t dmp-web
```

To start the docker image execute the following command in directory *dmp-web*:

```
docker run -d -p 4200:4200 dmp-web
```