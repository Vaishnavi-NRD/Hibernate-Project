Tools Required:
1)Eclipse IDE for Enterprise Java & Web Developers
2)MySQLWorkbench 8.0

Steps:
1)Create a Simple Maven project
	New -> maven project -> select simple maven achetype -> Provide group id- org.jsp & Arche type -> Employee -> Click Finish
2)Provide Maven Dependencies (pom.xml) i.e.,
	i)Hibernate core-relocation
	ii)MySql Connector java
3)In src/main/resources create META-INF folder Create Persistence.xml file & give it's code (Check for local host, Username & password in your respective DB)
4)In src/main/java create 3 Packages with their respective classes 
	i)Employee.controller---> EmployeeController.java
	ii)Employee.dao---> EmployeeDao.java
	iii)Employee.dto--> Employee.java
& further provide their respective code
5)Finally Compile & Run 
6)HQL Queries for creating table with its mentioned attributes will be displayed
7)Perform CRUD operations & Validation
8)Check for the details with MySQL WorkBench