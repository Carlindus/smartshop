/**
 * 
 */
package presentation.utilisateur.bean;

/**
 * Repr�sente l'utilisateur connect� � l'application, rep�r� par son idUtilisateur
 * 
 * @author David
 * 
 */
public class ConnectedUserDto {

    private int     id;
    private String  login;
    private boolean isAdmin;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id:
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the isAdmin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin:
     *            the isAdmin to set
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
