package org.vipcube.spring.grpc.client.service.impl;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.vipcube.spring.grpc.client.service.IHelloGrpcClientService;
import org.vipcube.spring.grpc.core.HelloRequest;
import org.vipcube.spring.grpc.core.HelloServiceGrpc;

@Service
public class HelloGrpcClientServiceImpl implements IHelloGrpcClientService {
	@GrpcClient( "simple-grpc-server" )
	private HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

	@Override
	public String sayHello( String name ) {
		HelloRequest request = HelloRequest.newBuilder()
				.setName( name )
				.build();
		return this.blockingStub.sayHello( request )
				.getMessage();
	}
}
