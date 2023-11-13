package Model;

import java.util.Date;

public class Vourcher {

    private int MaVourcher;
    private String TenVoucher;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int GiamGia;
    private String TrangThai;

    public Vourcher() {
    }

    public Vourcher(int MaVourcher, String TenVoucher, Date NgayBatDau, Date NgayKetThuc, int GiamGia, String TrangThai) {
        this.MaVourcher = MaVourcher;
        this.TenVoucher = TenVoucher;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.GiamGia = GiamGia;
        this.TrangThai = TrangThai;
    }

    public int getMaVourcher() {
        return MaVourcher;
    }

    public void setMaVourcher(int MaVourcher) {
        this.MaVourcher = MaVourcher;
    }

    public String getTenVoucher() {
        return TenVoucher;
    }

    public void setTenVoucher(String TenVoucher) {
        this.TenVoucher = TenVoucher;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

}
