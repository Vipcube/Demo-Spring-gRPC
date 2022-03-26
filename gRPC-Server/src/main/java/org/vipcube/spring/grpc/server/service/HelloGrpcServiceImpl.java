package org.vipcube.spring.grpc.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.vipcube.spring.grpc.core.HelloReply;
import org.vipcube.spring.grpc.core.HelloRequest;
import org.vipcube.spring.grpc.core.HelloServiceGrpc;

@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
	// Normally will override bindService, but in spring, this way will bypass spring security.
	@Override
	public void sayHello( HelloRequest request, StreamObserver<HelloReply> responseObserver ) {
		HelloReply reply = HelloReply.newBuilder()
				.setMessage( "Hello ==> " + request.getName())
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
