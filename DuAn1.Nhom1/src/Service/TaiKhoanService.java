package Service;

import Model.TaiKhoan;
import Repository.Getconnection;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanService {

    private final String select_all1 = """
    SELECT * FROM TaiKhoan
""";
    private final String update_sql = """
        UPDATE TaiKhoan
        SET HoTen = ?, MatKhau = ?, VaiTro = ?
        WHERE MaNV = ?
    """;
    private final String delete_sql = """
        DELETE FROM TaiKhoan
        WHERE MaNV = ?
    """;
    String insert_sql = """
                        INSERT INTO [dbo].[TaiKhoan]
                                              ([MaNV]
                                              ,[HoTen]
                                              ,[MatKhau]
                                              ,[VaiTro])
                             VALUES
                                   (?,?,?,?)
                        """;

    String selectById = """
                    SELECT [HoTen]
                           ,[MatKhau]
                           ,[VaiTro]
                    FROM TaiKhoan 
                    WHERE MaNV = ?
                    """;

    public void inserttk(TaiKhoan entity) {
        Getconnection.update(insert_sql,
                entity.getMaNv(), entity.getHoTen(),
                entity.getMatKhau(), (entity.getVaiTro() != null) ? entity.getVaiTro() : false);
    }

    public List<TaiKhoan> selectAlltk() {
        return this.selectBySqltk(select_all1);
    }

    public void updatetk(TaiKhoan entity) {
        Getconnection.update(update_sql,
                entity.getHoTen(), entity.getMatKhau(), (entity.getVaiTro() != null) ? entity.getVaiTro() : false,
                entity.getMaNv());
    }

    public void deletetk(String id) {
        Getconnection.update(delete_sql, id);
    }

    protected List<TaiKhoan> selectBySqltk(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            var rs = Getconnection.query(sql, args);
            while (rs.next()) {
                var hv = new TaiKhoan();
                hv.setMaNv(rs.getString("MaNV"));
                hv.setHoTen(rs.getString("HoTen"));
                hv.setMatKhau(rs.getString("MatKhau"));
                hv.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TaiKhoan selectByIdtk(String id) {
        List<TaiKhoan> list = this.selectBySqltk(selectById, id);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<TaiKhoan> findProductByMatk(String maSP) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaNV = ?";
        return selectBySqltk(sql, maSP);
    }
}
