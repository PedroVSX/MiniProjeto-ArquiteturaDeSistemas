package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final String STUDENT_API_URL = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";
    private final HttpClient client = HttpClient.newHttpClient();
    private final JsonParser<Student> parser = new StudentJsonParser();
    private final List<Student> studentList = new ArrayList<>();

    public StudentService() {
        loadAllStudents();
    }

    public void loadAllStudents() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(STUDENT_API_URL))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Student> students = parser.parse(response.body());

            studentList.clear();
            studentList.addAll(students);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public List<Student> getStudentsByCourseAndModality(String course, String modality) {
        boolean modalityBool = modality.equalsIgnoreCase("EAD"); // Se false: presencial, senão: EAD

        return studentList.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase(course) && student.getModality() == modalityBool)
                .toList();
    }

    public List<Student> getStudentsByCourse(String course) {
        return studentList.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase(course))
                .toList();
    }

    public List<Student> getStudentsByModality(String modality) {
        boolean modalityBool = modality.equalsIgnoreCase("EAD"); // Se false: presencial, senão: EAD

        return studentList.stream()
                .filter(student -> student.getModality() == modalityBool)
                .toList();
    }

    public List<Student> getStudentsByName(String name) {
        return studentList.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .toList();
    }

    public List<Student> getStudentsById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .toList();
    }

    public List<Subject> getSubjectsByStudentId(int id) {
        Student student = getStudentsById(id).getFirst();

        return student.getEnrolledSubjects();
    }

    public List<Book> getBooksByStudentId(int id) {
        Student student = getStudentsById(id).getFirst();

        return student.getReservedBooks();
    }

}
