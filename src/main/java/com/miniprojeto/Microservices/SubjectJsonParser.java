package com.miniprojeto.Microservices;

import com.miniprojeto.Model.Subject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SubjectJsonParser implements JsonParser<Subject> {

    @Override
    public List<Subject> parse(String responseBody) {
        JSONArray subjectsJsonArray = new JSONArray(responseBody);
        List<Subject> subjectsList = new ArrayList<>();

        for (int i = 0; i < subjectsJsonArray.length(); i++) {
            JSONObject subjectObj = subjectsJsonArray.getJSONObject(i);
            Subject subject = new Subject(
                    subjectObj.getInt("id"),
                    subjectObj.getString("curso"),
                    subjectObj.getString("nome")
            );

            subjectsList.add(subject);
        }

        return subjectsList;
    }

}
