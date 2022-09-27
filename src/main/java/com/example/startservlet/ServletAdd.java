package com.example.startservlet;

import com.example.startservlet.logic.Model;
import com.example.startservlet.logic.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/add")
public class ServletAdd extends HttpServlet {
    private AtomicInteger counter = new AtomicInteger(4);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Model model = Model.getInstance();


   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Double salary =Double.parseDouble( request.getParameter("salary"));
        User user = new User(name,surname,salary);
        model.add(user,counter.getAndIncrement());
        pw.println("<html>" +
                "<h3> Пользователь " + name+ " " + surname + "с зарплатой  " + salary + "успешно создан"+ "</h3>"+
                "<a href = \"addUser.html\" > Создать нового пользователя </a> </br>"+
                "<a href = \"index.jsp\" > Домой </a> </br>"+
                "</html>");


    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");

        String name= request.getParameter("name");
        String surname= request.getParameter("surname");
        Double salary= Double.parseDouble(request.getParameter("salary"));

        User user = new User(name,surname,salary);
        model.add(user,counter.getAndIncrement());


        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));

    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json; charset=UTF-8");

        StringBuffer jb  = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            //while ((line = reader.readLine() )!= null){
            while ((line = reader.readLine() )!= null){
                jb.append(line);
                System.out.println(jb);

            }
        }catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jObject = gson.fromJson(String.valueOf(jb), JsonObject.class);



        String name= jObject.get("name").getAsString();
        String surname= jObject.get("surname").getAsString();
        double salary= jObject.get("salary").getAsDouble();


        User user = new User(name,surname,salary);
        model.add(user,counter.getAndIncrement());


        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));
    }
}
