import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//imports used I found the table to fix my bank program!
public class Main extends JFrame {//variables for element placeholders
    private ArrayList<Student> students;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    public Main() {
        // start the list
        students = new ArrayList<>();

        // this was the hardest part thinking of addresses
        students.add(new Student(1, "Thomas", "1913 Metamora st"));
        students.add(new Student(2, "Selby", "717 East 3rd st"));
        students.add(new Student(3, "Laura", "1116 West 3rd st")); // Corrected 'laura' to 'Laura'
        students.add(new Student(4, "Leah", "412 East 3rd st"));
        students.add(new Student(5, "Rex", "516 West Park st"));
        students.add(new Student(6, "Mike", "513 Walnut st"));
        students.add(new Student(7, "Cherri", "3351 70th Ave East"));
        students.add(new Student(8, "Imani", "1901 Antimony")); // Removed comma after house number
        students.add(new Student(9, "Kim", "3320 John Creighton blvd"));
        students.add(new Student(10, "Richard", "6726 South 81st st")); // Removed comma after house number
        //window title size and what x does
        setTitle("Student Sorter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //descriptors for the table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Roll No");
        tableModel.addColumn("Name");
        tableModel.addColumn("Address");
        studentTable = new JTable(tableModel);
        //tables in a scrollpane
        JScrollPane scrollPane = new JScrollPane(studentTable);
        //button descrptors
        JButton sortByNameButton = new JButton("Sort by Name");
        JButton sortByRollNoButton = new JButton("Sort by Roll No");
        //what buttons do this is the by name button
        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorter.selectionSort(students, new StudentCompar.NameComparator());
                updateTable();
            }
        });
        //this is the by roll number button I dont know why it does it backward
        sortByRollNoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorter.selectionSort(students, new StudentCompar.RollComparator());
                updateTable();
            }
        });
        //where the buttons go
        JPanel buttonPanel = new JPanel(); // Changed Jpanel to JPanel
        buttonPanel.add(sortByNameButton);
        buttonPanel.add(sortByRollNoButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        updateTable();
    }
        //reprints the table
    private void updateTable() {
        // deletes everything in the table
        tableModel.setRowCount(0);

        // prints the table the way the button said
        for (Student student : students) {
            tableModel.addRow(new Object[]{student.getRollno(), student.getName(), student.getAddress()});
        }
        studentTable.repaint();
    }
    //main method ends the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}