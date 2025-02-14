package Servlet;

import Bean.Annonce;
import Connection.ConnectionDB;
import DAO.AnnonceDAOV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;




@WebServlet("/AnnonceRead")
public class AnnonceRead extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String annonceId = request.getParameter("id");

        if (annonceId != null) {
            try {
                Connection connection = ConnectionDB.getInstance();

                AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();
                Annonce annonce = annonceDAO.find(Integer.parseInt(annonceId));

                if (annonce != null) {
                    request.setAttribute("annonce", annonce);
                    request.getRequestDispatcher("/jsp/AnnonceRead.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Annonce non trouvée.");
                    request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", "ID d'annonce invalide.");
            request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
        }
    }
}
