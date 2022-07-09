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

```
 cd ecr
```

```
 terraform init
```

```
terraform plan
```

```
terraform apply
```


Log into console and go to the ECR repo\

Get the commands to login, tag and push to the repo\

 put the commands into terminal

### Creating the VPC and EKS cluster for (local use)

```
cd other
```

```
terraform init
```

```
terraform plan
```

```
terraform apply
```

Get the url from the output and the java app should appear



### Automating and running on a Jenkins pipeline

To do this follow the following steps

  Log into Jenkins\
 create a new pipeline project\
USE SCM and git to run the pipeline\
paste the git repo https://github.com/Reliable-Cloud-Services-LLC/java-demo-app.git\
 change master to main

path is Jenkinsfile\
 create \
 build the pipeline

### Stages of the PipeLine Details
Git CheckOut Stage
this stage checks out the code from the github and cd into ecr\

Terraform init for ECR, Terraform plan for ECR, Terraform apply for ECR
creates the ECR repo\

Terraform init for other, Terraform plan for other, Terraform apply for other
creates resources in the EKS module provided\
Along with a VPC, and EKS cluster with worker nodes\

### To check if Kubernetes is successfully deployed and to get the URL

```
ssh ec2-user@<ip of ec2 instance> -i <key pair>
```

```
aws eks --region us-east-1 update-kubeconfig --name java-cluster
```

```
kubectl get svc
```

```
kubectl get pods
```

```
kubectl get deployments
```
Once you are able to retrieve the URL paste it in a web browser and add /questions at the end

### (Optional) Rancher Installation

```
cd rancher
```

```
cd aws
```
In the terraform.tfvars file you are required to provide aws credentials and a password for Rancher to deploy. You have the option to edit these files before deployment or enter it after you terraform apply\

```
terraform init
```

```
terraform plan
```

```
terraform apply
```
You will recieve a URL for rancher after the process is complete

### Importing an existing EKS cluster
1. From the Clusters page, Select Add CLuster\
2. Choose import\
3.Enter Cluster Name\
4.Fill out the required fields\
5.Create
