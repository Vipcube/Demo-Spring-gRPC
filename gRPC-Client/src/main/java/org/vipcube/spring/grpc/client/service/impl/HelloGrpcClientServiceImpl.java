package org.vipcube.spring.grpc.client.service.impl;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.vipcube.spring.grpc.client.service.IHelloGrpcClientService;
import org.vipcube.spring.grpc.core.HelloReply;
import org.vipcube.spring.grpc.core.HelloRequest;
import org.vipcube.spring.grpc.core.HelloServiceGrpc;

@Slf4j
@Service
public class HelloGrpcClientServiceImpl implements IHelloGrpcClientService {
	@GrpcClient( "simple-grpc-server" )
	private HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

	@GrpcClient( "simple-grpc-server" )
	private HelloServiceGrpc.HelloServiceStub stub;

	@Override
	public String sayHello( String name ) {
		HelloRequest request = HelloRequest.newBuilder()
				.setName( name )
				.build();
		return this.blockingStub.sayHello( request )
				.getMessage();
	}

	@Override
	public void keepSayHello( String name ) {
		HelloRequest request = HelloRequest.newBuilder()
				.setName( name )
				.build();
		this.stub.keepSayHello( request, new StreamObserver<>() {
			@Override
			public void onNext( HelloReply helloReply ) {
				System.out.println( helloReply.getMessage() );
			}

			@Override
			public void onError( Throwable throwable ) {

			}

			@Override
			public void onCompleted() {
				log.info( "Server finished data." );
			}
		} );
	}
}
