resource "kubernetes_deployment" "java" {
  metadata {
    name = "microservice-deployment"
    labels = {
      app  = "java-microservice"
    }
  }
spec {
    replicas = 3
selector {
      match_labels = {
        app  = "java-microservice"
      }
    }
template {
      metadata {
        labels = {
          app  = "java-microservice"
        }
      }
spec {
        container {
          image = "202467142321.dkr.ecr.us-east-1.amazonaws.com/reliable-cloud-services-llc/java-demo-app:latest"
          name  = "java-microservice-container"
          port {
            container_port = 8080
         }
        }
      }
    }
  }
 depends_on = [
      aws_eks_node_group.worker-node-group

  ]
}
resource "kubernetes_service" "java" {
  depends_on = [kubernetes_deployment.java]
  metadata {
    name = "java-microservice-service"
  }
  spec {
    selector = {
      app = "java-microservice"
    }
    port {
      port        = 80
      target_port = 8080
    }
type = "LoadBalancer"
}
}
