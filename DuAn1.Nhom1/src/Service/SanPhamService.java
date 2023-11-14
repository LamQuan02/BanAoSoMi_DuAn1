package Service;

import Model.SanPham;
import Repository.Getconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamService {

    private final String select_all1 = """
    SELECT * FROM SanPham
""";
    private final String update_sql = """
        UPDATE SanPham
        SET TenSP = ?, SIZE = ?, MoTa = ?
        WHERE MaSP = ?
    """;
    private final String delete_sql = """
        DELETE FROM SanPham
        WHERE MaSP = ?
    """;
    String insert_sql = """
                        INSERT INTO [dbo].[SanPham]
                                              ([MaSP]
                                              ,[TenSP]
                                              ,[SIZE]
                                              ,[MoTa])
                             VALUES
                                   (?,?,?,?)
                        """;

    String selectById = """
                    SELECT [TenSP]
                           ,[SIZE]
                           ,[MoTa]
                    FROM SanPham 
                    WHERE MaSP = ?
                    """;
//////////////////////////////////////////////////
    private final String select_all11 = """
    SELECT * FROM SanPhamChiTiet
""";
    private final String update_sql1 = """
        UPDATE SanPhamChiTiet
        SET MaSP = ?, MauSac = ?, ChatLieu = ?, SoLuong = ?, Gia = ?, SALE = ?
        WHERE MaSPCT = ?
    """;
    private final String delete_sql1 = """
        DELETE FROM SanPhamChiTiet
        WHERE MaSPCT = ?
    """;
    String insert_sql1 = """
                        INSERT INTO [dbo].[SanPhamChiTiet]
                                              ([MaSPCT]
                                                ,[MaSP]
                                              ,[MauSac]
                                              ,[ChatLieu]
                                              ,[SoLuong]
                                              ,[Gia]
                                              ,[SALE])
                             VALUES
                                   (?,?,?,?,?,?,?)
                        """;

    String selectById1 = """
                    SELECT [MaSP]
                           ,[MauSac]
                           ,[ChatLieu]
                           ,[SoLuong]
                           ,[Gia]
                           ,[SALE]
                    FROM SanPhamChiTiet 
                    WHERE MaSPCT = ?
                    """;

    public void insert(SanPham entity) {
        Getconnection.update(insert_sql,
                entity.getMaSp(), entity.getTenSp(),
                entity.getSize(), entity.getMoTa());
    }

    public List<SanPham> selectAll() {
        return this.selectBySql(select_all1);
    }

    public void update(SanPham entity) {
        Getconnection.update(update_sql,
                entity.getTenSp(), entity.getSize(), entity.getMoTa(), entity.getMaSp());
    }

    public void delete(String id) {
        Getconnection.update(delete_sql, id);
    }

    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var hv = new SanPham();
                hv.setMaSp(rs.getString("MaSP"));
                hv.setTenSp(rs.getString("TenSP"));
                hv.setSize(rs.getString("SIZE"));
                hv.setMoTa(rs.getString("MoTa"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SanPham selectById(String id) {
        List<SanPham> list = this.selectBySql(selectById, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<SanPham> findProductByMaSP(String maSP) {
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        return selectBySql(sql, maSP);
    }
////////////////////////////////////////////////////////////////////////////////

    public void insert1(SanPham entity) {
        Getconnection.update(insert_sql1,
                entity.getMaSPCT(), entity.getMaSp(),
                entity.getMauSac(), entity.getChatLieu(),
                entity.getSoLuong(), entity.getGia(), entity.getSale());
    }

    public List<SanPham> selectAll1() {
        return this.selectBySql1(select_all11);
    }

    public void update1(SanPham entity) {
        Getconnection.update(update_sql1,
                entity.getMaSp(),
                entity.getMauSac(), entity.getChatLieu(),
                entity.getSoLuong(), entity.getGia(), entity.getSale(), entity.getMaSPCT());
    }

    public void delete1(String id) {
        Getconnection.update(delete_sql1, id);
    }

    protected List<SanPham> selectBySql1(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var hv = new SanPham();
                hv.setMaSPCT(rs.getString("MaSPCT"));
                hv.setMaSp(rs.getString("MaSP"));
                hv.setMauSac(rs.getString("MauSac"));
                hv.setChatLieu(rs.getString("ChatLieu"));
                hv.setSoLuong(rs.getInt("SoLuong"));
                hv.setGia(rs.getInt("Gia"));
                hv.setSale(rs.getInt("SALE"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SanPham selectById1(String id) {
        List<SanPham> list = this.selectBySql1(selectById1, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<SanPham> findProductByMaSP1(String maSPCT) {
        String sql = "SELECT * FROM SanPhamChiTiet WHERE MaSPCT = ? OR MaSP = ?";
        return selectBySql1(sql, maSPCT, maSPCT);
    }
//////////////////////////////////////////////////////

    private final String select_by_maSP = """
        SELECT * FROM GioHang_View WHERE MaSP = ?
        """;

    public SanPham getItemDetails(String maSP) {
        List<SanPham> list = selectBySqlGioHangView(select_by_maSP, maSP);
        if (!list.isEmpty()) {
            return list.get(0); // Trả về sản phẩm đầu tiên trong danh sách (nếu có)
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }

    protected List<SanPham> selectBySqlGioHangView(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var item = new SanPham();
                item.setMaSp(rs.getString("MaSP"));
                item.setTenSp(rs.getString("TenSP"));
                item.setSize(rs.getString("SIZE"));
                item.setSoLuong(rs.getInt("SoLuong"));
                item.setGia(rs.getInt("Gia"));
                item.setSale(rs.getInt("GiamGia"));
                item.setThanhTien(rs.getInt("ThanhTien"));
                list.add(item);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getGiaByMaSP(String maSP) {
        int gia = 0; // Giá trị mặc định nếu không tìm thấy hoặc có lỗi
        try {
            Connection connection = Getconnection.getConnection(); // Lấy kết nối đến cơ sở dữ liệu của bạn

            // Chuẩn bị truy vấn SQL để lấy giá từ bảng sản phẩm dựa trên mã sản phẩm
            String query = "SELECT Gia FROM SanPhamChiTiet WHERE MaSP = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, maSP);

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                gia = rs.getInt("Gia"); // Lấy giá từ kết quả truy vấn
            }

            // Đóng các đối tượng ResultSet, PreparedStatement và kết nối
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý hoặc báo lỗi nếu có vấn đề trong quá trình truy vấn
        }
        return gia; // Trả về giá của sản phẩm có mã maSP
    }

}
