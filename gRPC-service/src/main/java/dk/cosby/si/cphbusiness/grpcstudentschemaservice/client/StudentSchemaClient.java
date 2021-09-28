package dk.cosby.si.cphbusiness.grpcstudentschemaservice.client;

import dk.cosby.si.cphbusiness.grpcstudentschemaservice.GetSchemaRequest;
import dk.cosby.si.cphbusiness.grpcstudentschemaservice.GetSchemaResponse;
import dk.cosby.si.cphbusiness.grpcstudentschemaservice.SchemaServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StudentSchemaClient {


        public static void main(String[] args) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
                    .usePlaintext()
                    .build();

            SchemaServiceGrpc.SchemaServiceBlockingStub stub =
                    SchemaServiceGrpc.newBlockingStub(channel);

            GetSchemaResponse schemaResponse = stub.getSchema(
                    GetSchemaRequest.newBuilder()
                                    .setStudentId("UUID-456746-756835-2562456-354")
                                            .build());

            System.out.println(schemaResponse);

            channel.shutdown();
        }

}
