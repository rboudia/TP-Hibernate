package DAO;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {

    protected Connection connection = null;

    /**
     * Constructeur
     * @param connection
     */
    public DAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Méthode de création d'item
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer un item
     * @param obj
     * @return
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche d'un item
     * @param id
     * @return
     */
    public abstract T find(int id);

    public abstract ArrayList<T> list();
}
