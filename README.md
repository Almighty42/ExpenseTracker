# ExpenseTracker
CLI ( Command Line Interface ) Java practice project with requirements taken from [roadmap.sh](https://roadmap.sh/projects/expense-tracker).
This app is designed for managing simple expenses with a CLI interface. App supports basic CRUD operations, alongside a couple of additional options.

## Features
 - **Add Expenses**: Add expenses with details like description, category, expense amount and auto-generated ID and date of creation.
 - **Delete Expenses**: Delete expenses by specifying the ID of the expense.
 - **Update Expenses**: Update expenses by specifying the ID of the expense.
 - **View Expenses**: View all expenses alongside their details.
 - **View Summary of all expenses**: View the summary or sum of all expenses that you have.
 - **Save Expenses**: Expenses get auto-saved for later use.

## Example
```
  --Welcome to the Expense Tracker--

  1 - Add an expense
  2 - Delete an expense
  3 - Update an expense
  4 - View all expenses
  5 - View summary of all expenses
  6 - View summary of all expenses for a specific month
  7 - Exit program
```

```
  # ID            Date            Description             Amount
  # 5da2380f      2025-03-05      Test1                   $100.0    
  # ece01d35      2025-03-05      Test2                   $200.0    
  # ec3e1410      2025-03-05      Test3                   $300.0    

  Press any button to continue...
```

## Installation
1. **Install JDK**:
Ensure you have the latest version of JDK ( Java Development Kit ) on your system.
3. **Clone Repo**:
```sh
git clone https://github.com/Almighty42/ExpenseTracker.git
```
3. **Run Application**:
```sh
java src/ExpenseTracker.java
```
