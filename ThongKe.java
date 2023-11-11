
package Model;

import java.util.Date;

public class ThongKe {

    private Date Thang;
    private int SLsp;
    private double TongDT;

    public ThongKe() {
    }

    public ThongKe(Date Thang, int SLsp, double TongDT) {
        this.Thang = Thang;
        this.SLsp = SLsp;
        this.TongDT = TongDT;
    }

    public Date getThang() {
        return Thang;
    }

    public void setThang(Date Thang) {
        this.Thang = Thang;
    }

    public int getSLsp() {
        return SLsp;
    }

    public void setSLsp(int SLsp) {
        this.SLsp = SLsp;
    }

    public double getTongDT() {
        return TongDT;
    }

    public void setTongDT(double TongDT) {
        this.TongDT = TongDT;
    }

}
