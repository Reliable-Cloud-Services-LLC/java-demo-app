pipeline{
    agent any 
tools {
  terraform 'terraform'
}


stages{
  
stage('Git CheckOut'){
    steps{
       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MrDarr/testingjenkins123.git']]])
        sh 'cd ecr'
    }
}

stage('terraform init for ecr'){
   steps{
   sh '''cd ecr
terraform init'''
}
}

    stage('Terraform plan for ecr'){
        steps{
          sh '''cd ecr
         terraform plan'''
       }
    }

stage('Terraform apply for ecr'){
steps{
    sh '''cd ecr
terraform apply --auto-approve'''
}
}
stage('Terraform init for other resources '){
    steps{
         sh '''cd terraformdeployments
         terraform init'''
    }
}
stage('Terraform plan for other resources'){
steps{
    sh '''cd terraformdeployments
terraform plan'''
}
}
stage('Terraform apply for other resources'){
steps{
    sh '''cd terraformdeployments
terraform apply --auto-approve'''
}
}
stage('Build image'){
    steps{
        script{
          
            app = docker.build("mrdarr/testingjenkins123")
           
        }
    }
}
stage('image to ECR'){
    steps{
        sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 202467142321.dkr.ecr.us-east-1.amazonaws.com'
       sh 'docker tag demo-repo:latest 202467142321.dkr.ecr.us-east-1.amazonaws.com/demo-repo:latest' 
            sh 'docker push 202467142321.dkr.ecr.us-east-1.amazonaws.com/demo-repo:latest'
    }
}

stage('Terraform destroy ECR'){
steps{
sh '''cd ecr
terraform apply --auto-approve'''

}
}

stage('Terraform destroy terraform deployments'){
steps{

sh '''cd terraformdeployments
terraform apply --auto-approve'''
}
}
}
}
