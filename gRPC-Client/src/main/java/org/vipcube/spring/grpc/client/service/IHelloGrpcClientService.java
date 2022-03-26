package org.vipcube.spring.grpc.client.service;

public interface IHelloGrpcClientService {
	String sayHello(String name);

	void keepSayHello(String name);
}
