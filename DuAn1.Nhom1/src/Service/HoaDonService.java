package Service;

import Model.HoaDon;
import Model.SanPham;
import Repository.DAO;
import Repository.Getconnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class HoaDonService extends DAO<HoaDon, Integer> {

    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updtae(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HoaDon> getAllHD() {
        String SQL = """
                      select a.*, b.MaHDCT,b.MaSP,b.SoLuong, b.GiaTien, b.MaVoucher, b.TrangThai, b.GhiChu 
                                            from HoaDon a join HoaDonChiTiet b 
                                            on a.MaHD=b.MaHD""";
        List<HoaDon> list = new ArrayList<>();

        Connection conn = null;
        try {
            conn = Getconnection.getConnection();
            PreparedStatement sttm = conn.prepareStatement(SQL);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setNgayLap(rs.getDate("NgayLap"));
                hd.setMaNv(rs.getString("MaNV"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setMaHDCT(rs.getInt("MaHDCT"));
                hd.setMaSp(rs.getString("MaSP"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                hd.setMaVoucher(rs.getInt("MaVoucher"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setGhiChu(rs.getString("GhiChu"));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> selectAll() {
        String SQL = "SELECT * FROM HoaDon";
        List<HoaDon> list = new ArrayList<>();

        Connection conn = null;
        try {
            conn = Getconnection.getConnection();
            PreparedStatement sttm = conn.prepareStatement(SQL);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt("MaHD"),
                        rs.getString("TenKH"),
                        rs.getDate("NgayLap"),
                        rs.getString("MaNV"),
                        rs.getInt("TongTien"));
                list.add(hd);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> DSSanPham() {
        String SQL = "select sp.MaSP, sp.TenSP, spct.MauSac,spct.ChatLieu,sp.SIZE,spct.SoLuong, spct.Gia from SanPham sp join SanPhamChiTiet spct on sp.MaSP= spct.MaSP";
        List<SanPham> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Getconnection.getConnection();
            PreparedStatement sttm = conn.prepareStatement(SQL);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MaSP"));
                sp.setTenSp(rs.getString("TenSP"));
                sp.setMauSac(rs.getString("MauSac"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setSize(rs.getString("SIZE"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setGia(rs.getInt("Gia"));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDon selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
