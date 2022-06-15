pipeline{
    agent any 
tools {
  terraform 'terraform'
}


stages{
  
stage('Git CheckOut'){
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
       sh 'docker tag reliable-cloud-services-llc/java-demo-app:latest 202467142321.dkr.ecr.us-east-1.amazonaws.com/reliable-cloud-services-llc/java-demo-app:latest' 
            sh 'docker push 202467142321.dkr.ecr.us-east-1.amazonaws.com/reliable-cloud-services-llc/java-demo-app:latest'
    }
}




stage(' second Git CheckOut'){
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
stage('Terraform apply for other resources'){
steps{
    sh '''cd other
terraform apply --auto-approve'''
}
}
stage('Kube login'){
    steps{
        sh 'aws sts get-caller-identity'
        sh 'aws eks --region us-east-1 update-kubeconfig --name java-cluster'
        sh 'kubectl get svc'
    }
}
stage('kube stage terraform init'){
    steps{
        sh '''cd other
cd kube
terraform init
'''
    }
}
stage('kube stage terraform plan'){
    steps{
        sh '''cd other
cd kube
terraform plan
'''
    }
}

stage('kube stage terraform apply'){
    steps{
        sh '''cd other
cd kube
terraform apply --auto-approve
'''
    }
}
}
}
