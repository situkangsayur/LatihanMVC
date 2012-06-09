/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.latihan.mvc.controller;

import com.codelabs.latihan.mvc.model.MahasiswaModel;
import com.codelabs.latihan.mvc.view.MahasiswaPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author hendri
 */
public class MahasiswaController {

    private MahasiswaModel model;

    public void setModel(MahasiswaModel model) {
        this.model = model;
    }

    public void prosesInsert(MahasiswaPanel view) {
        String nim = view.getTextNim().getText();
        String nama = view.getTextNama().getText();
        String alamat = view.getTextAreaAlamat().getText();

        if (nim.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nim masih kosong");

        }

        if (nama.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nama masih kosong");

        }
        if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf alamat masih kosong");

        }

        model.setNim(nim);
        model.setNama(nama);
        model.setAlamat(alamat);
        model.insertData();

    }

    public void prosesUpdate(MahasiswaPanel view) {

        String nim = view.getTextNim().getText();
        String nama = view.getTextNama().getText();
        String alamat = view.getTextAreaAlamat().getText();

        if (nim.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nim masih kosong");

        }

        if (nama.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nama masih kosong");

        }
        if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf alamat masih kosong");

        }

        model.setNim(nim);
        model.setNama(nama);
        model.setAlamat(alamat);
        model.updateData();

    }

    public void prosesDelete(MahasiswaPanel view) {
        String nim = view.getTextNim().getText();
        String nama = view.getTextNama().getText();
        String alamat = view.getTextAreaAlamat().getText();

        if (nim.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nim masih kosong");

        }

        if (nama.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nama masih kosong");

        }
        if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf alamat masih kosong");

        }

        model.setNim(nim);
        model.setNama(nama);
        model.setAlamat(alamat);
        model.deleteData();

    }

    public void prosesCari(MahasiswaPanel view) {
        String nim = view.getTextNim().getText();

        if (nim.equals("")) {
            JOptionPane.showMessageDialog(null, "maaf nim masih kosong");
        }

        model.setNim(nim);
        model.cariData();

    }
}
