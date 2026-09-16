# 🏦 Bank Management System

A **console-based Bank Management System** developed using **Core Java, Object-Oriented Programming, JDBC, and MySQL**. The project demonstrates how a Java application can interact with a relational database to perform basic banking account management operations.

---

## 📌 Project Overview

The **Bank Management System** is a Java-based application designed to manage bank account information and perform essential account operations.

The application provides a simple menu-driven interface through which users can create and manage bank accounts. The system uses **JDBC (Java Database Connectivity)** to establish communication between the Java application and the **MySQL database**.

The project focuses on implementing **Core Java, OOP concepts, JDBC connectivity, SQL operations, exception handling, and database management** in a practical application.

---

## 🎯 Project Purpose

The main purpose of this project is to develop a simple banking application while gaining practical knowledge of Java and database integration.

### Objectives

* To develop a menu-driven banking application using Core Java.
* To implement **Object-Oriented Programming (OOP)** concepts.
* To connect a Java application with MySQL using **JDBC**.
* To perform database operations using SQL.
* To implement **CRUD operations** for bank accounts.
* To separate database connectivity and banking operations into different components.
* To improve understanding of Java interfaces, classes, methods, and exception handling.
* To demonstrate how backend Java applications communicate with relational databases.

---

## 🚀 Features

The application supports basic bank account management operations such as:

* ➕ Create a new bank account
* 🔍 View account details
* ✏️ Update account information
* ❌ Delete an account
* 💰 Manage account balance
* 📋 Display account records
* 🔄 Perform database-based account operations
* 🔗 Establish database connectivity using JDBC

---

## 🛠️ Technologies Used

| Technology       | Purpose                                                               |
| ---------------- | --------------------------------------------------------------------- |
| **Java**         | Application development                                               |
| **Core Java**    | Programming logic and application flow                                |
| **OOP**          | Encapsulation, abstraction, inheritance/interfaces and modular design |
| **JDBC**         | Connecting Java with MySQL                                            |
| **MySQL**        | Storing and managing account data                                     |
| **Eclipse IDE**  | Development environment                                               |
| **Git & GitHub** | Version control and project hosting                                   |

---

# 🏗️ Project Architecture

The project follows a **layered structure** that separates database connectivity, banking operations, and data models.

### Architecture Flow

```text
                 ┌─────────────────────────┐
                 │       Main / Driver     │
                 │   Application Entry     │
                 └────────────┬────────────┘
                              │
                              ▼
                 ┌─────────────────────────┐
                 │    BankOperations       │
                 │  Banking Business Logic │
                 └────────────┬────────────┘
                              │
                              ▼
                 ┌─────────────────────────┐
                 │       BankDoc           │
                 │   Operation Contract    │
                 └────────────┬────────────┘
                              │
                              ▼
                 ┌─────────────────────────┐
                 │     DBConnection        │
                 │    JDBC Connectivity    │
                 └────────────┬────────────┘
                              │
                              ▼
                 ┌─────────────────────────┐
                 │        MySQL            │
                 │     Bank Database       │
                 └─────────────────────────┘
```

---

## 📂 Project Components

### 1. Account

The `Account` class represents the bank account entity.

It contains account-related information such as:

* Account Number
* Account Name
* Phone Number
* Account Balance

The class acts as the **data model** used to transfer account information between the application and database layer.

---

### 2. BankOperations

`BankOperations` contains the main banking operations of the application.

It is responsible for performing operations such as:

* Creating accounts
* Reading account details
* Updating account information
* Deleting accounts
* Managing account-related database operations

The class communicates with the database through JDBC.

---

### 3. BankDoc

`BankDoc` defines the operations that the banking system should provide.

`BankOperations` implements this interface.

This helps achieve **abstraction** and provides a clear contract for the banking operations.

```text
BankDoc
   │
   │ implements
   ▼
BankOperations
```

---

### 4. DBConnection

The `DBConnection` class is responsible for establishing a connection between the Java application and MySQL.

The connection is created using:

```text
DriverManager
      ↓
JDBC
      ↓
MySQL Database
```

This keeps database connection logic separate from the banking business logic.

---

## 🗄️ Database

The project uses **MySQL** as the relational database.

### Database

```text
casestudydb
```

### Account Table

The project uses an `account` table to store account information.

| Column    | Description                 |
| --------- | --------------------------- |
| `accno`   | Unique account number       |
| `accname` | Account holder name         |
| `phone`   | Account holder phone number |
| `balance` | Current account balance     |

### Basic Database Structure

```text
                ACCOUNT
        ┌─────────────────────┐
        │ accno               │
        │ accname             │
        │ phone               │
        │ balance             │
        └─────────────────────┘
```

---

# 🔄 Application Flow

The general flow of the application is:

