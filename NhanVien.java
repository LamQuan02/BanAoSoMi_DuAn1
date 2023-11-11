package Model;

public class NhanVien {

    private String MaNv;
    private String HoTen;
    private String MatKhau;
    private String VaiTro;

    public NhanVien() {
    }

    public NhanVien(String MaNv, String HoTen, String MatKhau, String VaiTro) {
        this.MaNv = MaNv;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

}
