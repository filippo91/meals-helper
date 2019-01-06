set -e

# 1. login into docker registry
echo "$DOCKER_REGISTRY_PASSWORD" | docker login -u "$DOCKER_REGISTRY_USERNAME" --password-stdin

# 2. tag with git hash
docker tag $DOCKER_REGISTRY_USERNAME/$DOCKER_IMAGE_NAME:latest $DOCKER_REGISTRY_USERNAME/$DOCKER_IMAGE_NAME:$TRAVIS_COMMIT

# 3. push image to docker registry
docker push $DOCKER_REGISTRY_USERNAME/$DOCKER_IMAGE_NAME:$TRAVIS_COMMIT
