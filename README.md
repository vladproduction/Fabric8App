# Spring Boot and Docker
**This repository contain project for fabric8 plugin**
### description:
    * Spring Boot app;
    * Dockerfile;
    * DockerHub;
    * plugin io.fabric8;
    * image will be created through maven;
    * image will be pushed to DockerHub;

### steps to  run [Fabric8App]:[http://localhost:8089/api/products] :
1. local app: 
    * -->start application
    * -->follow link (postman in action... crud endpoints by controller)

2. local docker image: 
   * -->docker desktop is started 
   * -->open bash in a root of project
   * -->mvn -version
   * -->mvn clean package docker:build
   * -->docker image ls
   * -->docker compose up (assume docker-compose.yml is correct configured)
   * -->follow link (postman in action... crud endpoints by controller)

3. pushing to dockerhub remote (and pull for wanted to run):
   * -->open bash in a root of project
   * -->mvn clean package docker:build docker:push (assume credentials for dockerhub is covered)
   * -->check remote repository for just created image 
   * //if wanted to start: 
   * -->docker pull vladbogdadocker/fabric8app:latest
   * --> todo (how to implement compose up)
   * --> link to swagger (to imitate working app using OpenAPI - Swagger)


//on which step we pushing app to github?
//and how to use jenkins tools in flow? (assume we want to have the latest image with completed/workable app for pulling from remote)
//also wanted to implement h2-in-memory or mysql for testing app separately from main database 
//update partially(through mapstruct (does not work partially))


