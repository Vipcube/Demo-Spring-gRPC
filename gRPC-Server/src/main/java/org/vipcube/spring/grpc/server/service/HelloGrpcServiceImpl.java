package org.vipcube.spring.grpc.server.service;

import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.vipcube.spring.grpc.core.HelloReply;
import org.vipcube.spring.grpc.core.HelloRequest;
import org.vipcube.spring.grpc.core.HelloServiceGrpc;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@GrpcService
public class HelloGrpcServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
	// Normally will override bindService, but in spring, this way will bypass spring security.
	@Override
	public void sayHello( HelloRequest request, StreamObserver<HelloReply> responseObserver ) {
		HelloReply reply = HelloReply.newBuilder()
				.setMessage( "Hello ==> " + request.getName() )
				.build();
		responseObserver.onNext( reply );
		responseObserver.onCompleted();
	}

	@Override
	public void keepSayHello( HelloRequest request, StreamObserver<HelloReply> responseObserver ) {
		String name = request.getName();
		IntStream.range( 0, 20 )
				.mapToObj( i -> HelloReply.newBuilder()
						.setMessage( "Hello ==> " + name + " ==> Order: " + i )
						.build() )
				.peek( response -> Uninterruptibles.sleepUninterruptibly( 3, TimeUnit.SECONDS ) )
				.forEach( responseObserver::onNext );
		responseObserver.onCompleted();
	}
}
