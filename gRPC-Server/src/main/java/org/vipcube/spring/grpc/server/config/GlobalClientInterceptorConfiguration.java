package org.vipcube.spring.grpc.server.config;

import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.vipcube.spring.grpc.server.interceptor.LogGrpcInterceptor;

@Configuration
public class GlobalClientInterceptorConfiguration {
	@GrpcGlobalServerInterceptor
	public LogGrpcInterceptor logGrpcInterceptor() {
		return new LogGrpcInterceptor();
	}
}
