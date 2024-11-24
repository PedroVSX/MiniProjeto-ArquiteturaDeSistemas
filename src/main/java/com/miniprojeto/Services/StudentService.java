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

public class StudentService implements IStudentService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final JsonParser<Student> parser = new StudentJsonParser();
    private final List<Student> studentList = new ArrayList<>();

    public StudentService() {
        loadAllStudents();
    }

    @Override
    public void loadAllStudents() {
        String STUDENT_API_URL = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";
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
    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public List<Student> getStudentsByCourseAndModality(String course, String modality) {
        boolean modalityBool = modality.equalsIgnoreCase("EAD"); // Se false: presencial, senão: EAD

        return studentList.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase(course) && student.getModality() == modalityBool)
                .toList();
    }

    @Override
    public List<Student> getStudentsByCourse(String course) {
        return studentList.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase(course))
                .toList();
    }

    @Override
    public List<Student> getStudentsByModality(String modality) {
        boolean modalityBool = modality.equalsIgnoreCase("EAD"); // Se false: presencial, senão: EAD

        return studentList.stream()
                .filter(student -> student.getModality() == modalityBool)
                .toList();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentList.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public List<Student> getStudentsById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .toList();
    }

    @Override
    public List<Subject> getSubjectsByStudentId(int id) {
        Student student = getStudentsById(id).getFirst();

        return student.getEnrolledSubjects();
    }

    @Override
    public List<Book> getBooksByStudentId(int id) {
        Student student = getStudentsById(id).getFirst();

        return student.getReservedBooks();
    }

}
