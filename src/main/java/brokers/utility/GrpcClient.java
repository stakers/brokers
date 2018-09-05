package brokers.utility;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8683)
            .usePlaintext(true)
            .build(); 
 
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}