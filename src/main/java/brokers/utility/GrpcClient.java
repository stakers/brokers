package brokers.utility;

import java.util.concurrent.TimeUnit;
 

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8683)
            .usePlaintext(true)
            .build(); 
 
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}