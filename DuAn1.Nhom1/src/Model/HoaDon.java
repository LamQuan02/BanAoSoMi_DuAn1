package Model;

import java.util.Date;

public class HoaDon {

    private int MaHD;
    private int MaHDCT;
    private String TenKH;
    private Date NgayLap;
    private String MaNv;
    private int TongTien;
    private String MaSp;
    private int SoLuong;
    private int GiaTien;
    private String MaVoucher;
    private String TrangThai;
    private String GhiChu;

    public HoaDon() {
    }

    public HoaDon(int MaHD, String TenKH, Date NgayLap, String MaNv, int TongTien) {
        this.MaHD = MaHD;
        this.TenKH = TenKH;
        this.NgayLap = NgayLap;
        this.MaNv = MaNv;
        this.TongTien = TongTien;
    }
    
    

    public HoaDon(int MaHD, int MaHDCT, String TenKH, Date NgayLap, String MaNv, int TongTien, String MaSp, int SoLuong, int GiaTien, String MaVoucher, String TrangThai, String GhiChu) {
        this.MaHD = MaHD;
        this.MaHDCT = MaHDCT;
        this.TenKH = TenKH;
        this.NgayLap = NgayLap;
        this.MaNv = MaNv;
        this.TongTien = TongTien;
        this.MaSp = MaSp;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.MaVoucher = MaVoucher;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(int MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getMaVoucher() {
        return MaVoucher;
    }

    public void setMaVoucher(String MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
