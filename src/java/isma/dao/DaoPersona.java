/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isma.dao;

import isma.model.Persona;
import isma.tools.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isma
 */
public class DaoPersona extends DBConnection {

    public void addPersona(Persona persona) {
        String query = "insert into persona values(?,?)";
        boolean result = false;
        try {
            this.Conexion();
            PreparedStatement ps = this.getConn().prepareStatement(query);
            ps.setString(1, persona.getName());
            ps.setString(2, persona.getLname());
            result = ps.executeUpdate() == 1;
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error " + DaoPersona.class.getName());
            ex.printStackTrace();
        } finally {
            try {
                this.closeConnections();
            } catch (SQLException ex) {
                System.out.println("Error finally " + DaoPersona.class.getName());
                ex.printStackTrace();
            }
        }
    }

    public List<Persona> getPersonas() {
        List<Persona> list = null;
        String query = "select * from persona";
        try {
            this.Conexion();
            PreparedStatement ps = this.getConn().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Persona persona = null;
            list = new LinkedList<>();
            while (rs.next()) {
                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(persona);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + DaoPersona.class.getName());
            ex.printStackTrace();
        } finally {
            try {
                this.closeConnections();
            } catch (SQLException ex) {
                Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    public void updatePersona(Persona persona) {
        String query = "UPDATE persona set name=?, lname=? WHERE  idPersona = ?";
        try {
            this.Conexion();
            PreparedStatement ps = this.getConn().prepareStatement(query);
            ps.setString(1, persona.getName());
            ps.setString(2, persona.getLname());
            ps.setInt(3, persona.getIdPersona());
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                this.closeConnections();
            } catch (SQLException ex) {
                Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void deletePersona(Persona persona) {
        String query = "delete persona WHERE idPerson = ?";
        try {
            this.Conexion();
            PreparedStatement ps = this.getConn().prepareStatement(query);
            ps.setInt(1, persona.getIdPersona());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                this.closeConnections();
            } catch (SQLException ex) {
                System.out.println("Error deletePersona finally " + ex.getMessage());
            }
        }
    }

}
