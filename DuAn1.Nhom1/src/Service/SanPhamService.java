package Service;

import Model.SanPham;
import Repository.Getconnection;
import java.awt.image.SampleModel;
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

    String insert_sql = """
                        INSERT INTO [dbo].[SanPham]
                                              ([MaSP]
                                              ,[TenSP]
                                              ,[SIZE]
                                              ,[MoTa])
                             VALUES
                                   (?,?,?,?)
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
                hv.setSale(rs.getInt("KhuyenMai"));
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

    public SanPham getGiaByMaSP(String maSP) {
        SanPham giaSanPham = new SanPham(); // Tạo đối tượng GiaSanPham để lưu thông tin

        try {
            Connection connection = Getconnection.getConnection(); // Lấy kết nối đến cơ sở dữ liệu của bạn

            // Chuẩn bị truy vấn SQL để lấy thông tin từ bảng sản phẩm dựa trên mã sản phẩm
            String query = "SELECT Gia, SIZE, GiamGia FROM GioHang_View WHERE MaSP = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, maSP);

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                giaSanPham.setGia(rs.getInt("Gia"));
                giaSanPham.setSize(rs.getString("SIZE"));
                giaSanPham.setGiamGia(rs.getInt("GiamGia"));
            }

            // Đóng các đSối tượng ResultSet, PreparedStatement và kết nối
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý hoặc báo lỗi nếu có vấn đề trong quá trình truy vấn
        }

        return giaSanPham; // Trả về đối tượng GiaSanPham chứa thông tin về giá, size và giảm giá của sản phẩm
    }
////////////////////////////////////////  JPANEL hoadon

    public void updateSoLuong(String maSP, int newQuantity) {
        try {
            String update_sqlSP = "UPDATE SanPhamChiTiet SET SoLuong = ? WHERE MaSP = ?";
            PreparedStatement ps = Getconnection.getConnection().prepareStatement(update_sqlSP);
            ps.setInt(1, newQuantity);
            ps.setString(2, maSP);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ khi cập nhật số lượng sản phẩm
        }
    }

    public int getSoLuongByMaSP(String maSP) {
        int soLuong = 0;
        try {
            String query = "SELECT SoLuong FROM SanPhamChiTiet WHERE MaSP = ?";
            PreparedStatement ps = Getconnection.getConnection().prepareStatement(query);
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ khi truy vấn dữ liệu số lượng sản phẩm
        }
        return soLuong;
    }
///////////////////////////////////////////////////////////////////////////

    public List<SanPham> laySanPhamTheoMaHD(int maHD) {
        List<SanPham> productList = new ArrayList<>();

        try {
            // Prepare SQL query to fetch products based on Invoice ID from HoaDonChiTiet table
            String query = "SELECT sp.MaSP, sp.TenSP, hdct.SoLuong, spct.Gia, spct.SALE, hdct.GiaTien "
                    + "FROM SanPham sp\n"
                    + "INNER JOIN HoaDonChiTiet hdct ON sp.MaSP = hdct.MaSP\n"
                    + "INNER JOIN SanPhamChiTiet spct ON spct.MaSP = sp.MaSP\n"
                    + "WHERE hdct.MaHD = ?";

            // Get a connection and execute the query
            PreparedStatement pstmt = Getconnection.getConnection().prepareStatement(query);
            pstmt.setInt(1, maHD);
            ResultSet rs = pstmt.executeQuery();

            // Process the results and populate the productList
            while (rs.next()) {
                SanPham product = new SanPham();
                product.setMaSp(rs.getString("MaSP"));
                product.setTenSp(rs.getString("TenSP"));
                product.setSoLuong(rs.getInt("SoLuong"));
                product.setGia(rs.getInt("Gia"));
                product.setSale(rs.getInt("SALE"));
                product.setThanhTien(rs.getInt("GiaTien"));
                productList.add(product);
            }

            // Close resources
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions or errors if any occur during the process
        }

        return productList;
    }

}
