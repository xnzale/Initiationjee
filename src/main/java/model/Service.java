package model;


import java.util.*;

public class Service {
    private int id;
    private String lib;

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Employe e) {
        List<Employe> employes = new ArrayList<Employe>();
        employes.add(e);
        this.employes = employes;
    }

    private List<Employe> employes = new ArrayList<Employe>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

}
