/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.latihan.mvc.listener;

import com.codelabs.latihan.mvc.entities.MahasiswaEntity;

/**
 *
 * @author hendri
 */
public interface MahasiswaListener {

    public void insertMahasiswa(MahasiswaEntity mahasiswa);

    public void updateMahasiswa(MahasiswaEntity mahasiswa);

    public void deleteMahasiswa(MahasiswaEntity mahasiswa);

    public void cariMahasiswa(MahasiswaEntity mahasiswa);
}
