package Service;

import Model.HoaDon;
import Model.SanPham;
import Repository.DAO;
import Repository.Getconnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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
                hd.setTrangThai(rs.getBoolean("TrangThai"));
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
                        rs.getDate("NgayLap"),
                        rs.getString("MaNV"),
                        rs.getBoolean("TrangThai"));
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
        List<HoaDon> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Getconnection.getConnection();
            PreparedStatement sttm = conn.prepareStatement(sql);

            // Set các tham số cho truy vấn (nếu có)
            for (int i = 0; i < args.length; i++) {
                sttm.setObject(i + 1, args[i]);
            }

            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setNgayLap(rs.getDate("NgayLap"));
                hd.setMaNv(rs.getString("MaNV"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    ////////////////////////////////// phần fix của Chủ
    String insert_sql = """
                        INSERT INTO [dbo].[HoaDon]
                                              ([NgayLap]
                                              ,[MaNV])
                             VALUES
                                   (?,?)
                        """;

    public void inserthd(HoaDon entity) {
        Getconnection.update(insert_sql,
                entity.getNgayLap(),
                entity.getMaNv());
    }
    ///////////////////////////// hóa đơn

    public void updateHoaDonStatus(int maHD, boolean trangThai) {
        String updateSql = "UPDATE HoaDon SET TrangThai = ? WHERE MaHD = ?";
        Getconnection.update(updateSql, trangThai, maHD);
    }

    public HoaDon selectByIdhd(int maHD) {
        String selectByIdSql = "SELECT * FROM HoaDon WHERE MaHD = ?";
        List<HoaDon> result = selectBySql(selectByIdSql, maHD);
        return result.isEmpty() ? null : result.get(0);
    }

    ////////////////////////// hóa đơn chi tiết 
    private final String selectAllHDCT = "SELECT * FROM HoaDonChiTiet";
    private final String insertHDCT = "INSERT INTO HoaDonChiTiet (MaHD, TenKH, MaSP, SoLuong, GiaTien, HinhThucTT, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public List<HoaDon> selectAllhdct() {
        return this.selectBySqlhdct(selectAllHDCT);
    }

    protected List<HoaDon> selectBySqlhdct(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var hv = new HoaDon();
                hv.setMaHD(rs.getInt("MaHD"));
                hv.setTenKH(rs.getString("TenKH"));
                hv.setMaSp(rs.getString("MaSP"));
                hv.setSoLuong(rs.getInt("SoLuong"));
                hv.setGiaTien(rs.getInt("GiaTien"));
                hv.setHinhThucTT(rs.getString("HinhThucTT"));
                hv.setGhiChu(rs.getString("GhiChu"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void inserthdct(HoaDon entity) {
        Getconnection.update(insertHDCT,
                entity.getMaHD(), entity.getTenKH(),
                entity.getMaSp(), entity.getSoLuong(), entity.getGiaTien(), entity.getHinhThucTT(), entity.getGhiChu());
    }

//////////////////////////////////////////////////////////////////////////////////// lịch sử
    private final String selectLICHSU = "SELECT\n"
            + "    HD.MaHD,\n"
            + "    HD.NgayLap,\n"
            + "    HD.MaNV,\n"
            + "    HD.TrangThai,\n"
            + "    HDCT.TenKH\n"
            + "FROM\n"
            + "    HoaDon HD\n"
            + "INNER JOIN\n"
            + "    HoaDonChiTiet HDCT ON HD.MaHD = HDCT.MaHD;";

    public List<HoaDon> selectAlLICHSU() {
        return this.selectBySqlLICHSU(selectLICHSU);
    }

    protected List<HoaDon> selectBySqlLICHSU(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var hv = new HoaDon();
                hv.setMaHD(rs.getInt("MaHD"));
                hv.setNgayLap(rs.getDate("NgayLap"));
                hv.setMaNv(rs.getString("MaNV"));
                hv.setTrangThai(rs.getBoolean("TrangThai"));
                hv.setTenKH(rs.getString("TenKH"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////// LỊCH SỬ

    public HoaDon layThongTinHoaDonTheoMaHD(int maHD) {
        String sql = "SELECT HD.MaNV, HDCT.TenKH, MAX(HDCT.GiaTien) AS GiaTien, HD.NgayLap, HD.TrangThai, HDCT.HinhThucTT, HDCT.GhiChu\n"
                + "FROM HoaDon HD\n"
                + "INNER JOIN HoaDonChiTiet HDCT ON HD.MaHD = HDCT.MaHD\n"
                + "WHERE HD.MaHD = ?\n"
                + "GROUP BY HD.MaNV, HDCT.TenKH, HD.NgayLap, HD.TrangThai, HDCT.HinhThucTT, HDCT.GhiChu;";

        List<HoaDon> hoaDons = selectBySqlLS(sql, maHD);
        return hoaDons.isEmpty() ? null : hoaDons.get(0);
    }

    protected List<HoaDon> selectBySqlLS(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Getconnection.getConnection();
            PreparedStatement sttm = conn.prepareStatement(sql);

            // Set các tham số cho truy vấn (nếu có)
            for (int i = 0; i < args.length; i++) {
                sttm.setObject(i + 1, args[i]);
            }

            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaNv(rs.getString("MaNV"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                hd.setNgayLap(rs.getDate("NgayLap"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                hd.setHinhThucTT(rs.getString("HinhThucTT"));
                hd.setGhiChu(rs.getString("GhiChu"));
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
      public Map<Integer, HoaDon> mergeByMaHD(List<HoaDon> list) {
        Map<Integer, HoaDon> mergedMap = new HashMap<>();

        for (HoaDon hd : list) {
            int maHD = hd.getMaHD();
            if (!mergedMap.containsKey(maHD)) {
                mergedMap.put(maHD, hd);
            } else {
                // Logic gộp dữ liệu theo MaHD
                HoaDon existingHoaDon = mergedMap.get(maHD);
                existingHoaDon.setNgayLap(hd.getNgayLap());
                existingHoaDon.setMaNv(hd.getMaNv());
                existingHoaDon.setTrangThai(hd.getTrangThai());
                // Cập nhật các thông tin khác nếu cần thiết
            }
        }
        return mergedMap;
    }
//////////////////////////////////////////////////////////////////////////////////////////////

}
