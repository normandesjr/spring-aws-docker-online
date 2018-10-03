provider "aws" {
  version = "~> 1.38"
  shared_credentials_file = "~/.aws/credentials"
  profile = "terraform"
}