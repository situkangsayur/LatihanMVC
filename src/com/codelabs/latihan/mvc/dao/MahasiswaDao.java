/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.latihan.mvc.dao;

import com.codelabs.latihan.mvc.entities.MahasiswaEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendri
 */
public class MahasiswaDao {

    private Connection conn;
    private String insert = "insert into mhs(nim,nama,alamat)"
            + " values(?,?,?)";
    private String update = "update mhs set"
            + " nama = ?,"
            + " alamat = ?"
            + " where nim = ?";
    private String delete = "delete from mhs where nim = ?";
    private String cari = "select * from mhs where nim = ?";
    private String selectAll = "select * from mhs";

    public MahasiswaDao() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa",
                        "root", "rahasia");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void insertData(MahasiswaEntity mahasiswa) {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = conn.prepareStatement(insert);
            insertStatement.setString(1, mahasiswa.getNim());
            insertStatement.setString(2, mahasiswa.getNama());
            insertStatement.setString(3, mahasiswa.getAlamat());
            insertStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void updateData(MahasiswaEntity mahasiswa) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = conn.prepareStatement(update);
            updateStatement.setString(1, mahasiswa.getNama());
            updateStatement.setString(2, mahasiswa.getAlamat());
            updateStatement.setString(3, mahasiswa.getNim());
            updateStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (updateStatement != null) {
                try {
                    updateStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void deleteData(MahasiswaEntity mahasiswa) {
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = conn.prepareStatement(delete);
            deleteStatement.setString(1, mahasiswa.getNim());
            deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (deleteStatement != null) {
                try {
                    deleteStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public MahasiswaEntity cariData(MahasiswaEntity mahasiswa) {
        PreparedStatement cariStatement = null;
        MahasiswaEntity resultMahasiswa = null;
        try {
            cariStatement = conn.prepareStatement(cari);
            cariStatement.setString(1, mahasiswa.getNim());
            ResultSet result = cariStatement.executeQuery();
            while (result.next()) {
                resultMahasiswa = new MahasiswaEntity();
                resultMahasiswa.setNim(result.getString("nim"));
                resultMahasiswa.setNama(result.getString("nama"));
                resultMahasiswa.setAlamat(result.getString("alamat"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (cariStatement != null) {
                try {
                    cariStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return resultMahasiswa;
    }

    public List<MahasiswaEntity> cariSemua() {
        Statement allStatement = null;
        List<MahasiswaEntity> resultAll = null;
        try {
            allStatement = conn.createStatement();
            ResultSet rs = allStatement.executeQuery(selectAll);

            resultAll = new ArrayList<MahasiswaEntity>();

            while (rs.next()) {
                MahasiswaEntity mhs = new MahasiswaEntity();
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setAlamat(rs.getString("alamat"));
                resultAll.add(mhs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (allStatement != null) {
                try {
                    allStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return resultAll;
    }
}
