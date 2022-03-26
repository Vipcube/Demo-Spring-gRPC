package org.vipcube.spring.grpc.client.config;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;
import org.vipcube.spring.grpc.client.interceptor.LogGrpcInterceptor;

@Configuration
public class GlobalClientInterceptorConfiguration {
	@GrpcGlobalClientInterceptor
	public LogGrpcInterceptor logClientInterceptor() {
		return new LogGrpcInterceptor();
	}
}
