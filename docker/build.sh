cd ..
TAG=${1-latest}
gradle assemble
docker build -t yaalexf/tags:$TAG -f docker/Dockerfile .
docker push yaalexf/tags:$TAG
cd -