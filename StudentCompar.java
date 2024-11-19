import java.util.Comparator;
public class StudentCompar {
    //tells what to compare this compares the name
    public static class NameComparator implements Comparator<Student> {
        @Override//polymorphed compare used twice for 2 different things
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }
    public static class RollComparator implements Comparator<Student> {
        @Override//polymorphed comapre used now to compare the roll number
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getRollno(), s2.getRollno());
        }
    }
}
