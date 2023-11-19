/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;
import java.util.List;
import Model.Vourcher;
import Service.VoucherService;
import Service.impl.VourcherSQL;
/**
 *
 * @author Bumbleebe
 */
public class VourcherServiceImpl implements VoucherService{
    VourcherSQL sql = new  VourcherSQL();
    @Override
    public List<Vourcher> getAll() {
        return sql.getAll();
    }

    @Override
    public String addVoucher(Vourcher vc) {
        return (vc!=null && sql.addVoucher(vc)?"Thêm thành công":"Thêm thất bại");
    }

    @Override
    public String deleteVoucher(String id) {
        return (sql.deleteVoucher(id)?"Xóa thành công":"Xóa thất bại");
    }

    @Override
    public String updateVoucher(String id, Vourcher vc) {
        return (sql.updateVoucher(id, vc)?"Sửa thành công":"Sửa thất bại");
    }
    
}
