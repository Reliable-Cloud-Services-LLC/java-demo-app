
# AWS access key used to create infrastructure
aws_access_key = ""

# AWS secret key used to create AWS infrastructure
aws_secret_key = ""

# Admin password to use for Rancher server bootstrap, min. 12 characters
rancher_server_admin_password = ""

# Add a windows node to the workload cluster
add_windows_node = false

# AWS region used for all resources
aws_region = "us-east-1"

# AWS session token used to create AWS infrastructure
aws_session_token = ""

# Version of cert-manager to install alongside Rancher (format: 0.0.0)
cert_manager_version = "1.7.1"

# Docker version to install on nodes
docker_version = "19.03"

# Instance type used for all EC2 instances
instance_type = "t3a.medium"

# Prefix added to names of all resources
prefix = "quickstart"

# Kubernetes version to use for Rancher server cluster
rancher_kubernetes_version = "v1.22.9+k3s1"

# Rancher server version (format: v0.0.0)
rancher_version = "2.6.5"

# Instance type used for all EC2 windows instances
windows_instance_type = "t3a.large"

# Kubernetes version to use for managed workload cluster
workload_kubernetes_version = "v1.22.9-rancher1-1"
