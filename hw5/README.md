# Frank Ziegler HW 5 Writeup
## About
### Test Cases

There is a test run in testRun.txt.
### Compiling and Running

If you wish to run this project on your own computer, run the following commands to compile and run:

Compile: `javac -cp lib/gson-2.10.1.jar -d bin $(find . -name "*.java")`

Run: `java -cp "bin:lib/gson-2.10.1.jar" Client`
## Structure

I designed this application in full-stack fashion:
- The `Client` class handles all mock frontend functionality.
- The `AccountService` and `UserService` classes handle all business logic and utilize the repository classes to read and write from their respective databases.
- The `UserRepo` and `AccountRepo` classes interface directly with the AccountDB and the UserDB via standard queries.

This design is a classic, simple backend. Though it was not in the requirements to have data persist across sessions, I thought it made sense to do it and thought it would be fun.
## Applied Structural Design Patterns
### The Adapter Pattern

`ZelleAdapter` is a mock class adapter for Zelle functionality. The phone number or email is passed to the service class and the service class passes that phone number or email to the Zelle adapter.

One of two things is going to happen:
1. The phone number or email belongs to a user that is also registered at my credit union. In which case, the money will be transferred to that account and saved in the DB.
2. The phone number or email *does not* belong to the a user registered in the credit union. In which case, the money disappears into the void because, well where else would it go? It's not like we're using actual Zelle. In the real-world Zelle, it would search for the user in their system with that phone number or email and grab the account and bank associated with that user account. We don't have access to that data here. 
### The Proxy Pattern

"Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object." -- Refactoring Guru

There are two domain objects in this application: `Account` and `User`. This application was designed so that both of these domain objects have their own respective databases and thus, different functionality across the application. Therefore there are two service classes `AccountService` and `UserService` and furthermore, two data pipelines.

The service classes both implement their respective interfaces `IUserOps` and `IAccountOps`, and the `ServiceProxy` implements both. The `ServiceProxy` *uses* both of the service classes to perform the operations, but in the `Client`, the `IUserOps` and `IAccountOps` are instantiated with a `ServiceProxy`. This prevents the user from directly accessing the service classes and allowing for operations before or after the actual service function completion.

I chose this design pattern because it's a cool abstraction to have in case any housekeeping or extraneous operations need to be performed outside of the basic service-based operations in case of edge cases. Otherwise, those things have to be done on the Client, and keeping the Client thin should be a priority in maintaining a modular application. Domain and service logic should not fall on the client. 
### The Repository Pattern

The databases used are JSON databases (due to the complexity of the data, i.e. nesting). To handle creating, reading, deleting, and updating domain objects, I used the Repository Design Pattern, which involves creating an abstraction layer (the repository) between the service classes and the database. The repository itself is a centralization for all database logic and querying. 

A note: to handle the serialization and deserialization of JSON data, I used Gson, Google's JSON handler. 

I chose *this* pattern because I really wanted data persistence and I don't think that service classes should interface directly with the data. They should handle it, but not store it and read it directly.
