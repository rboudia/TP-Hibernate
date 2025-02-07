package Servlet;

import Bean.Annonce;
import DAO.DAO;
import DAO.AnnonceDAO;
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

    public AnnonceAdd() {
        super();
    }

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

                DAO<Annonce> annonceDAO = new AnnonceDAO(connection);

                boolean success = annonceDAO.create(annonce);
                if (success) {
                    request.setAttribute("message", "Annonce added successfully");
                    // Charger la liste des annonces
                    ArrayList<Annonce> annonceList = annonceDAO.list();
                    request.setAttribute("annonceList", annonceList);

                    // Redirection interne vers la liste des annonces
                    this.getServletContext().getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("message", "Error exception");
                this.getServletContext().getRequestDispatcher("/jsp/AnnonceAdd.jsp").forward(request, response);
                e.printStackTrace();
            }
        }


        this.getServletContext().getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
    }
}
