import java.util.ArrayList;
import java.util.List;

/**
 * A class to encapsulate the basic information of a student.
 * The basic information includes the student ID, name and GPA.
 */
class Student {
    /**
     * This is the student ID
     */
    String stuID;
    /**
     * This is the name of the student
     */
    String name;
    /**
     * This is the GPA of the student
     */
    float GPA;

    /* TODO: change this comment block to doc comment. (Remember to add explanation for the parameters)
     * This method is the constructor of a Student object. You can use this method to construct a Student.
     * The parameters include a {@link String} to represent student ID, a {@link String} to name and a double to represent GPA score of the student.
     */
    /**
     * This method is the constructor of a Student object. You can use this method to construct a Student.
     * @param stuID {@link String} This is the student ID
     * @param name {@link String} This is the name of the student
     * @param GPA double This is the GPA of the student
     */
    public Student(String stuID, String name, float GPA) {
        this.stuID = stuID;
        this.name = name;
        this.GPA = GPA;
    }

    /**
     * Returns the student ID of the Student
     * @return student ID of the Student
     */
    public String getStuID() {
        return stuID;
    }

    /**
     * Returns the name of the Student
     * @return name of the Student
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the GPA score of the Student
     * @return A float GPA score
     */
    public float getGPA() {
        return GPA;
    }

    /**
     *Sets the GPA score of the Student to the new GPA score specified by the parameter GPA
     * @param GPA the new GPA score of the student
     */
    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student ID: " ).append(stuID).append("\n");
        builder.append("Student name: ").append(name).append("\n");
        builder.append("Student GPA: ").append(GPA).append("\n\n");
        return builder.toString();
    }
}

/** 
 * This class is the major class for the JavaDoc Lab in COMP3111
 *
 * @author Kristian Suhartono
 * @since 20-11-2017
 */
public class JavaDocLab {

    /*TODO: change this comment block to doc comment. (Remember to add explanation for the parameters)
     *
     * This method sort the students in a student list (parameter) by their student ID in alphabetical order
     * It takes the student list as parameter and sorts the input list.
     */
    /**
     * This method sort the students in a student list (parameter) by their student ID in alphabetical order
     * It takes the student list as parameter and sorts the input list.
     * @param studentList A List of Students that is going to be sorted
     */
    public static void sortByStuId(List<Student> studentList) {

    }


    /**
     * Returns the highest GPA student among all the students in the list
     * @param studentList The list that is going to be searched
     * @return Student object of the student with the highest GPA
     */
    public static Student getHighestGPA(List<Student> studentList) {
        float max = -1f;
        Student highestGPAStudent = null;
        for (Student student : studentList) {
            float GPA = student.getGPA();
            if (GPA > max) {
                max = GPA;
                highestGPAStudent = student;
            }
        }

        return highestGPAStudent;
    }

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("20170000", "Tom", 3.0f));
        studentList.add(new Student("20170003", "Jerry", 3.8f));
        studentList.add(new Student("20170006", "Spark", 3.5f));

        System.out.println("The student list contains " + studentList.size() + " students:\n");

        for (Student student : studentList) {
            System.out.println(student);
        }

        Student highestGPAStu = getHighestGPA(studentList);

        if (highestGPAStu != null) {
            System.out.println(highestGPAStu.getName() + " has the highest GPA: " + highestGPAStu.getGPA());
        }
    }
}
