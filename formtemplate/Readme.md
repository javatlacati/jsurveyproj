Class diagram

![class diagram](backend spring boot class diagram.png)

    docker run -p 8081:8081 formtemplate:0.0.1-SNAPSHOT


## configuracion de base de datos

    docker run --name templates_mongo --network redPlantillasBE -d mongodb/mongodb-community-server:6.0-ubi8

esto expondra a la red de docker en la url

    redPlantillasBE://templates_mongo:27017

ejemplo de como pasar la cadena de conexion:

    docker run -d --name MYAPP -e MONGODB_CONNSTRING=mongodb+srv://username:password@clusterURL MYAPP:1.0

[//]: # (you can build the image by running)

[//]: # ()
[//]: # (`docker build -t formtemplate .`)

[//]: # ()
[//]: # (and then start the container by running)

[//]: # ()
[//]: # (`docker run -p 8081:8081 formtemplate`)