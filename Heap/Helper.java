/**
 * Helper class - Tests the generic priority queue with a list of Employee objects from HeapTest.txt
 * @author Dylan VanAllen
 */
import java.io.*;
public class Helper{
    /**
     * start method first creates an empty queue,
     * then tests the SortPay comparator,
     * then tests the SortName comparator,
     * then tests the delete and insert methods of the queue
     */
    public static void start() {         
        Queue<Employee> queue = new Queue<Employee>();
        create(queue);
        System.out.println("Original queue:");
        display(queue);
        System.out.println("--------------------");
        queue.sort(new SortPay());
        System.out.println("Sorted by pay: ");
        display(queue);
        System.out.println("--------------------");
        queue.sort(new SortName());
        System.out.println("Sorted by name: ");
        display(queue);
        System.out.println("--------------------");
        System.out.println("After a deletion: ");
        queue.delete();
        display(queue);
        System.out.println("--------------------");
        queue.insert(new Employee("Dylan VanAllen",5500.00));
        System.out.println("After an insertion: ");
        queue.delete();
        display(queue);

    }
    /**
     * Creates a queue of Employees from the test txt file
     * @param queue
     */
    public static void create(Queue<Employee> queue) { 
        try {
        FileInputStream fstream = new FileInputStream("HeapTest.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)
        {
            String[] tokens = strLine.split(" ");
            Employee employee = new Employee(tokens[0]+" "+tokens[1],Double.parseDouble(tokens[2]));
            queue.insert(employee);
        }
        in.close();
        }catch (Exception e){
        System.err.println("Error: " + e.getMessage());
        }

        

    } 
    /**
     * Displays the objects in the queue
     * @param queue
     */
    public static void display(Queue<Employee> queue) { 
    for (Employee employee : queue.getHeap().getList()) {
        System.out.println(employee.toString());
    }
    } 
}