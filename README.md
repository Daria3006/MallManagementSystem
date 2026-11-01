# MallManagementSystem

A Java Spring Boot application designed to manage the structure, sales, staff, and maintenance aspects of a shopping mall.
This project is built using a 4-layer architecture (Model, Repository, Service and Controller) and currently uses in-memory data storage.

## Architecture
 1. **Model**: Contains classes for each entity and `Java enum` types to replace raw strings for attributes with fixed values.
 2. **Repository**: Manages data storage and retrieval. Contains an interface `BaseRepository<T>` defining standard `CRUD` operations and other interfaces extending the base interface specific for each entity. The in-memory data management is done using a generic abstract class implementing the base repository. For each entity exists an in-memory repository extending the abstract class and implementing the specific interface.
 3. **Service**: Contains the business logic. The Services are broken down based on functional domain areas:
* **Structure**: Manages `malls` and `floors`.
* **Sales**: Manages `shops`, `purchases`, and `customers`.
* **Maintenance**: Manages `electrical assets` and `tasks`.
* **Staff**: Manages `employees` and `shifts`.
 4. **Controller**: Combines logic with user requests. Each controller has a specific service whose functions it calls to execute the actual business operations and return the correct data back to the user.

## How to Run and Test
1. Run the main Spring Boot application class (`MallManagementSystemApplication.java`) in your IDE.
2. The embedded Tomcat server will start on port 8080.
3. Open a web browser and navigate to the test endpoint:
   `http://localhost:8080/hello`
4. The browser will display: `Die Anwendung funktioniert!`