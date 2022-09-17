https://github.com/localstack/localstack

aws --endpoint-url=http://localhost:4566 s3api create-bucket --region=us-east-1 --bucket test-bucket

aws s3 --endpoint-url=http://localhost:4566 --region=us-east-1 cp README.md s3://test-bucket

aws s3 --endpoint-url=http://localhost:4566 --region=us-east-1 cp index.html s3://test-bucket


aws s3 --endpoint-url=http://localhost:4566 --region=us-east-1 ls



aws sqs --endpoint-url=http://localhost:4566 --region=us-east-1 create-queue --queue-name test-queue

http://locahost:8080/s3

http://localhost:8080/sqs

curl -X POST http://localhost:8080/sqs

aws s3 --endpoint-url=http://localhost:4566 --region=us-east-1 cp index.html s3://test-bucket

http://localhost:4566/test-bucket/index.html