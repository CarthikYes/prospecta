Q1
ans: 
To read the input file, use a CSV parsing library.
Each row and column in the CSV file is looped through.
Examine each cell to see if it contains a formula or a value.
Store the value if it contains one.
If it has a formula, parse it and evaluate it with a formula evaluation library.
Save the formula evaluation result.
Save the calculated values to a new CSV file.

Q2
ans:
Syntax errors 
Invalid data & formula

Q3
ans:
Checking that the input file is a proper CSV file.
Assuring that the input file has the appropriate amount of columns and rows.
Making certain that every cell in the input file has proper data (either a number or a formula).
Making certain that the formulae in the input file are valid and do not contain any circular references or division by zero errors.
