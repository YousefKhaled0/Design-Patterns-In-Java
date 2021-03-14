package solid.sr;

/**
 * The Single Responsibility Principle (SRP) states that there should never be more than one reason for a class to change.
 * This means that every class, or similar structure, in your code should have only one job to do.
 */

public class Employee {

    public void save() {
        // save to database.
        // should be in different class.
    }

    public void calculatePay() {
        // business logic should be in different class.
    }

    public String describeEmployee() {
        return "EMPLOYEE INFO";
    }

}
