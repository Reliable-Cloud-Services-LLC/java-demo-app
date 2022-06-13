# java-demo-app
**Java Demo App**
The java code to build this app is refrenced from https://github.com/spring-projects/spring-petclinic/blob/main/readme.md

The aim of this project is to use the following java code- create a docker image using it-push to an ECR Repo

After we create an ECR repo, VPC and EKS cluster using Terraform to help aid automate these proccess. We will put all of this into a jenkins pipeline to fully automate and deploy these resources to create the java app.

---
# Running the code locally
To run this code locally first create a docker image using the DockerFile that is provided. 
**To build the docker image run this command**
docker build -t java-app

**Next we create the ECR repo and push docker image to ECR**
1.) cd ecr
2.) terraform init
3.)terraform plan
4.) terraform apply
5.) Log into console and go to the ECR repo
6.) Get the commands to login, tag and push to the repo
7.) put the commands into terminal
---
**Create VPC and EKS Cluster** 
1.) cd terraformdepolyments
2.)terraform init
3.)terraform plan
4.)terraform apply
** Get the url from the output and the java app should appear**

---
#Automating and running on a Jenkins pipeline
**To do this follow the following steps**

1.) Log into Jenkins
2.) create a new pipeline project
3.) USE SCM and git to run the pipeline
4.) paste the git repo https://github.com/Reliable-Cloud-Services-LLC/java-demo-app.git
5.) change master to main
6.) path is Jenkinsfile
7.) create 
8.) build the pipeline
--- 
#Stages of the pipeline explained in detail
**Git CheckOut Stage**
this stage checks out the code from the github and cd into ecr
**Terraform init for ECR, Terraform plan for ECR, Terraform apply for ECR**
creates the ECR repo

**Terraform init for other resources, Terraform plan for other resources, Terraform apply for other resources**
These stages create and deploy the EKS cluster, VPC, EKS- worker nodes- and kubernetes deployment 

**Build image**
Builds the docker image
** image to ecr**
logs into ecr
tags docker image and pushes it to ECR

Get the output given in the load balancer and paste the link into your browser so you are able to see the java application
