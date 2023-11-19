/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Vourcher;
import java.util.List;

/**
 *
 * @author Bumbleebe
 */
public interface VoucherService {
    
    List<Vourcher> getAll();

    String addVoucher(Vourcher vc);

    String deleteVoucher(String id);

    String updateVoucher(String id, Vourcher vc);
}
