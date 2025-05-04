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
    - Chosen to fulfil the assignment's recursive requirement
    - Simple and clear for small datasets
    - Provides sufficient performance for the scope of this project
2- Searching
- Iterative Sequential Search
    - Selected over binary search because the list may become unsorted after manual or random insertions
    - Ensures correct results even if the data is not pre-sorted
    - Simpler and easier to understand for a beginner-level project
 How to Use
1. Place ‘Applicants_Form.txt’ in the project directory.
2. Run the program:
       Select from the menu:
     - Sort Employees → Displays the first 20 sorted names
     - Search by Name → Look up an employee
     - Add Employee → Add new entries with validation
     - Generate Random → Add a random employee
     - Show All → Display all employees
     - Save to File → Save the employee list to a ‘.txt’ file
     - Exit → Close the application
