/**
 * SortPay comparator is used to compare the employee pays
 * @author Dylan VanAllen
 */
import java.util.Comparator;
public class SortPay implements Comparator<Employee> {
    @Override
    /**
     * Compares the pay values of employees
     * @param a the first employee to compare
     * @param b the second employee to compare
     * @return the comparison result
     */
    public int compare(Employee a, Employee b) {
        return (int)(a.getPay()-b.getPay());
    }
    
}
