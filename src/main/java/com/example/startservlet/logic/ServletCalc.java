package com.example.startservlet.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        double num1 = jObject.get("num1").getAsInt();
        double num2 = jObject.get("num2").getAsInt();
        String oper = jObject.get("oper").getAsString();
        double result=0;
        switch(oper){
            case "*":
                result = num1 * num2;
                break;

            case "/":
                result = num1 / num2;
                break;

            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
        }

        response.setContentType("application/json; charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(result));

    }
}
