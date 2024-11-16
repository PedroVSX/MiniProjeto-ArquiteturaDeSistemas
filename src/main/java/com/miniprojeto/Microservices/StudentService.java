package com.miniprojeto.Microservices;

import com.miniprojeto.Model.Student;

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
    private List<Student> studentList = new ArrayList<>();

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

}
