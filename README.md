# MallManagementSystem

A Java Spring Boot application designed to manage the structure, sales, staff, and maintenance aspects of a shopping mall.
This project is built using a 4-layer architecture (Model, Repository, Service and Controller) and currently uses in-memory data storage.

## Architecture
 1. **Model**: Contains classes for each entity and `Java enum` types to replace raw strings for attributes with fixed values.
 2. **Repository**: Manages data storage and retrieval. Contains an interface `BaseRepository<T>` defining standard `CRUD` operations. The in-memory data management is done using a generic abstract class implementing the base repository. For each entity exists an in-memory repository extending the abstract class.
 3. **Service**: Contains the business logic. The Services are broken down based on functional domain areas:
* **Structure**: Manages `malls` and `floors`.
* **Sales**: Manages `shops`, `purchases`, and `customers`.
* **Maintenance**: Manages `electrical assets` and `tasks`.
* **Staff**: Manages `employees` and `shifts`.
 4. **Controller**: Combines logic with user requests. Each controller has a specific service whose functions it calls to execute the actual business operations and return the correct data back to the user.

## Web Features
The frontend user interface is done using `Thymeleaf`. Each domain entity utilizes standard templates (`index.html` for list and delete views and `form.html` for creation views), creating fully functional HTML forms to instantiate entities and tables to view them. 
Using `POST` mapping, the safe deletion of data is done, and additionally, form bindings use explicitly initialized objects with default constructor values to prevent uninitialized null errors when loading and submitting forms.

## How to Run and Test
1. Run the main Spring Boot application class (`MallManagementSystemApplication.java`) in your IDE.
2. The embedded Tomcat server will start on port 8080.
3. Open a web browser and navigate to the test endpoint:
   `http://localhost:8080/hello`
4. The browser will display: `Die Anwendung funktioniert!`
5. Open a web browser and navigate to one of the active domain endpoints to interact with the system:
   - **Shops**: `http://localhost:8080/sales/shops`
   - **Customers**: `http://localhost:8080/sales/customers`
   - **Purchases**: `http://localhost:8080/sales/purchases`
   - **Mall**: `http://localhost:8080/structure/malls`
   - **Floor**: `http://localhost:8080/structure/floors`
   - **Maintenance Task**: `http://localhost:8080/maintenance/maintenanceTasks`
   - **Electrical Asset**: `http://localhost:8080/maintenance/electricalAssets`
   - **Security Staff**: `http://localhost:8080/staff/securityStaff`
   - **Maintenance Staff**: `http://localhost:8080/staff/maintenanceStaff`
   - **Staff Assignment**: `http://localhost:8080/staff/staffAssignments`
6. Use the "Create" buttons to add data and the "Delete" buttons to remove it.