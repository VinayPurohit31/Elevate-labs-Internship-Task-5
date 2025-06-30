#  Bank Management System – Java Console Application

This is a **console-based Bank Management System** written in **Java**, designed with a modular structure and Object-Oriented Programming principles. It allows users to create and manage bank accounts, perform deposits and withdrawals, view account details, track transaction history, and delete accounts.

---

##  Features

-  Account Creation with Personal Details
-  Secure Login using User ID & Password
-  Deposit & Withdraw Money
-  Update Profile Info
-  View Account Information
-  View Transaction History
-  Delete Account

---

##  Project Structure

 BankManagementSystem/
│
├── User.java # Parent class holding user-related fields
├── Account.java # Child class extending User, includes banking-specific details
├── Bank.java # Logic layer: handles all banking operations
├── BankApp.java # Main UI logic (menu loop, interaction via Scanner)


---

##  Class Responsibilities

###  `User.java`

This is the **parent class** that defines core user attributes:

- `name`
- `phoneNumber`
- `email`
- `address`

**Purpose:**  
To encapsulate personal details that can be reused by multiple child classes if needed.

---

###  `Account.java`

This is the **child class** that extends `User.java` and includes:

- `accountNumber`
- `userId` and `password` (for login)
- `accountType` (e.g., savings or current)
- `balance`
- `transactionHistory` (list of deposit/withdrawal statements)

**Purpose:**  
To represent a complete user account with both personal and financial data.

---

###  `Bank.java`

This is the **logic layer** that holds all methods related to account operations:

- `createAccount(Scanner sc)`
- `login(Scanner sc)`
- `updateAccount(Account acc, Scanner sc)`
- `depositMoney(Account acc, Scanner sc)`
- `withdrawMoney(Account acc, Scanner sc)`
- `displayAccount(Account acc)`
- `deleteAccount(Account acc)`
- `generateStatement(Account acc)`

**Purpose:**  
It acts as a **service class** responsible for performing all banking-related functionalities using business logic.

---

###  `BankApp.java`

This is the **driver class** that runs the main application loop:

- Uses a menu-based system
- Accepts input using `Scanner`
- Calls appropriate methods from `Bank` class based on user choice

**Purpose:**  
Handles the **user interface logic** through console interaction and ensures smooth user experience.

---
