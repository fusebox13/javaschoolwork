package CPS261SortedMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Student   // Used for Key to HashMap
{
    String firstName;
    String lastName;
    int birthMonth, birthDay, birthYear;
    
    Student(String f, String l, int m, int d, int y)
    {
        firstName = f;
        lastName = l;
        birthMonth = m;
        birthDay = d;
        birthYear =y;
    }
    public String toString()
    {
        return firstName+" "+ lastName + " "+ birthMonth+" "+ birthDay+" "+ birthYear;
    }
    int MyStringHashCode(String s)
    {
        int h = 1;
        for (int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c != 0)
                h *= c;
        }
        return h;
    }
    
    
    public int hashCode()
    {
// Note the alternative for computing hashCode for a String.
        //int h = firstName.hashCode() * lastName.hashCode();
        int h = MyStringHashCode(firstName) * MyStringHashCode(lastName);
        if (birthMonth != 0)
            h *= birthMonth;
        if (birthDay != 0)
            h *= birthDay;
        if (birthYear != 0)
            h *= birthYear;
        return h;
    }
    
   
    
   
    public boolean equals(Object obj)
    {
        Student s= (Student)obj;
        if (firstName.equals(s.firstName) &&
            lastName.equals(s.lastName) &&
            birthMonth == s.birthMonth &&
            birthDay == s.birthDay &&
            birthYear == s.birthYear) 
            return true;
        else
            return false;
    }
    
}


class Record  // Used for the Value in the HashMap
{
    String major;
    double gpa;
    ArrayList<CourseGrade> listOfCourses = new ArrayList<CourseGrade>();
    
    Record(String major)
    {
        this.major = major;
    }
    
    public String toString()
    {
        return major + " " + String.format("gpa=%.2f", gpa)+ " courses="+listOfCourses;
    }
    
    void addCourse(String courseName, double grade, int credits)
    {
        listOfCourses.add(new CourseGrade(courseName, grade,credits));
        double totalGrade=0;
        int totalCredits =0;
        for (int i=0; i < listOfCourses.size(); i++)
        {
            CourseGrade cg = listOfCourses.get(i);
            totalGrade += cg.grade*cg.credits;
            totalCredits += cg.credits;
        }
        gpa = totalGrade/totalCredits;
    }
    // ********************  Inner class
    class CourseGrade
    {
        String courseName;
        double grade;
        int credits;
        
        CourseGrade(String courseName, double grade, int credits)
        {
            this.courseName =courseName;
            this.grade =grade;
            this.credits = credits;
        }
        public String toString()
        {
            return courseName +" grade="+grade +" credits="+credits;
        }
    }
    // *******************  End of Inner class
    
} // End of Record class


public class StudentRecords {
    HashMap<Student, Record> records = new HashMap<Student, Record>();
    
    void process()
    {
         if (!addRecords("student_records.txt"))
         {
             System.out.println("Exitting due to error in student_records.txt");
             return;
         }
         
         Student student1 = new Student("Frank", "Thomas", 4, 20, 1990);
         if (records.containsKey(student1))
             System.out.println("Student Found");
         else
         {
             System.out.println("Student NOT Found: "+ student1);
             records.put(student1, new Record("Math"));
         }
         
         Set<Student> keys = records.keySet();
         Iterator<Student> iter = keys.iterator();
         while(iter.hasNext())
         {
             Student s = iter.next();
             Record r = records.get(s);
             System.out.println("Student="+ s);
             System.out.println("Record="+r);
         }
    }
    
    
    boolean addRecords(String filename)
    {
        Scanner input ;
        try {
            FileInputStream fi = new FileInputStream(filename);
            input = new Scanner(fi);
        } catch (FileNotFoundException e) {
            System.out.println("addRecords error:" + e);
            return false;
        }
        Student student=null;
        Record record=null;
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            StringTokenizer parse = new StringTokenizer(line);
            int count = parse.countTokens();
            switch(count)
            {
            case 3:
                if (record == null)
                {
                    System.out.println("No record class for: "+ line);
                    return false;
                }
                String subject = parse.nextToken();
                double grade = Double.parseDouble(parse.nextToken());
                int numCredits = Integer.parseInt(parse.nextToken());
                record.addCourse(subject, grade, numCredits);
                break;
            case 6:
                if (student != null)
                {
                    records.put(student, record);
                }
                String firstName = parse.nextToken();
                String lastName = parse.nextToken();
                int month = Integer.parseInt(parse.nextToken());
                int day = Integer.parseInt(parse.nextToken());
                int year = Integer.parseInt(parse.nextToken());
                String major = parse.nextToken();
                student = new Student(firstName, lastName, month, day, year);
                record = new Record(major);
                break;
            default:
                System.out.println("Bad line: " + line);
                return false;
            }
            if (student != null)
                records.put(student, record);
            
        }
       
        
        input.close();
        return true;
    }

    public static void main(String[] args)
    {
        StudentRecords sr = new StudentRecords();
        sr.process();
    
    }

}