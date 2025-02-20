package Servlet;

import DAO.AnnonceDAOV2;
import Bean.Annonce;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

import Connection.ConnectionDB;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String annonceId = request.getParameter("id");

        if (annonceId != null) {
            try {
                Connection connection = ConnectionDB.getInstance();

                AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();
                Annonce annonce = annonceDAO.find(Integer.parseInt(annonceId));

                if (annonce != null) {
                    request.setAttribute("annonce", annonce);
                    request.getRequestDispatcher("/jsp/AnnonceUpdate.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Annonce non trouvée.");
                    request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("message", "Erreur lors de la récupération de l'annonce.");
                request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "ID d'annonce invalide.");
            request.getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Annonce annonce = new Annonce();

            annonce.setId(Integer.parseInt(request.getParameter("id")));
            annonce.setTitle(request.getParameter("title"));
            annonce.setDescription(request.getParameter("description"));
            annonce.setAdress(request.getParameter("adress"));
            annonce.setMail(request.getParameter("mail"));

            Connection connection = ConnectionDB.getInstance();
            AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();
            annonceDAO.update(annonce);

            annonce = annonceDAO.find(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("annonce", annonce);

            this.getServletContext().getRequestDispatcher("/jsp/AnnonceRead.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erreur lors de la mise à jour !");
            request.getRequestDispatcher("/jsp/AnnonceUpdate.jsp").forward(request, response);
        }
    }


}
