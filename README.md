# 🍔 Burger Shop Order Management System

*A Java Swing desktop application built with custom data structures & NetBeans GUI*

## 📌 Overview

The **Burger Shop Order Management System** is a lightweight Java desktop application designed to manage burger orders in a fast-food environment.
Users can **place, update, search, filter, and track orders** across multiple states like *Processing*, *Delivered*, and *Cancelled* — all through a clean, NetBeans-built Swing interface.

The project combines **GUI development**, **custom data structures**, and **file-based persistence** to demonstrate practical software engineering concepts.

---

## ✨ Key Features

### 🍟 Manage Orders Easily

* Place new burger orders
* Update existing orders
* Cancel orders
* Mark orders as delivered or processing

### 🔍 Powerful Search Tools

* Search orders by **Order ID**
* Search orders by **Customer Name**
* Find the **Best Customer** (based on frequency or total purchases)

### 📊 Order Categories

Dedicated screens for:

* 🟡 Processing Orders
* 🟢 Delivered Orders
* 🔴 Cancelled Orders
* 📋 All Orders Overview

### 🧵 Custom Data Structures

Orders are stored using a **custom LinkedList implementation**, built from scratch:

* `controller/LinkedList.java` (list operations)
* `controller/Node.java` (node structure)
* Ensures understanding of low-level data management

### 💾 Persistent Storage

All orders are saved into a simple text file:
**`burger.txt`**
This allows the application to restore order history on every startup.

---

## 🛠️ Architecture

The project loosely follows an **MVC-style separation**:

### **Model (`model/`)**

* `Burger.java` holds all order-related data
  (order id, customer info, type, price, status, etc.)

### **Controller (`controller/`)**

* `BurgerController.java`

  * Handles business logic: add/update/remove/search orders
  * Reads/writes from `burger.txt`
  * Calculates best customer
* `LinkedList.java` and `Node.java`

  * Custom linked list used to store Burger objects in memory

### **View (`view/`)**

GUI built with NetBeans GUI Builder (`*.java` + `*.form`):

* `ShopMainForm` — main dashboard
* `PlaceOrder` — add order
* `UpdateOrder` — edit orders
* `ViewOrders`, `ProcessingOrders`, `DeliveredOrders`, `CancelledOrders` — filtered views
* Search forms: `SearchOrder`, `SearchCustomer`, `SearchBestCustomer`

### **Entry Point**

* `Main.java` initializes the look-and-feel and launches the UI

---

## 📂 Project Structure

```
project-root/
├── build.xml
├── burger.txt
├── lib/
├── src/
│   ├── model/
│   │   └── Burger.java
│   ├── controller/
│   │   ├── BurgerController.java
│   │   ├── LinkedList.java
│   │   └── Node.java
│   └── view/
│       ├── *.java
│       └── *.form
```

---

## ▶️ Running the Project

### **✔️ Option 1 — Using NetBeans (Recommended)**

1. Open NetBeans
2. *File → Open Project*
3. Select the project folder
4. Run the project using the green play button

NetBeans automatically handles form files and Ant builds.

---

### ✔️ **Option 2 — Using Terminal (Ant)**

From the project root:

#### Build:

```
ant clean
ant
```

#### Run:

```
java -cp build/classes view.Main
```

(Or replace `view.Main` with your actual main class if different.)

---

## 🎯 Learning Outcomes

This project is ideal for students or beginners wanting to understand:

* Java Swing UI development
* NetBeans GUI Builder
* Custom data structures (LinkedList & Node)
* File I/O for persistence
* MVC-style application architecture
* Search, filtering, and business logic handling

---

## 🚀 Possible Improvements

* Switch from text file to CSV/JSON/SQLite
* Add sorting and pagination
* Introduce login system for staff
* Improve UI theme and layout
* Add error dialogs and input validation
* Implement automated unit tests
* Export reports (PDF/CSV)

---

## 👨‍💻 Author

Developed by **Pramuditha Lakshan**
A software engineering student exploring Java SE, data structures, and desktop application development.

---

## 📜 License

This project is open for educational and personal use.
