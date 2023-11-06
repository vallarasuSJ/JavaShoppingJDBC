Java_ECommerce
--------------
 
This java console application for E-Commerce has the following sections:
------------------------------------------------------------------------
    1. Login - Existing User and Admin
    2. Register - New User
    3. Home - User
        * View Categories 
            - View products based on category.
        * View all Products 
        * View Cart 
            - Add products to cart.
            - Check out products from cart.
        * View Order 
        * Logout
-> Java for coding 
-> 'Database' for storing and retrieving data.
 
Tables used for each sections:
-----------------------------
    1. "auth" table for storing user data.
    2. "category" table for storing categories.
    3. "products" table for storing Products.
    4. "cart" table for storing user cart details.
    5. "orders" table for storing user order details.
 
Steps used and challenges faced to build this application:-
-----------------------------------------------------------
 
    Steps:
    ------
    1. Used MVC (Model, View, Controller) architecture for developing the console application.
    2. Added the required Models, Views and Controller along with Interface implementation to achieve abstraction.
    3. Added user-defined exceptions to catch anf handle the exceptions.
    4. Used encapsulation to hide data and used getter and setter for getting and setting the data for the models.
    5. Used "ArrayList" to store and manipulate data according to the user preferrences.
    6. Used "JDBC" and "Connection Path" to connect and access the database for storing and retriving the data.
    7. Used Data Access Object (dao) for accessing Database using queries.
    8. Used Singleton pattern to avoid creating objects.
    9. Handled exceptions for invalid choices.
 
    Challenges:
    -----------
    1. Had a problem while trying to show difference between show products and show products based on category.
        -> solved it by using method overriding, created two methods with the same name with different arguments.
    
    2. Faced "StackOverFlow" - Caught this while creating parallel objects through constructor.
        -> Solved it by passing the instance "this" to other constructor.
   
    3.Had a problem while insert and update the query. It throws exception when Resultset rs=preparedStatement.executeQuery() was used.
        -> Solved it by using preparedStatement.executeUpdate() method. 

 
 
Working on the following sections 
---------------------------------
 
 1.To Display the total price of the user order.
 2.Admin 
     -Add product
     -View product 
     -Delete product  
    
Credentials 
-----------
  -> For Login use the following credentials
      *Email = "a" | Password = "a"
