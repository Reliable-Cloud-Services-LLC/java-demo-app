data "aws_eks_cluster" "cluster" {
  name = module.eks.cluster_id
}
data "aws_eks_cluster_auth" "cluster" {
  name = module.eks.cluster_id
}

module "eks" {
  source          = "terraform-aws-modules/eks/aws"
  cluster_name    = "java-cluster"
  cluster_version = "1.20"
  vpc_id          = module.vpc.vpc_id
 subnet_ids = module.vpc.private_subnets
  
}

provider "kubernetes" {
  host                   = data.aws_eks_cluster.cluster.endpoint
  cluster_ca_certificate = base64decode(data.aws_eks_cluster.cluster.certificate_authority.0.data)
  token                  = data.aws_eks_cluster_auth.cluster.token

}
resource "null_resource" "java"{
  depends_on = [module.eks]
  provisioner "local-exec" {
    command = "aws eks --region us-east-1  update-kubeconfig --name $AWS_CLUSTER_NAME"
    environment = {
      AWS_CLUSTER_NAME = "java-cluster"
    }
  }
}


