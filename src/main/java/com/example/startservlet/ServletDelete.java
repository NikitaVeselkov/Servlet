package com.example.startservlet;

import com.example.startservlet.logic.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Model model = Model.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id") );

        model.getFromList().remove(id);
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print("Success");
        pw.print(gson.toJson(model.getFromList()));
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{


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

        Integer id = jObject.get("id").getAsInt();
        model.getFromList().remove(id);

        response.setContentType("application/json; charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));

    }


}
