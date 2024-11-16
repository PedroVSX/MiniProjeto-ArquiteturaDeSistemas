package com.miniprojeto.Microservices;

import com.miniprojeto.Model.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentJsonParser implements JsonParser<Student> {

    @Override
    public List<Student> parse(String responseBody) {
        JSONArray studentsJsonArray = new JSONArray(responseBody);
        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < studentsJsonArray.length(); i++) {
            JSONObject studentObj = studentsJsonArray.getJSONObject(i);
            Student student = new Student(
                    studentObj.getInt("id"),
                    studentObj.getString("nome"),
                    studentObj.getString("curso"),
                    studentObj.getString("modalidade").equalsIgnoreCase("EAD"),
                    studentObj.getString("status").equalsIgnoreCase("Ativo")
            );

            studentsList.add(student);
        }

        return studentsList;
    }

}
