pipeline{
    agent any 
tools {
  terraform 'terraform'
}


stages{
  
stage('Git CheckOut'){
    steps{
       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '41a3bb58-a939-4859-a8b3-4cab0fbd2382', url: 'https://github.com/Reliable-Cloud-Services-LLC/java-demo-app.git']]])
    sh 'cd other'
    }
}
stage('Terraform init for other resources '){
    steps{
         sh '''cd other
         terraform init'''
    }
}
stage('Terraform plan for other resources'){
steps{
    sh ''' cd other
terraform plan'''
}
}

stage(' second Git CheckOut'){
    steps{
       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '41a3bb58-a939-4859-a8b3-4cab0fbd2382', url: 'https://github.com/Reliable-Cloud-Services-LLC/java-demo-app.git']]])
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

stage('Build image'){
    steps{
        script{
          
            app = docker.build("reliable-cloud-services-llc/java-demo-app")
           
        }
    }
}
stage('image to ECR'){
    steps{
        sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 202467142321.dkr.ecr.us-east-1.amazonaws.com'
       sh 'docker tag reliable-cloud-services-llc/java-demo-app 202467142321.dkr.ecr.us-east-1.amazonaws.com/mrdarr/demo-repo:latest' 
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

sh '''cd other
terraform apply --auto-approve'''
}
}
}
}
