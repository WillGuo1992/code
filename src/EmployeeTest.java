import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class EmployeeTest {
    public static void main(String[] args) throws Exception {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("guo", 123.1);
        employees[1] = new Employee("zhi", 7833.1);
        employees[2] = new Employee("chao", 1234.54);

        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(new FileOutputStream("abc.txt"));
        objectOutputStream.writeObject(employees[0]);
        objectOutputStream.writeObject(employees[1]);


//        Arrays.sort(employees);
//
//        for (Employee e : employees) {
//            System.out.println(e.getName());
//        }

    }
}
