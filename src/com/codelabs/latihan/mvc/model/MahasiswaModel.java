/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.latihan.mvc.model;

import com.codelabs.latihan.mvc.dao.MahasiswaDao;
import com.codelabs.latihan.mvc.entities.MahasiswaEntity;
import com.codelabs.latihan.mvc.listener.MahasiswaListener;

/**
 *
 * @author hendri
 */
public class MahasiswaModel {

    private String nim;
    private String nama;
    private String alamat;
    private MahasiswaListener listener;
    private MahasiswaDao dao;

    public MahasiswaModel() {

        if (dao == null) {
            dao = new MahasiswaDao();
        }

    }

    public void setListener(MahasiswaListener listener) {
        this.listener = listener;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void insertData() {
        MahasiswaEntity mahasiswa = new MahasiswaEntity();
        mahasiswa.setNim(this.nim);
        mahasiswa.setNama(this.nama);
        mahasiswa.setAlamat(this.alamat);
        dao.insertData(mahasiswa);
        fireOnInsert(mahasiswa);
    }

    public void updateData() {
        MahasiswaEntity mahasiswa = new MahasiswaEntity();
        mahasiswa.setNim(this.nim);
        mahasiswa.setNama(this.nama);
        mahasiswa.setAlamat(this.alamat);
        dao.updateData(mahasiswa);
        fireOnUpdate(mahasiswa);

    }

    public void deleteData() {
        MahasiswaEntity mahasiswa = new MahasiswaEntity();
        mahasiswa.setNim(this.nim);

        dao.deleteData(mahasiswa);
        fireOnDelete(mahasiswa);
    }

    public void cariData() {
        MahasiswaEntity mahasiswa = new MahasiswaEntity();
        mahasiswa.setNim(this.nim);

        mahasiswa = dao.cariData(mahasiswa);
        fireOnCari(mahasiswa);

    }

    protected void fireOnInsert(MahasiswaEntity mahasiswa) {
        if (listener != null) {
            listener.insertMahasiswa(mahasiswa);
        }
    }

    protected void fireOnUpdate(MahasiswaEntity mahasiswa) {
        if (listener != null) {
            listener.updateMahasiswa(mahasiswa);
        }
    }

    protected void fireOnDelete(MahasiswaEntity mahasiswa) {
        if (listener != null) {
            listener.deleteMahasiswa(mahasiswa);
        }
    }

    protected void fireOnCari(MahasiswaEntity mahasiswa) {
        if (listener != null) {
            listener.cariMahasiswa(mahasiswa);
        }
    }
}
