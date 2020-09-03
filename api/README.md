# API Server

## Developement

```shell
# Start server on http://localhost:8080 with automatic java hotreload
./mvnw quarkus:dev
```

## Build

```shell
# Build uber jar
./mvnw clean package
# Build Docker Image ({user}/nos-stats)
./mvnw clean package -Dquarkus.container-image.build=true
```
