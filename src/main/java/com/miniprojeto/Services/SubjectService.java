package com.miniprojeto.Services;

import com.miniprojeto.Model.Subject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class SubjectService implements ISubjectService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final JsonParser<Subject> parser = new SubjectJsonParser();
    private final List<Subject> subjectList = new ArrayList<>();

    public SubjectService() {
        loadAllSubjects();
    }

    @Override
    public void loadAllSubjects() {
        String SUBJECT_API_URL = "https://sswfuybfs8.execute-api.us-east-2.amazonaws.com/disciplinaServico/msDisciplina";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SUBJECT_API_URL))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Subject> subjects = parser.parse(response.body());

            subjectList.clear();
            subjectList.addAll(subjects);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectList;
    }

    @Override
    public List<Subject> getSubjectsById(int id) {
        return subjectList.stream()
                .filter(subject -> subject.getId() == id)
                .toList();
    }

    @Override
    public List<Subject> getSubjectsByName(String name) {
        return subjectList.stream()
                .filter(subject -> subject.getName().equalsIgnoreCase(name))
                .toList();
    }

}
