package DAO;

import Bean.Annonce;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {

    public AnnonceDAO(Connection connection) {
        super(connection);
    }

    public boolean create(Annonce obj) {
        try {

            PreparedStatement prepare = this.connection
                    .prepareStatement("INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)");

            prepare.setString(1, obj.getTitle());
            prepare.setString(2, obj.getDescription());
            prepare.setString(3, obj.getAdress());
            prepare.setString(4, obj.getMail());
            prepare.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(Annonce obj) {
        try {
            this.connection
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeUpdate("DELETE FROM annonce WHERE id = " + obj.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean update(Annonce obj) {
        try {
            PreparedStatement prepare = this.connection
                    .prepareStatement("UPDATE annonce SET title = ?, description = ?, adress = ?, mail = ?, date = ? WHERE id = ?");

            prepare.setString(1, obj.getTitle());
            prepare.setString(2, obj.getDescription());
            prepare.setString(3, obj.getAdress());
            prepare.setString(4, obj.getMail());
            prepare.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            prepare.setLong(6, obj.getId());


            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public Annonce find(int id) {
        Annonce annonce = new Annonce();

        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM annonce WHERE id = " + id);

            if (result.first())
                annonce = new Annonce(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getString("mail"),
                        result.getTimestamp("date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return annonce;
    }


    public ArrayList<Annonce> list() {

        ArrayList<Annonce> annonceList = new ArrayList<Annonce>();
        Annonce annonce = new Annonce();

        try {
            ResultSet result = this.connection.createStatement()
                    .executeQuery("SELECT * FROM annonce");

            while (result.next()) {
                annonce = new Annonce(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getString("mail"),
                        result.getTimestamp("date"));

                annonceList.add(annonce);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return annonceList;

    }
}
