# Online Course Management Portal – Backend

This is the **backend** of the Online Course Management Portal built with **Spring Boot** and **MySQL**.  
It provides the RESTful API endpoints for **authentication**, **course management**, **enrollments**, and **user dashboards**.  
Authentication and authorization are implemented using **JWT tokens** for secure access.

---

## 🚀 Features

- **Spring Boot** REST API architecture
- **JWT-based authentication** with role-based access control
- **MySQL database** integration with JPA/Hibernate
- CRUD operations for courses and enrollments
- Separate APIs for **Admin** and **Student** functionalities
- **Mock payment API** integration for enrollments
- CORS-enabled for frontend communication
- Error handling and custom exceptions

---

## 📦 Tech Stack

- **Backend Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Authentication:** JWT (JSON Web Token)
- **Build Tool:** Maven
- **API Documentation:** Swagger/OpenAPI (if enabled)

---

## ⚙️ Running the backend

1. **Clone the repository**
   ```bash
   git clone https://github.com/BANDISREEKUMAR/Online_Course_Management_Portal_BackEnd.git
**Open in your IDE** (e.g., IntelliJ IDEA / Eclipse / VS Code with Java support).

---

2. **Configure MySQL database**
  Update `application.properties` with your database credentials:
  ```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/online_course_portal
  spring.datasource.username=your_db_user
  spring.datasource.password=your_db_password
  spring.jpa.hibernate.ddl-auto=update

---

 3. **Run the application**
  ```bash
    mvn spring-boot:run
