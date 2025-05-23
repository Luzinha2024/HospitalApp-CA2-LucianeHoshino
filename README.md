# HospitalApp-CA2-LucianeHoshino

This Java project simulates the management of hospital employees, allowing sorting, searching, adding, and generating employee data through a terminal menu.

Features

-	Sort a list of employees (from ‘Applicants_Form.txt’) in alphabetical order using “recursive insertion sort” 
- Search for an employee by name and return their Manager Type and Department  
- Add new employees with validated input (name, manager, department)  
- Generate random employees using predefined names, manager types, and departments  
- Save employee lists to file  
- Structured, organized menu using “Java enums”
  
Algorithms Used

1- Sorting

- Recursive Insertion Sort
  
  Chosen to fulfil the assignment's recursive requirement
  Simple and clear for small datasets
  Provides sufficient performance for the scope of this project
  
2- Searching

- Iterative Sequential Search
  
  Selected over binary search because the list may become unsorted after manual or random insertions
  Ensures correct results even if the data is not pre-sorted
  Simpler and easier to understand for a beginner-level project
     
 How to Use

1. Place ‘Applicants_Form.txt’ in the project directory.
2. Run the program:
       Select from the menu:
   
 Sort Employees → Displays the first 20 sorted names
 Search by Name → Look up an employee
 Add Employee → Add new entries with validation
 Generate Random → Add a random employee
 Show All → Display all employees
 Save to File → Save the employee list to a ‘.txt’ file
 Exit → Close the application

  Design Choices
  
- Enums: Used for both ManagerType, Department, and MenuOption to ensure structured, type-safe selections.
- Validation: Checks that entered names contain only letters and spaces.
- Random Data Generation: Provides test data for demonstrations.
- Scalability: While the current system uses basic lists and sequential operations, the design allows for future upgrades (e.g., adding databases, using more advanced sorting or searching algorithms).
- 
 File Structure

- HospitalApp.java: Main application logic
- SortUtil.java: Recursive insertion sorting utility
- SearchUtil.java: Iterative sequential searching utility
- Validation.java: Input validation
- DataGenerator.java: Random employee generator
- Employee.java / Person.java: Data models
- ManagerType.java /Department.java / MenuOption.java: Enums

Project Justification

For this HospitalApp project, I chose to implement a recursive insertion sort to sort the list of employee names because it satisfies the academic requirement to demonstrate recursion, while being easy to understand and efficient enough for small datasets.
For the search function, I selected an iterative sequential search instead of binary search. Although binary search is faster, it only works on sorted lists. Since the list may become unsorted after adding or generating new employees, the sequential search ensures correctness and simplicity, which is ideal for a beginner project like this.
Additionally, I structured the menu using Java enums, making the user interface more organized and maintainable. Input validation ensures data integrity, and random employee generation provides a way to test the system with varied data. Together, these design decisions create a reliable and extendable system that fulfills the assignment’s requirements while remaining beginner-friendly.
