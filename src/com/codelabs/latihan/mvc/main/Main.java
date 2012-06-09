/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.latihan.mvc.main;

import com.codelabs.latihan.mvc.dao.MahasiswaDao;
import com.codelabs.latihan.mvc.entities.MahasiswaEntity;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendri
 */
public class Main {

    public static void main(String args[]) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        MahasiswaDao dao = new MahasiswaDao();

//       MahasiswaEntity mahasiswa = new MahasiswaEntity();
//
//        mahasiswa.setNim("10108666");
//        mahasiswa.setNama("Tini");
//        mahasiswa.setAlamat("Cianjur");
//
//        dao.insertData(mahasiswa);
//        MahasiswaEntity mahasiswa = new MahasiswaEntity();
//        mahasiswa.setNim("10107654");
//        mahasiswa.setNama("Bejo");
//        mahasiswa.setAlamat("Jatim");
//        
//        dao.updateData(mahasiswa);
//      


//          MahasiswaEntity mhs = new MahasiswaEntity();
//          mhs.setNim("10108666");
//          dao.deleteData(mhs);

        MahasiswaEntity cariMhs = new MahasiswaEntity();
        cariMhs.setNim("10108666");
        cariMhs = dao.cariData(cariMhs);
        System.out.println(cariMhs.getNim());
        System.out.println(cariMhs.getNama());
        System.out.println(cariMhs.getAlamat());


        List<MahasiswaEntity> listMhs = dao.cariSemua();

        for (MahasiswaEntity mhs : listMhs) {
            System.out.println("Nim : " + mhs.getNim());
            System.out.println("Nama : " + mhs.getNama());
            System.out.println("Alamat : " + mhs.getAlamat());
            System.out.println("===============================");
        }



    }
}
