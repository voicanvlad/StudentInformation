package GUI.Program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUI.Util.ComparableList;
import GUI.Util.EmptyListExc;
import GUI.Util.FullListExc;
import GUI.Program.Student;

public class GraphicalInterface extends JFrame implements ActionListener {

JFrame frame = new JFrame();
    JLabel frameLabel = new JLabel();
    JButton addButton;
    JButton removeButton;
    JButton sortButton;
    JLabel lastnameLabel;
    JLabel firstnameLabel;
    JLabel AttendanceLabel;
    JLabel listLabel;
    JTextField lastnameText;
    JTextField firstnameText;
    JTextField attendanceText;
    JTextArea listText;
    ComparableList<Student> List;
    JProgressBar progressBar;
    int dimension;
    int numberOfElements;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem saveItem;

    FileReader reader = null;
    FileWriter writer = null;

    GraphicalInterface(int dimension) { 
        this.dimension = dimension;
        if (dimension == 0) {
            JOptionPane.showMessageDialog(null, "Enter a value, bigger than 0", "Incorrect value",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        } else if (dimension < 0) {
            JOptionPane.showMessageDialog(null, "Enter a positive value, bigger than 0", "Incorrect value",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        List = new ComparableList<Student>(dimension,Student.class); 
        menuBar=new JMenuBar();
        frame.setJMenuBar(menuBar);
        fileMenu=new JMenu("File");
        menuBar.add(fileMenu);
        saveItem=new JMenuItem("Save File");
        fileMenu.add(saveItem);
        saveItem.addActionListener(this);

        progressBar = new JProgressBar(0, dimension);
        addButton = new JButton("Add");
        removeButton = new JButton("remove");
        sortButton = new JButton("Sort");

        addButton.setBounds(400, 60, 120, 80);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        addButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(184, 122, 191));
        addButton.setBorder(BorderFactory.createBevelBorder(1));

        removeButton.setBounds(400, 185, 120, 80);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        removeButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        removeButton.setForeground(Color.white);
        removeButton.setBackground(new Color(184, 122, 191));
        removeButton.setBorder(BorderFactory.createBevelBorder(1));

        sortButton.setBounds(400, 310, 120, 80);
        sortButton.setFocusable(false);
        sortButton.addActionListener(this);
        sortButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        sortButton.setForeground(Color.white);
        sortButton.setBackground(new Color(184, 122, 191));
        sortButton.setBorder(BorderFactory.createBevelBorder(1));

        lastnameLabel = new JLabel("Last name:");
        firstnameLabel = new JLabel("First name:");
        AttendanceLabel = new JLabel("Attendance:");
        listLabel = new JLabel("List of students:");

        lastnameLabel.setBounds(35, 10, 90, 50);
        lastnameLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
        lastnameLabel.setBackground(new Color(184, 122, 191));
        lastnameLabel.setOpaque(true);
        lastnameLabel.setForeground(Color.white);

        firstnameLabel.setBounds(35, 70, 90, 50);
        firstnameLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
        firstnameLabel.setBackground(new Color(184, 122, 191));
        firstnameLabel.setOpaque(true);
        firstnameLabel.setForeground(Color.white);

        listLabel.setBounds(145, 190, 160, 50);
        listLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        listLabel.setBackground(new Color(184, 122, 191));
        listLabel.setOpaque(true);
        listLabel.setForeground(Color.white);

        AttendanceLabel.setBounds(35, 130, 90, 50);
        AttendanceLabel.setFont(new Font("Ink Free", Font.BOLD, 17));
        AttendanceLabel.setBackground(new Color(184, 122, 191));
        AttendanceLabel.setOpaque(true);
        AttendanceLabel.setForeground(Color.white);

        lastnameText = new JTextField();
        firstnameText = new JTextField();
        attendanceText = new JTextField();
        listText = new JTextArea();

        lastnameText.setBounds(130, 10, 230, 50);
        lastnameText.setFont(new Font("Ink Free", Font.BOLD, 20));
        lastnameText.setForeground(Color.BLACK);
        lastnameText.setBackground(new Color(251, 223, 255));

        firstnameText.setBounds(130,70,230,50);
        firstnameText.setFont(new Font("Ink Free", Font.BOLD, 20));
        firstnameText.setForeground(Color.BLACK);
        firstnameText.setBackground(new Color(251, 223, 255));

        attendanceText.setBounds(130, 130, 230, 50);
        attendanceText.setFont(new Font("Ink Free", Font.BOLD, 20));
        attendanceText.setForeground(Color.BLACK);
        attendanceText.setBackground(new Color(251, 223, 255));

        listText.setBounds(75, 250, 280, 175);
        listText.setFont(new Font("Ink Free", Font.BOLD, 15));
        listText.setForeground(Color.BLACK);
        listText.setBackground(new Color(251, 223, 255));
        listText.setEditable(false);
        listText.setBorder(BorderFactory.createBevelBorder(1));
        listText.setLineWrap(true);
        listText.setWrapStyleWord(true);

        progressBar.setBounds(400, 400, 120, 30);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Ink Free", Font.BOLD, 10));
        progressBar.setBackground(new Color(251, 223, 255));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setResizable(false);
        frame.setTitle("List of students");
        frameLabel.setBackground(new Color(214, 186, 255));
        frameLabel.setOpaque(true);

        frame.add(frameLabel);
        frameLabel.add(addButton);
        frameLabel.add(removeButton);
        frameLabel.add(sortButton);
        frameLabel.add(lastnameLabel);
        frameLabel.add(AttendanceLabel);
        frameLabel.add(listLabel);
        frameLabel.add(firstnameLabel);
        frameLabel.add(lastnameText);
        frameLabel.add(firstnameText);
        frameLabel.add(attendanceText);
        frameLabel.add(listText);
        frameLabel.add(progressBar);

        frame.setVisible(true);


        BufferedReader inputStream = null;
        Scanner scanner = null;
        try{
            try {
                inputStream = new BufferedReader(new FileReader("Students.txt"));
            } catch (FileNotFoundException e) {
            }
            String l;
            try {
                while((l=inputStream.readLine())!=null){
                    scanner = new Scanner(l);
                    while(scanner.hasNext()){
                        Student newStudent = new Student();
                        newStudent.setStudentLastName(scanner.next());
                        newStudent.setStudentFirstName(scanner.next());
                        newStudent.setStudentAttendance(Integer.parseInt(scanner.next()));
                        try {
                            List.addElements(newStudent);
                        } catch (FullListExc e) {
                        }
                        try {
                            listText.setText(List.showElements());
                        } catch (EmptyListExc e) {
                        }
                        numberOfElements++;
                        progressBarFill();
                    }   
                }
            } catch (IOException e) {
            }
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            if(scanner!=null){
                scanner.close();}
            }
        
        }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==saveItem){
            try {
                writer = new FileWriter("Students.txt");
                writer.write(listText.getText());
                writer.close();
            } catch (IOException e2) {
            }
        }

        try {
            if (e.getSource() == addButton) {
                if(numberOfElements==dimension){
                    JOptionPane.showMessageDialog(null, "The list is full, remove an element", "Error!", JOptionPane.WARNING_MESSAGE);
                    addButton.setEnabled(false);
                } else {
                removeButton.setEnabled(true);
                String lastName = lastnameText.getText();
                String firstName = firstnameText.getText();
                int attendance = Integer.parseInt(attendanceText.getText());
                lastnameText.setText("");
                firstnameText.setText("");
                attendanceText.setText("");
                Student addedStudent = new Student();
                addedStudent.setStudentLastName(lastName);
                addedStudent.setStudentFirstName(firstName);
                addedStudent.setStudentAttendance(attendance);
                List.addElements(addedStudent);
                try {
                    listText.setText(List.showElements());
                } catch (EmptyListExc e1) {
                }
                numberOfElements++;
                progressBarFill();
                if(numberOfElements>1){
                    sortButton.setEnabled(true);
                }
            }}
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Fill the required fields first!", "Error!",
                    JOptionPane.WARNING_MESSAGE);
        } catch (FullListExc e1) {
        }

        if (e.getSource() == removeButton) {
            if(numberOfElements==0){
                JOptionPane.showMessageDialog(null, "The list is empty, add an element", "Error!", JOptionPane.WARNING_MESSAGE);
                removeButton.setEnabled(false);
            } else {
            try {
                List.removeElements();
                listText.setText(List.showElements());
            } catch (EmptyListExc e1) {
            }
            numberOfElements--;
            progressBarFill();
            addButton.setEnabled(true);

        }}

        if (e.getSource() == sortButton) {
            if (numberOfElements == 0) {
                JOptionPane.showMessageDialog(null, "The list is empty, add at least 2 elements", "Error!", JOptionPane.WARNING_MESSAGE);
                sortButton.setEnabled(false);
            }
            else{
            try {
                List.sortElements();
                listText.setText(List.showElements());
            } catch (EmptyListExc e1) {
            }
            }
        }
    }

    public void progressBarFill() {
        if (numberOfElements <= (dimension / 2)) {
            progressBar.setForeground(Color.green);
            progressBar.setValue(numberOfElements);
        } else {
            progressBar.setForeground(Color.red);
            progressBar.setValue(numberOfElements);
        }
    }
}
