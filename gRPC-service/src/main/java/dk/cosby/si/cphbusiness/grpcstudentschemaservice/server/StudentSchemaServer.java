package dk.cosby.si.cphbusiness.grpcstudentschemaservice.server;


import dk.cosby.si.cphbusiness.grpcstudentschemaservice.GetSchemaRequest;
import dk.cosby.si.cphbusiness.grpcstudentschemaservice.GetSchemaResponse;
import dk.cosby.si.cphbusiness.grpcstudentschemaservice.Schema;
import dk.cosby.si.cphbusiness.grpcstudentschemaservice.SchemaServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class StudentSchemaServer {

    static public void main(String [] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8000)
                .addService(new GreetingServiceImpl()).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }

    public static class GreetingServiceImpl extends SchemaServiceGrpc.SchemaServiceImplBase {
        @Override
        public void getSchema(GetSchemaRequest request, StreamObserver<GetSchemaResponse> responseObserver) {
            System.out.println(request);

            String greeting = "Hello there, " + request.getStudentId();

            class pretendData {
                static String[] courseName = {"Religion", "Math"};
                static String[] teacherFirstname = {"John", "Havana"};
                static String[] teacherLastname = {"Doe", "Fantalition the 3rd"};
                static int[] classroomNumber = {32, 55};
            }

            //GetSchemaResponse response = GetSchemaResponse.newBuilder().setClasses(greeting).build();

            GetSchemaResponse response = GetSchemaResponse.newBuilder()
                                                            .addClasses(Schema.newBuilder()
                                                                 .setCourseName(pretendData.courseName[0])
                                                                 .setTeacherFirstname(pretendData.teacherFirstname[0])
                                                                 .setTeacherLastname(pretendData.teacherLastname[0])
                                                                 .setClassroomNumber(pretendData.classroomNumber[0]))
                                                            .addClasses(Schema.newBuilder()
                                                                    .setCourseName(pretendData.courseName[1])
                                                                    .setTeacherFirstname(pretendData.teacherFirstname[1])
                                                                    .setTeacherLastname(pretendData.teacherLastname[1])
                                                                    .setClassroomNumber(pretendData.classroomNumber[1]))
                                                            .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

}


