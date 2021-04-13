# Masivian Clean Code
## Nikolai Bermudez Vega - Call Center
### Prerequisites
* [Maven](https://maven.apache.org) - Dependency Management
* [Docker](https://www.docker.com) - Container Management
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Development Environment 
* [Git](https://git-scm.com) - Version Control System
* [Postman](https://www.postman.com) - API Client Tester
* [CircleCi](https://circleci.com) - Continuos Integration

## Continuos Integration - CircleCi :white_check_mark:
[![CircleCi](https://circleci.com/gh/Nikolai9906/CallCenter.svg?style=svg)](https://app.circleci.com/pipelines/github/Nikolai9906/CallCenter)


## Endpoints:

The endpoints of the API are the following:
- GET request:
  - /agents: Get all agents
  - /assignment/{priority}: Assignment case to an agent
  - /unlock/{id}: Unlock an Agent that is currently busy (or lock)
  

- POST request:
  - /agents: Create a new agent

###*Make the requests to localhost:8080*

## Add bet examples
### Call Center Agent body
```json
{
    "name": "Nikolai",
    "id": 1001,
    "priority" : 1
}
```

## Installing and using 

1. Clone the repository

```
git clone https://github.com/Nikolai9906/CallCenter
```
2. Run the containers necessary for the app

```
docker-compose up -d 
```



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Container Management


## Author

* **Nikolai Bermudez Vega** - *Escuela Colombiana de Ingenieria Julio Garavito Software engineer student* 

## License

This project is under GNU General Public License - see the [LICENSE](LICENSE) file for details.
