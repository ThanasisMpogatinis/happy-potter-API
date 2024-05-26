# Happy Potter API

This API is the backend implementation of the Happy Potter project using Java17 with Spring Boot 3.2.5 integrated with Firebase.

## Installation

In order to run the API, the system must have JDK 17 and correctly environment variables setted. Then inside the projects directory run:

```bash
./mvnw clean package
```

This will create a .jar file with the name of its latest version. To start the API, run:

```bash
 java -jar your_jar_name.jar
```

## Set up
* To change API's default port (8082) navigate to src -> main -> resources -> application.properties and change the value to your desired port.
```bash
 server.port=8082
```

* To change the Firebase's authentication .json file navigate to src -> main -> resources -> application.properties and change the value to your desired path.
```bash
 firebase.authentication.json.path=_path_to_json
```

## Steps
#### 1. Create a User
First thing we must create a User. To do it we need to send a create request to
```bash
 [POST] localhost:8082/api/v1/user/create
```
with data (fow now)
```bash
 {
    "username": "a_username",
    "email": "an_email@email.com"
 }
```
This will create a new entry in Firebase under **USER_DETAILS** collection.

#### 2. Add a Plant (device) to the User.
Then we are able to connect Plants (devices) with the created user.
```bash
 [POST] localhost:8082/api/v1/plant/add
```
with the information
```bash
{
    "userID": "76b0702c-0a4d-403f-8f2a-91850e200fa7",
    "macID": "100:200:303"
}
```
where *userID* is the previous created document's id and *macID* the device's mac. This will update the User's Object under **USER_DETAILS** collection.

#### 3. Add Metrics.
As final step, we can add Metrics to our system.
```bash
 [POST] localhost:8082/api/v1/metric/add
```
with the information (temp values)
```bash
{
    "macID": "100:200:300",
    "soilMoisture": 30.4,
    "brightness": 10.2,
    "humidity": 31.2,
    "temperature": 10.0
}
```
with *macID* the device's mac.

This will create a new entry in **METRICS** collection. This will also update the User's Plant (with the same macID) and will have as its *latestMetric* the values we just added.

#### 4. Get UserDetails.
In order to get the user's details we can
```bash
 [GET] localhost:8082/api/v1/user?id=_users_id_
```

## Swagger
Navigate to
```bash
 http://localhost:8082/swagger-ui/index.html#/
```
to check the API's endpoints and schemas