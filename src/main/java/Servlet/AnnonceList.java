package Servlet;

import Bean.Annonce;
import DAO.AnnonceDAOV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AnnonceDAOV2 annonceDAO = new AnnonceDAOV2();
            ArrayList<Annonce> annonceList = annonceDAO.list();

            request.setAttribute("annonceList", annonceList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/jsp/AnnonceList.jsp").forward(request, response);
    }


}
