public class Student {//declares variables for the student
    private int rollno;
    private String name;
    private String address;
//implents the variables for the student
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;

    }
    //gets the roll number from the main class
    public int getRollno() {
        return rollno;
    }
    //gets the name from the main class
    public String getName() {
        return name;
    }
    //gets the address from the main class
    public String getAddress() {
        return address;
    }
    //polymorphed from toString for this instance
    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
    }
}
