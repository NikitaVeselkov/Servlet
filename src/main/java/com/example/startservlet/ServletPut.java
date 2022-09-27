package com.example.startservlet;

import com.example.startservlet.logic.Model;
import com.example.startservlet.logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Model model = Model.getInstance();

        StringBuffer jb  = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine() )!= null){
                jb.append(line);
            }
        }catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jObject = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");
        int id = jObject.get("id").getAsInt();
        String name= jObject.get("name").getAsString();
        String surname= jObject.get("surname").getAsString();
        double salary= jObject.get("salary").getAsDouble();

        User user = new User(name,surname,salary);
        model.add(user,id);

        response.setContentType("application/json; charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));
    }
}
