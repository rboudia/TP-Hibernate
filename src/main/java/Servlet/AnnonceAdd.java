package Servlet;

import Bean.Annonce;
import DAO.AnnonceDAOV2;
import Connection.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/AnnonceAdd")
public class AnnonceAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/AnnonceAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Annonce annonce = new Annonce();

        annonce.setTitle(request.getParameter("title"));
        annonce.setDescription(request.getParameter("description"));
        annonce.setAdress(request.getParameter("adress"));
        annonce.setMail(request.getParameter("mail"));

        if (request.getParameter("title") == null) {
            request.setAttribute("annonce", annonce);
        } else {
            try {
                Connection connection = ConnectionDB.getInstance();

                AnnonceDAOV2 annonceDAOV2 = new AnnonceDAOV2();

                boolean success = annonceDAOV2.create(annonce);
                if (success) {
                    request.setAttribute("message", "Annonce ajouté avec succès!");
                    ArrayList<Annonce> annonceList = annonceDAOV2.list();
                    request.setAttribute("annonceList", annonceList);

                    this.getServletContext().getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("message", "Une erreur est survenue");
                this.getServletContext().getRequestDispatcher("/jsp/AnnonceAdd.jsp").forward(request, response);
                e.printStackTrace();
            }
        }


        this.getServletContext().getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
    }
}
