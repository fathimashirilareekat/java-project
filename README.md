# Hostel Management System

A **Java-based hostel management application** with student management, room allocation, complaints, and admin features. The system uses **MySQL** as the backend and **Java Swing** for the frontend GUI.

## **Features**

* **Admin**
  * Secure login
  * Manage hostel operations
    
* **Students**
  * Add/view student details
  * Assign rooms automatically
    
* **Rooms**
  * Track capacity and current allocations
  * First-available room allocation logic
    
* **Allocations**
  * Maintain student-room mapping
  * View allocation history
    
* **Complaints**
  * Students submit complaints
  * Admins view and update status

## **Project Structure**
HostelManagement/
├── src/                  # Java source files (frontend & backend logic)
├── lib/                  # Libraries (MySQL connector)
├── screenshots/          # GUI screenshots
│                         # Database screenshots
├── test/                 # Test scripts for key functionalities
├── README.md             # This file
└── database.sql          # SQL scripts with table creation & sample data


## **Database Tables**

1. **admins** – Stores admin credentials
2. **students** – Student information (name, admission number, KEAM rank, phone, hostel type, room assigned)
3. **rooms** – Room details: room number, capacity, currently allocated students
4. **allocations** – Tracks which student is allocated to which room and allocation date
5. **complaints** – Tracks student complaints and their status

## **Setup Instructions**

1. **Clone the repository**

```bash
git clone <https://github.com/fathimashirilareekat/java-project>

2. **Set up MySQL Database**

* Run `database.sql` in MySQL Workbench to create tables and insert sample data

3. **Add MySQL Connector**

* Place `mysql-connector-java-9.4.0.jar` in the `lib/` folder

4. **Compile & Run Java Project**

```bash
javac -cp "lib/mysql-connector-java-9.4.0.jar" -d bin src/**/*.java
java -cp "lib/mysql-connector-java-9.4.0.jar;bin" gui.Main
```

5. **Login**

* Admin credentials: `username: admin`, `password: admin123`
* Use GUI to add students, allocate rooms, and manage complaints

**Usage:**

* Compile and run the test files:

```bash
javac -cp "lib/mysql-connector-java-9.4.0.jar" -d bin test/*.java
java -cp "lib/mysql-connector-java-9.4.0.jar;bin" test.h-student-test
* These scripts demonstrate the correctness of **student, admin, and complaint modules**.

## **Notes**

* Room allocation is **automatic** and assigns the first available room.
* Allocations are updated in **both `rooms` and `allocations` tables**.
* Complaints are linked to **students and rooms**.
* All tables include **sample data** for testing and screenshots.

## **Technologies Used**

* **Java** – Frontend (Swing GUI) & backend logic
* **MySQL** – Database
* **JDBC** – Database connectivity


