Hi Hasan,

 

WRT to your candidature for the role of  Java Developer;

 

Please find below coding assignment

 

Request you to please complete it by this week and share the codes.

 

 

Here are the use cases for the Coding Challenge.

 

Explain Spring MVC concept

 

Use case 1 :

Create a table :

               Create table department(departmentid int primary key, departmentname varchar2(4000));

Create table employee(employeeid int primary key, firstname varchar2(4000), lastname varchar2(4000), department varchar2(4000));

              

Develop features :

Create Department

               Validations : Department name must be unique

Create Employee with department

Validations : If department does not exist, throw exception

Update existing employee last name

Delete Employee

 

Create entities in Springboot application.

Develop features to execute below use cases :

Fetch list of employees per department when I pass department name.
Delete department and it should also delete employees.
Add list of users to a department.
 

Use case 2

 

You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

public class Solution {

    public static void main( String args[] ) {

        Printer myPrinter = new Printer();

        Integer[] intArray = { 1, 2, 3 };

        String[] stringArray = {"Hello", "World"};

      //Write code here to call a method that prints intArray/StringArray element by element.

    }

}

 

You are given code in the editor. Complete the code so that it prints the following lines:

1

2

3

Hello

World

 

Use case 3

Write codes to print Fibonacci series

 

Use case 4

Build a self referencing table with columns : id, name, parent_id, parent_name.

When

 

Insert record=0, name=”root”

Insert record id=1, name=”root1”, parent_id=0, Parent_name=”root”

Insert record id=2, name = “child1”, parent_id=1, parent_name=”root1”

Insert record id=3, name=”child2”, parent_id=1, parent_name=”root1”

Insert record id=4, name=”root2”, parent_id=0. “arent_name=”root”

Insert record id=5, name=”child3”, parent_id=4, parent_name=”root2”

 

When I get list with id=1, then I should see all the nodes like a tree structure.# Coding-Assignment-OutworX-Java