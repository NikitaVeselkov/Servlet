package com.example.startservlet;

import com.example.startservlet.logic.Model;
import com.example.startservlet.logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Model model = Model.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if (id == 0){
            pw.println("<html>" +
                    "<h3>Доступные пользователи </h3>"+
                    "ID пользователя: "+
                    "<ul>"
                    );


        for(Map.Entry<Integer, User> entry: model.getFromList().entrySet()){
            pw.print("<li>" + entry.getKey() + "</li>"+
                    "<ul>" +
                    "<li> Имя " + entry.getValue().getName()+ "</li>" +
                    "<li> Фамилия " + entry.getValue().getFam() + "</li>"+
                    "<li> Зарплата " + entry.getValue().getSalary() + "</li>"+
                    "</ul>");
        }
        pw.print("</ul>" +
                "<a href= \"index.jsp\">Домой</a>" +
                "</html>");
        } else if (id > 0){
            if (id > model.getFromList().size()){
                pw.print("<html>" +
                        "<h3>Такого пользователя не существует</h3>"+
                                "<a href= \"index.jsp\">Домой</a>" +
                                "</html>");
            } else {
                pw.print("<html>" +
                        "<h3>Запрошенный пользователь </h3>"+
                        "</br>" +
                        "Имя: "+ model.getFromList().get(id).getName()+ "</br>" +
                        "Фамилия: "+ model.getFromList().get(id).getFam()+ "</br>" +
                        "Зарплата : "+ model.getFromList().get(id).getSalary() + "</br>" +
                        "<a href= \"index.jsp\">Домой</a>" +
                        "</html>");
            }

        } else {
            pw.print("<html>" +
                    "<h3>ID должен быть больше нуля</h3>"+
                    "<a href= \"index.jsp\">Домой</a>" +
                    "</html>");
        }
            */

        response.setContentType("application/json; charset=UTF-8");
        //int id =Integer.parseInt(request.getReader().readLine() );
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter pw = response.getWriter();
        if (id == 0){
            pw.print(gson.toJson(model.getFromList()));
        }
        else if(id>0) {
            if (id > model.getFromList().size()) {
                pw.print(gson.toJson("Такого пользователя не существует"));
            } else {
                pw.print(gson.toJson(model.getFromList().get(id)));

            }
        }
        else{
            pw.print(gson.toJson("ID должен быть больше нуля"));
        }


    }
}
