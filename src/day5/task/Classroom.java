package day5.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Classroom {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, int score){
        students.add(new Student(id, name, score));
    }

    public List<Student> getStudents(){
        return students;
    }

    public Optional<Student> findById(int id){
        return students.stream()
                .filter(stds -> stds.getId() == id).findFirst();
    }

    public List<Student> getPassedStudents(){
        return students.stream()
                .filter(stds -> stds.getPassStatus() == PassStatus.PASSED)
                .toList();
    }

    public Optional<Student> findTopStudent(){
        return students.stream()
                .max(Comparator.comparing(Student::getScore));
    }

    public List<Student> searchByName(String name){
        return students.stream()
                .filter(stds -> stds.getName().equals(name))
                .toList();
    }
}