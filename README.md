# Container Shipment Application 📦✈️ * _______* ✈️📦

## Introduction
This repository is used for technical evaluation of interviewee where it requires interviewee to solve the challenges within a given time frame. 

### Required Tools:
To accomplish the task, the following tools are required:

- Java 17
- Maven
- Docker (also docker-compose)
- NPM (NodeJs) version 16+

### Overview of Challenge

Container Shipment Service or in short (CSS) is a service that integrates with other core services of a company through 
a messaging platform (RabbitMQ). The goal of the backend service is to consume shipment data that will be  published 
from the Messaging Platform (RabbitMq) and creates an execution plan from it. For example, it receives a shipment 
with unique id in form of a JSON object, and it creates an execution plan 
for that specific shipment. The below diagram shows an overall architecture of the system.

```
-------------------------                                             ----------------  
|   Messaging Platform  |                                             |              |
|       (RabbitMq)      |<----- listens to new shipment messages -----|    Backend   |
|                       |                                             |              |
-------------------------                                             ----------------
                                                                           ^
                        |-----------------                                 |
                        |                |                                 |
                        |    Frontend    |------- HTTP request/response ----
                        |                |
                        |-----------------
 
```

## Backend Task:

The backend for this project is being developed using Kotlin and Spring Boot. Your task is to create a message listener,
which will allow the backend service to receive new shipments that are published from RabbitMQ.

When you run the `docker-compose.yml` file, it will automatically set up a RabbitMQ server that sends out shipments 
every 5 seconds. To run the `docker-compose` command successfully, you first need to build the docker image which
should be called `rabbitmq-publisher`. You can find the necessary docker file under following directory `/docker/rabbitmq-publisher`.
The shipments that are received from the RabbitMQ server will be in the form of a JSON schema, which will look like the 
example provided. You can find its class object on `/src/main/kotlin/com/kn/containershipment/model/Shipment.kt`

```json
{
    "id": 123,
    "origin": "Frankfurt",
    "destination" : "Hamburg",
    "customerId": "customer1",
    "createdDate": 1672826209,
    "fragile": true,
    "notifyCustomer": true,
    "transportType": AIR,
    "temperature": {
        "min": -20,
        "max": -10
    }
}
```
After receiving those shipment data, your backend service should create an `Execution Plan` object 
by merging the `Shipment` object and `Template` object properties and save it to database of your choice. 
By default, when you run the application, at least one template should be existed. 
The `Template` json schema looks like this:

```json
{
  "id": 999,
  "templateName": "General Shipment Template",
  "actions" : [
    {
      "actionId": 1,
      "actionName": "shipment is taken from customer",
    },
    {
      "actionId": 2,
      "actionName": "shipment is on the way",
    },
    {
      "actionId": 3,
      "actionName": "shipment is arrived to destination",
    },
    {
      "actionId": 4,
      "actionName": "shipment is handover to the destination target",
    }
  ]
}
```
Your final `Execution Plan` object should look like the following object.

```json
{
  "id": 5555,
  "origin": "Frankfurt",
  "destination" : "Hamburg",
  "customerId": "customer1",
  "transportType": AIR,
  "temperature": {
    "id": 1,
    "min": -20,
    "max": -10
  },
  "fragile": true,
  "notifyCustomer": true,
  "templateId": 999,
  "actions": [
    {
      "id": 1,
      "actionName": "shipment is taken from customer",
      "isExecuted": true,
      "isNotify": false
    },
    {
      "id": 2,
      "actionName": "shipment is on the way",
      "isExecuted": true,
      "isNotify": false
    },
    {
      "id": 3,
      "actionName": "shipment is arrived to destination",
      "isExecuted": true,
      "isNotify": false
    },
    {
      "id": 4,
      "actionName": "shipment is handover to the destination target",
      "isExecuted": true,
      "isNotify": false
    }
  ]
}
```
*Note*: the choice of database is up to you 🙂, you could add its dependency on `pom.xml` to set it up.

## Frontend Task:

Frontend is based on Angular/Typescript.

- You need to show the list of `Shipment` in a table let's call that `shipment table`
- There should be an action button in your `shipment table` called `Create Execution Plan`
- When a user click on that button a modal should appear with the list of available `Template`s
- User can select only one `Template` from that list, at the bottom of that modal there should be a button called `Create Execution Plan`
- When a user click on `Create Execution Plan` button your frontend should send a request to backend and create a `Execution Plan` and save it 
- You need to show the list of `Execution Plan` on a second table

### Glossaries

- **Shipment**: json object that contains details about the shipment of transported goods
- **Template**: The `Template` is an object that helps to create an `Execution Plan` using `Shipment`. 
- **Action**: The `Action` is an object that exist in a template. A `Template` can have multiple `Action`s
- **Execution Plan**: `Execution Plan` is an object that is created by merging a `Shipment` object with a `Template` object.

### <i>Disclaimer</i> ⚠️
<i>
The code written by interviewee's on this repository is purely used for evaluation of interviewee's technical knowledge, and it will not be used for any business context. By taking this technical test, the interviewees are agreed to take part for free as its discussed during the first phase of interview.</i>