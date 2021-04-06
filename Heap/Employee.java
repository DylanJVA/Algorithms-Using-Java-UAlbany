/**
 * Employee class - testing object for priority queue
 * @author Dylan VanAllen
 */
public class Employee{
    String name;
    double pay;
    /**
     * Employee constructor - creates a new employee with a name and pay
     * @param name
     * @param pay
     */
    public Employee(String name, double pay) {
        this.name = name;
        this.pay = pay;
    }
    /**
     * gets the name of this employee
     * @return a name string
     */
    public String getName() {
        return this.name;
    }
    /**
     * alters the name of this employee
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * gets the pay of this employee
     * @return a pay double
     */
    public double getPay() {
        return this.pay;
    }
    /**
     * alters the pay of this employee
     * @param pay new pay
     */
    public void setPay(double pay) {
        this.pay = pay;
    }
    /**
     * Checks if an employee is equal to another
     * @param object to be compared
     * @return true if equal false if not
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) return false;
        if (((Employee)obj).getName().equalsIgnoreCase(this.name) && ((Employee)obj).getPay() == this.pay) return true;
        else return false;
    }
    /**
     * Returns a string that describes the employee
     * @return the employee string
     */
    public String toString() {
        return this.getClass().getSimpleName() + ": " +this.name + String.format(", $%.2f", this.pay);
    }
    
}