```text
Start Application
       │
       ▼
Display Banking Menu
       │
       ▼
Select Operation
       │
       ├── Create Account
       │
       ├── View Account
       │
       ├── Update Account
       │
       ├── Delete Account
       │
       └── Other Operations
       │
       ▼
BankOperations
       │
       ▼
JDBC
       │
       ▼
MySQL Database
       │
       ▼
Return Result
       │
       ▼
Display Result
```

---

# 🔌 JDBC Connectivity

The project uses **JDBC** to communicate with MySQL.

The basic JDBC workflow is:

```text
1. Load/Register JDBC Driver
            ↓
2. Establish Database Connection
            ↓
3. Create Statement / PreparedStatement
            ↓
4. Execute SQL Query
            ↓
5. Process Result
            ↓
6. Close Database Resources
```

JDBC allows the Java application to perform database operations without directly depending on the MySQL user interface.

---

# 💡 OOP Concepts Used

The project demonstrates important Object-Oriented Programming concepts.

### Encapsulation

Account information is maintained inside the `Account` class using fields and corresponding methods.

### Abstraction

The `BankDoc` interface defines banking operations while the implementation details are provided by `BankOperations`.

### Inheritance / Interface Implementation

`BankOperations` implements the `BankDoc` interface, providing the required banking operation implementations.

### Polymorphism

The interface reference can be used to refer to the implementation object, supporting flexible and maintainable code.

---

# 📊 CRUD Operations

The project demonstrates the four basic database operations:

| Operation  | SQL Concept | Purpose                      |
| ---------- | ----------- | ---------------------------- |
| **Create** | `INSERT`    | Add a new account            |
| **Read**   | `SELECT`    | Retrieve account information |
| **Update** | `UPDATE`    | Modify account information   |
| **Delete** | `DELETE`    | Remove an account            |

This provides practical experience with database-driven Java applications.

---

# ⚙️ Requirements

Before running the project, install:

* **JDK 8 or above**
* **MySQL Server**
* **MySQL JDBC Driver**
* **Eclipse IDE** or any Java IDE
* **Git** (optional, for cloning the repository)

---

# ▶️ How to Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/venkatareddy16/BankManagementSystem.git
```

### Step 2: Open the Project

Open the cloned project in **Eclipse IDE**.

### Step 3: Configure MySQL

Create the required database:

```sql
CREATE DATABASE casestudydb;
```

Select the database:

```sql
USE casestudydb;
```

Create the `account` table according to the project schema.

### Step 4: Configure JDBC

Update the database connection details in the `DBConnection` class:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/casestudydb",
    "root",
    "your_password"
);
```

Replace `your_password` with your local MySQL password.

### Step 5: Add MySQL JDBC Driver

Make sure the **MySQL Connector/J** JAR is added to the project's build path.

### Step 6: Run the Application

Run the main/driver class.

The menu-driven banking application will start in the console.

---

# 🧪 Example Operations

A typical application flow can look like:

```text
********** Bank Management System **********

1. Create Account
2. View Account
3. Update Account
4. Delete Account
5. Exit

Enter your choice:
```

For example, when creating an account:

```text
Enter Account Number: 90104
Enter Account Name: Rakesh
Enter Phone Number: 6405567876
Enter Initial Balance: 1500.0

Account created successfully!
```

---

# 📚 Key Learning Outcomes

Through this project, the following concepts are practically demonstrated:

* Core Java programming
* Object-Oriented Programming
* Java interfaces
* Encapsulation
* Abstraction
* JDBC
* MySQL database connectivity
* SQL CRUD operations
* Exception handling
* Modular application design
* Database resource management
* Git and GitHub project management

---

# 🔮 Future Enhancements

The project can be extended with additional features such as:

* User login and authentication
* Deposit and withdrawal modules
* Transaction history
* Fund transfer between accounts
* PIN/password management
* Input validation
* Transaction table
* Admin and customer roles
* GUI using Java Swing or JavaFX
* REST APIs using Spring Boot
* Improved security and authentication
* Connection pooling

---

# 🎓 Conclusion

The **Bank Management System** is a practical Java application that demonstrates how **Core Java, Object-Oriented Programming, JDBC, and MySQL** can be combined to develop a database-driven application.

The project provides hands-on experience in designing Java classes, implementing banking operations, performing CRUD operations, and establishing communication between a Java application and a MySQL database.

Overall, this project helped strengthen practical knowledge of **Java programming, OOP concepts, JDBC, SQL, database management, and application architecture**, while providing a foundation for developing more advanced Java backend applications in the future.

---

## 👨‍💻 Author

**Venkata Reddy**

B.Tech – Computer Science and Engineering

GitHub:
https://github.com/venkatareddy16

---

## ⭐ Project Repository

[Bank Management System](https://github.com/venkatareddy16/BankManagementSystem)

If you find this project useful, feel free to explore the repository and provide feedback.

---

### 📄 License

This project is developed for **educational and learning purposes**.
