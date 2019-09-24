package model;


public class User {
    public String login;
    public String password;
    public String nomComplet;
    public String profil;


    public User(String login, String password, String nomComplet, String profil) {
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        this.profil = profil;
    }
    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nom) {
        this.nomComplet = nom;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
