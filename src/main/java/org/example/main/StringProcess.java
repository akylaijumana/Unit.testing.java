package org.example.main;

public class StringProcess {
    public static boolean isStrong(String password) {        // Check minimum length
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        // Define special characters
         String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialCharacters.indexOf(c)!= -1) {
                hasSpecial = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecial;
    }

    public static int calculateDigits(String sen) {
        if (sen.length() == 0) {
            return 0;
        }
        int cnt = 0;
        boolean inDigit = false; // Use a boolean to track if we are in a digit sequence
        for (int i = 0; i < sen.length(); i++) {
            if (sen.charAt(i) == '\\') {
                i++;
                continue;
            }
            if (Character.isDigit(sen.charAt(i))) {
                if (!inDigit) {
                    cnt++;
                    inDigit = true;
                }
            } else {
                inDigit = false; // Exit digit sequence
            }
        }
        return cnt;
    }

    public static int countWords(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int count = 0;
        for (int  i = 0;  i< str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count++;
                while (str.charAt(i) != ' ' && i< str.length() - 1) {
                    i++;
                }
            }
        }
        return count;
    }
    public static double calculateExpression(String expression){

                expression = expression.replaceAll(" ", ""); // Remove spaces
                double result = 0; // Initialize result
                double currentNumber = 0; // For building numbers
                char operation = '+'; // Start with addition

                for (int i = 0; i < expression.length(); i++) {
                    char c = expression.charAt(i);

                    if (Character.isDigit(c) || c == '.') {
                        // Build the current number
                        StringBuilder number = new StringBuilder();
                        while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                            number.append(expression.charAt(i));
                            i++;
                        }
                        currentNumber = Double.parseDouble(number.toString());
                        i--; // Adjust the index after inner loop
                    }

                    // Process the current operation when an operator is found
                    if (i < expression.length() && !Character.isDigit(c) && c != '.') {
                        result = applyOperation(result, currentNumber, operation);
                        operation = c; // Update the current operation
                    }
                }

                // Final operation after the loop
                result = applyOperation(result, currentNumber, operation);

                return result; // Return the final result
            }

            private static double applyOperation(double a, double b, char operation) {
                switch (operation) {
                    case '+':
                        return a + b;
                    case '-':
                        return a - b;
                    case '*':
                        return a * b;
                    case '/':
                        return a / b; // No division by zero check for simplicity
                    default:
                        return a; // No operation
                }
            }
        }





