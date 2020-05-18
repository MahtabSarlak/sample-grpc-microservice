package com.ac.grpc.client;

import com.ac.grpc.HelloRequest;
import com.ac.grpc.HelloResponse;
import com.ac.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GprcRestClient {
    public static String main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());
        System.out.printf("dfkj");
        channel.shutdown();
        return helloResponse.getGreeting();
    }
}
