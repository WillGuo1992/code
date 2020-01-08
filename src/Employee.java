import java.io.Serializable;

public class Employee implements Comparable<Employee>,Serializable {
    private String name;
    private double salay;

    public Employee(String name, double salay) {
        this.name = name;
        this.salay = salay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public String getName() {
        return this.name;
    }

    public double getSalay() {
        return salay;
    }

    @Override
    public String toString() {
        return this.name + "," + this.salay;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salay, o.getSalay());
    }
}
