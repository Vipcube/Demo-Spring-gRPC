# Demo-Spring-gRPC

## Overview

This project let me know how to use in gRPC with Spring Boot.

There modules show as below:

- `gRPC-Domain` - The gRPC protobuf definition with domain.
- `gRPC-Client` - The simple gRPC client with spring boot. 
- `gRPC-Server` - The simple gRPC server with spring boot. 

## Run Applications

1. Startup the server.
2. Startup the client.

## How to test

- Test `Unary` type gRPC with send HTTP to client endpoint:

```shell
curl --location --request GET 'http://localhost:8081/api/hello?name=Tim'
```

- Test `Streaming` type gRPC with send HTTP to client endpoint:

```shell
curl --location --request GET 'http://localhost:8081/api/keep-hello?name=Tim'
```
