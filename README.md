# System Integration 
## Mini Project 1: Web services and APIs

Create a school management system

### RESTful API
The RESTful-api should be responsible for:
Handeling students, teachers, assignments and courses. 
Due to time being an important factor in this project, only a simple API for 
handling students is implemented. 

#### To run
- Clone this repository
- Navigate to ```src/main/java/dk/cosby/cph/si/studentmicroservice/StudentMicroserviceApplication.java``` in the rest-service module.
- Install maven dependencies for this module
- Run the class ```StudentMicroserviceApplication.java```

#### To test
You can use either the browser, postman, insomnia etc... 
##### Endpoints
| Method | Endpoint | Action |
|--------|----------|--------|
| GET   |   localhost:8070/students/all | Returns a list of all the students in the database |
| GET   |   localhost:8070/students/{id}| Returns the student with the respective id or a bad response code |
| POST  |   localhost:8070/students/    | Request body must include student object as JSON (see below) and appropriate headers, returns 201 (Created) if request is good |
| PUT   |   localhost:8070/students/{id}| Request body must contain field from student which should be updated. See avaiable fiendls underneath.
| DELETE|   localhost:8070/students/{id}| Deletes the student with the respective id or a bad response code |

```
// Request Body example for POST (Create) method
{ 
  "name": "student name",
  "mail": "studentmail@gmail.com",
  "date_of_birth": "1960-10-05T03:02:19.943+00:00",
  "average_grade": "12/A"
}
```
### gRPC service
The gRPC service is responsible for providing schemas for students.

#### To Run
- Clone this repository
- Navigate to ```src/main/java/dk/cosby/si/cphbusiness/grpcstudentschemaservice/server/StudentSchemaServer.java``` in the gRPC-service module.
- Install maven dependencies for this module
- Run the class ```StudentSchemaServer.java```

#### To test
EITHER
1. For this purpose you can either use the programmed client located in ```src/main/java/dk/cosby/si/cphbusiness/grpcstudentschemaservice/client/StudentSchemaClient.java``` 
then run the class ```StudentSchemaClient.java```
<br>**OBS: Make sure the server is running before running the client application**

OR 

2. Connect to the service using BloomRPC __(can be downloaded here: https://github.com/uw-labs/bloomrpc/releases)__. 
- Open bloomRPC
- Click on the "plus" to add new protofile
- Navigate to ```src/main/proto/StudentSchema.proto``` using the file-picker
- Click add and try the methods available.

### SOAP Service
The SOAP service is responsible for checking School books ISBN numbers to check that they are valid copies of the book. This service is for now only consumed, and therefore not available at a server, but it can still be tested locally (see "To Run and Test" below)

#### To run and Test
- Clone this repository
- Navigate to ```src/main/java/example/ISBNNumberClient.java``` in the SOAP-service module.
- Run the class ```ISBNNumberClient.java```

#### Troubleshoot
- It might be nessesary to right-click on the SOAP-service module and select "add framework"
- Then choose "Web services client"
- Select version "Apache Axis" and make sure to select "Download"
- Click next, you will be prompted for "URL" etc.. But there is no need for setting up a WSDL path, it's just because intelliJ seems to forget that the framework is already added to the module. 
- Now just click cancel and continue from step three in "To run and Test"


### Participants
Anders Jacobsen, Dmitro Karaush



