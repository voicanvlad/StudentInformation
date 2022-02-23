package GUI.Program;


    public class Student implements Comparable<Student>{
    private String studentFirstName;
    private String studentLastName;
    private int studentAttendance;
   
 
     public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
         return studentLastName;
     }
 
     public void setStudentLastName(String studentLastName) {
         this.studentLastName = studentLastName;
     }
 
     public int getStudentAttendance() {
         return studentAttendance;
     }
 
     public void setStudentAttendance(int studentAttendance) {
         this.studentAttendance = studentAttendance;
     }
 
     @Override
     public String toString() {
         return studentLastName+" "+studentFirstName+" "+studentAttendance;
     }

    @Override
    public int compareTo(Student comparableElement) {
        Student conversion = (Student) comparableElement;
        if(studentAttendance>conversion.studentAttendance){
            return 1;
        } else if(studentAttendance==conversion.studentAttendance){
            return 0;
        } else {
            return -1;
        }
    }
 }

