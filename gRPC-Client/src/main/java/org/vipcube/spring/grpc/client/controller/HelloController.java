package org.vipcube.spring.grpc.client.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vipcube.spring.grpc.client.service.IHelloGrpcClientService;

@RestController
@RequestMapping("/api")
public class HelloController {
	private final IHelloGrpcClientService helloGrpcClientService;

	public HelloController( IHelloGrpcClientService helloGrpcClientService ){
		this.helloGrpcClientService = helloGrpcClientService;
	}

	@GetMapping( value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE )
	public String sayHello( @RequestParam( defaultValue = "Tom" ) String name ){
		return this.helloGrpcClientService.sayHello( name );
	}
}
