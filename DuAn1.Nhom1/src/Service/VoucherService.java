
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Repository.Getconnection;
import Model.Vourcher;
public class VoucherService{

   
  public List<Vourcher> getAll() {
        String sql = """
                     SELECT [MaVoucher]
                           ,[TenKM]
                           ,[NgayBatDau]
                           ,[NgayKetThuc]
                           ,[GiamGia]
                           ,[TrangThai]
                       FROM [dbo].[Voucher]
                     """;
        try ( Connection con = Getconnection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Vourcher> list = new ArrayList<>();
            while (rs.next()) {
                Vourcher vc = new Vourcher();
                vc.setMaVourcher(rs.getInt(1));
                vc.setTenVoucher(rs.getString(2));
                vc.setNgayBatDau(rs.getDate(3));
                vc.setNgayKetThuc(rs.getDate(4));
                vc.setGiamGia(rs.getInt(5));
                vc.setTrangThai(rs.getString(6));
                list.add(vc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean addVoucher(Vourcher vc) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[Voucher]
                                ([TenKM]
                                ,[NgayBatDau]
                                ,[NgayKetThuc]
                                ,[GiamGia]
                                ,[TrangThai])
                          VALUES
                                (?,?,?,?,?)
                     """;
        try ( Connection con = Getconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, vc.getTenVoucher());
            ps.setObject(2, vc.getNgayBatDau());
            ps.setObject(3, vc.getNgayKetThuc());
            ps.setObject(4, vc.getGiamGia());
            ps.setObject(5, vc.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean deleteVoucher(String id) {
        int check = 0;
        String sql = """
                     DELETE FROM [dbo].[Voucher]
                           WHERE MaVoucher = ?
                     """;
        try ( Connection con = Getconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean updateVoucher(String id, Vourcher vc) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[Voucher]
                        SET [TenKM] = ?
                           ,[NgayBatDau] = ?
                           ,[NgayKetThuc] = ?
                           ,[GiamGia] = ?
                           ,[TrangThai] = ?
                      WHERE MaVoucher = ?
                     """;
        try ( Connection con = Getconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, vc.getTenVoucher());
            ps.setObject(2, vc.getNgayBatDau());
            ps.setObject(3, vc.getNgayKetThuc());
            ps.setObject(4, vc.getGiamGia());
            ps.setObject(5, vc.getTrangThai());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }    
}
