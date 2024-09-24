# Fabric8App (Spring Boot project)
This repository contain project:
- associated to Docker and Jenkins;
- include fabric8 plugin (image will be created through maven);
- flow: app -> GitHub -> Jenkins -> Dockerhub;


### context of app:
* java project were created;
* pushed to GitHub (and by updates also);
* build triggers (through Poll SCM Schedule)
* Jenkins (job based on Jenkinsfile: pipeline project)
* Dockerhub has a repository with pushed versions of app from Jenkins;

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

/0/how to implement compose up (for user to act)

/1/also wanted to implement h2-in-memory or mysql for testing app separately from main database

/2/and how to use jenkins tools in flow? (assume we want to have the latest image with completed/workable app for pulling from remote)




