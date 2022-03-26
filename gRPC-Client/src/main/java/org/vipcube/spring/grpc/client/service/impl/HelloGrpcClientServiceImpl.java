package org.vipcube.spring.grpc.client.service.impl;

import org.springframework.stereotype.Service;
import org.vipcube.spring.grpc.client.service.IHelloGrpcClientService;
import org.vipcube.spring.grpc.core.HelloRequest;
import org.vipcube.spring.grpc.core.HelloServiceGrpc;

@Service
public class HelloGrpcClientServiceImpl implements IHelloGrpcClientService {
	private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

	public HelloGrpcClientServiceImpl( HelloServiceGrpc.HelloServiceBlockingStub blockingStub ) {
		this.blockingStub = blockingStub;
	}

	@Override
	public String sayHello( String name ) {
		HelloRequest request = HelloRequest.newBuilder()
				.setName( name )
				.build();
		return this.blockingStub.sayHello( request )
				.getMessage();
	}
}
