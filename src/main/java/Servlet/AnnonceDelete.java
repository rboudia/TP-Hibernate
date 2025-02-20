package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import Bean.Annonce;
import Connection.ConnectionDB;
import DAO.AnnonceDAOV2;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                request.setAttribute("message", "ID invalide !");
                request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
                return;
            }

            int annonceId = Integer.parseInt(idParam);

            Connection connection = ConnectionDB.getInstance();
            AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();

            Annonce annonce = annonceDAO.find(annonceId);

            boolean success = annonceDAO.delete(annonce);

            if (success) {
                request.setAttribute("message", "Annonce supprimée avec succès !");
            } else {
                request.setAttribute("message", "Erreur lors de la suppression !");
            }

            ArrayList<Annonce> annonceList = annonceDAO.list();
            request.setAttribute("annonceList", annonceList);

            request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Une erreur est survenue !");
            request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
        }
    }
}
