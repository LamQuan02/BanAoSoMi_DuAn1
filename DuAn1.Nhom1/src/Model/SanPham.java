package Model;

public class SanPham {

    private String MaSp;
    private String TenSp;
    private String Size;
    private String MoTa;
    private String MaSPCT;
    private String MauSac;
    private String ChatLieu;
    private int SoLuong;
    private int Gia;
    private int Sale;

    public int getGiamGia() {
        return GiamGia;
    }

    public SanPham(String Size, int Gia, int GiamGia) {
        this.Size = Size;
        this.Gia = Gia;
        this.GiamGia = GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }
    private int GiamGia;
    private int ThanhTien;

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public SanPham() {
    }

    public SanPham(String MaSp, String TenSp, String Size, String MoTa, String MaSPCT, String MauSac, String ChatLieu, int SoLuong, int Gia, int Sale) {
        this.MaSp = MaSp;
        this.TenSp = TenSp;
        this.Size = Size;
        this.MoTa = MoTa;
        this.MaSPCT = MaSPCT;
        this.MauSac = MauSac;
        this.ChatLieu = ChatLieu;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.Sale = Sale;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getMaSPCT() {
        return MaSPCT;
    }

    public void setMaSPCT(String MaSPCT) {
        this.MaSPCT = MaSPCT;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSale() {
        return Sale;
    }

    public void setSale(int Sale) {
        this.Sale = Sale;
    }

}
