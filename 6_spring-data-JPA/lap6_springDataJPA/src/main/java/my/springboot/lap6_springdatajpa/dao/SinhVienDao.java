package my.springboot.lap6_springdatajpa.dao;

import my.springboot.lap6_springdatajpa.entities.SinhVien;

import java.util.List;

public interface SinhVienDao {
    public void save(SinhVien sv);

    public SinhVien findById(int id);

    public List<SinhVien> findAll();

    public SinhVien findByTen(String ten);

    public SinhVien update(SinhVien sv);

    public int updateAllTen(String ten);

    public void deleteById(int id);
}
