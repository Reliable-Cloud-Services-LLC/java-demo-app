# Java-Demo-App

Simple overview of use/purpose.

## Description

The java code to build this app is refrenced from https://github.com/spring-projects/spring-petclinic/blob/main/readme.md

The aim of this project is to use the following java code- create a docker image using it-push to an ECR Repo

After we create an ECR repo, VPC and EKS cluster using Terraform to help aid automate these proccess. We will put all of this into a jenkins pipeline to fully automate and deploy these resources to create the java app.


##  Running the code locally
To run this code locally first create a docker image using the DockerFile that is provided.
To build the docker image run this command
docker build -t java-app
Next we create the ECR repo and push docker image to ECR\
1.) cd ecr\
2.) terraform init\
3.)terraform plan\
4.) terraform apply\

5.) Log into console and go to the ECR repo\
6.) Get the commands to login, tag and push to the repo\
7.) put the commands into terminal

### Creating the VPC and EKS cluster for (local use)
1.)cd other\
2.)terraform init\
3.)terraform plan\
4.)terraform apply\
 Get the url from the output and the java app should appear



### Automating and running on a Jenkins pipeline

To do this follow the following steps

  Log into Jenkins\
 create a new pipeline project\
USE SCM and git to run the pipeline\
paste the git repo https://github.com/Reliable-Cloud-Services-LLC/java-demo-app.git\
 change master to main\

path is Jenkinsfile\
 create \
 build the pipeline

### Stages of the PipeLine Details
Git CheckOut Stage
this stage checks out the code from the github and cd into ecr
Terraform init for ECR, Terraform plan for ECR, Terraform apply for ECR
creates the ECR repo


