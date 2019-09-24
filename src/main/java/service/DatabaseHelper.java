package service;/*
 * To change this template, choose Tools | Templates
 * data access object
 */



import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 * @author baye niass
 */
public class DatabaseHelper {
    
    Connection cn;
    Statement stmt;
    private PreparedStatement pstmt;
    private static DatabaseHelper db;
    public static DatabaseHelper getInstance() throws Exception {
        if(db== null){
            db = new DatabaseHelper();
        }
        return db;
    }
    
    private void getConnexion() throws Exception{
        if(cn==null){
            //InputStream info =getClass().getResourceAsStream("/properties/props.properties");
            try {
                //Properties p=new Properties();
                //p.load(info);
                String login="root";
                String pass="kunya";
                String url="jdbc:mysql://localhost:3306/tomcat?useSSL=false";
                String driver="com.mysql.jdbc.Driver";
                Class.forName(driver);
                cn=DriverManager.getConnection(url,login,pass);
                
            } catch (Exception ex) {
                throw ex;
            }
        }
        
        
    }
    private DatabaseHelper() throws Exception{
        getConnexion();
    }
    public void beginTransaction() throws Exception{
        try {
            cn.setAutoCommit(false);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    public void endTransaction() throws Exception{
        try {
            cn.setAutoCommit(true);
            
        } catch (Exception ex) {
            throw ex;
        }
    }
    // pour les requete insert update delete 
    public int My_ExecuteUpdate(String sql) throws Exception{
        int nbRows=0;
        try {
            getConnexion();
            if(stmt==null || stmt.isClosed())
            {
                stmt =cn.createStatement();
            }
            nbRows=stmt.executeUpdate(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
        return nbRows;
    }
    // pour les select !!
    public ResultSet My_ExecuteQuery(String sql) throws Exception{
        
        ResultSet rs=null;
      try {
            getConnexion();
            if(stmt==null || stmt.isClosed())
            {
                stmt =cn.createStatement();
            }
            rs=stmt.executeQuery(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
        return rs;
    }
    // preparation de l'exucution de la requete paramétré
    public void iniPreparedCmd(String sql) throws Exception{
        
        try {
            getConnexion();
            if(sql.toLowerCase().trim().startsWith("insert"))
                pstmt=cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            else
                pstmt=cn.prepareStatement(sql);
        } catch (Exception ex) {
            throw ex;
        }
                
    }
    //execution de la requete paramétré (insert, update, delete)
    public int My_ExecutePrepareUpdate() throws Exception{
        
        int nbRows=0;
        try {
            getConnexion();
            nbRows=getPstmt().executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        return nbRows;  
    }
    //execution de la requete paramétré (select)
    public ResultSet My_ExecutePrepareQuery() throws Exception{
        
        ResultSet rs=null;
        try {
            getConnexion();
            rs=getPstmt().executeQuery();
        } catch (Exception ex) {
            throw ex;
        }
        return rs;
    }
    // avant de femer verifier si stmt, pstmt et cn sont ouvert 
    public void FermerConnexion() throws Exception{
        try {
            if(stmt!=null || !stmt.isClosed()){
                 stmt.close();
                 stmt=null;
            }
               
            if(getPstmt()!=null || !pstmt.isClosed()){
                getPstmt().close();
                pstmt=null;
            }
                
            if(cn!=null || !cn.isClosed()){
                 cn.close();
                 cn=null;
            }
               
        } catch (Exception ex) {
            throw ex;
        }
    }
    public void My_Commit() throws Exception{
        try {
            cn.commit();
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    public void My_Rollback() throws Exception{
        try {
            cn.rollback();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * @return the pstmt
     */
    public PreparedStatement getPstmt() {
        return pstmt;
    }
    
    public int Insert(String table, String[] colonne, String[] values) throws Exception{
        String cols = Arrays.stream(colonne).collect(Collectors.joining(", "));
        String vals = Arrays.stream(values).collect(Collectors.joining(", "));
        String sql = "insert into "+table+"("+cols+") values"+" ("+vals+")";
        int nbrows = 0;
        try {
            nbrows = My_ExecuteUpdate(sql);
        } catch (Exception e) {
            throw e;
        }
        return nbrows;
    }
    
    public ResultSet My_Select(String table, String cols, String critere) throws Exception{
      String sql = "select "+cols+" from "+table;
      if(!critere.equals(""))
          sql += " where "+critere;
      ResultSet rs=null;
      try {
            rs=My_ExecuteQuery(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
        return rs;
    }
    
    
}
