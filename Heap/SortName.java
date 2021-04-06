/**
 * SortName comparator is used to compare the employee names for sorting
 * @author Dylan VanAllen
 */
import java.util.Comparator;
public class SortName implements Comparator<Employee> {
    @Override
    /**
     * Compares the name values of employees
     * @param a the first employee to compare
     * @param b the second employee to compare
     * @return the comparison result
     */
    public int compare(Employee a, Employee b) {
        return b.getName().compareTo(a.getName());
    }
}
