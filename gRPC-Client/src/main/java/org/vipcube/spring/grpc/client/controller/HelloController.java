package org.vipcube.spring.grpc.client.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> sayHello( @RequestParam( defaultValue = "Tom" ) String name ){
		return ResponseEntity.ok( this.helloGrpcClientService.sayHello( name ) );
	}

	@GetMapping( value = "/keep-hello", produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<?> keepSayHello( @RequestParam( defaultValue = "Tom" ) String name ){
		this.helloGrpcClientService.keepSayHello( name );
		return ResponseEntity.ok().build();
	}
}
