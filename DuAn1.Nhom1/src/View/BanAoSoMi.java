package View;

import Model.HoaDon;
import Model.SanPham;
import Model.TaiKhoan;
import Model.Vourcher;
import Repository.Auth;
import Repository.MsgBox;
import Repository.XDate;
import Service.HoaDonService;
import Service.SanPhamService;
import Service.TaiKhoanService;
import Service.VoucherService;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class BanAoSoMi extends javax.swing.JFrame {

    SanPhamService dao = new SanPhamService();
    TaiKhoanService tk = new TaiKhoanService();
    HoaDonService hd = new HoaDonService();

    public BanAoSoMi() {
        initComponents();
        Table();
        Tablesp();
        Tabletk();
        fillTableLICHSU(listAll);
        this.setTitle("7Clothes");

        URL urlIconLogo = BanAoSoMi.class.getClassLoader().getResource("Image/Logo.jpg");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconLogo);
        this.setIconImage(img);
        initHD();
        txtNgayLap.setText(XDate.toString(XDate.now(), "dd-MM-yyyy"));
        txtMaNV.setEditable(false);
        moDialogDangNhap();
        //////////////////// HINH THUC THANH TOAN 
        cboHinhThucThanhToan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = cboHinhThucThanhToan.getSelectedItem().toString();
                    // Kiểm tra lựa chọn và vô hiệu hóa nhập liệu vào txtTienKhachDua khi chọn "Chuyển khoản" hoặc "Quẹt thẻ"
                    if (selectedOption.equals("Chuyển khoản") || selectedOption.equals("Quẹt thẻ")) {
                        txtTienKhachDua.setEditable(false);
                        txtTienKhachDua.setText(lblTongTien.getText());
                    } else {
                        txtTienKhachDua.setEditable(true);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDSSP = new javax.swing.JTable();
        container = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mnTK = new javax.swing.JLabel();
        mnSP = new javax.swing.JLabel();
        mnHD = new javax.swing.JLabel();
        mnVC = new javax.swing.JLabel();
        mnTKhoan = new javax.swing.JLabel();
        mnThoat = new javax.swing.JLabel();
        mnLS = new javax.swing.JLabel();
        mnNV = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        sanpham = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSANPHAM = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTenSp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSze = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        btnXoa1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        btnLoad1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        txtMaCT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMatableCT = new javax.swing.JTextField();
        btnTim1 = new javax.swing.JButton();
        txtTim1 = new javax.swing.JTextField();
        txtChatLieu = new javax.swing.JTextField();
        txtSoL = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtSale = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        thongke = new javax.swing.JPanel();
        hoadon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDanhSachSP = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        lblTienTraLai = new javax.swing.JLabel();
        lblTienTraKhach = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        txtMaHD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        voucher = new javax.swing.JPanel();
        taikhoan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtMaTk = new javax.swing.JTextField();
        txtHoTenTk = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtThemTaiK = new javax.swing.JButton();
        txtSuaTaiK = new javax.swing.JButton();
        txtXoaTaiK = new javax.swing.JButton();
        txtTimTaiK = new javax.swing.JButton();
        txtTimTK = new javax.swing.JTextField();
        rdoNV = new javax.swing.JRadioButton();
        rdoQL = new javax.swing.JRadioButton();
        txtLoadTaiK = new javax.swing.JButton();
        nhanvien = new javax.swing.JPanel();
        lichsu = new javax.swing.JPanel();
        tblLichS = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblSanPhamLichSu = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaNVLS = new javax.swing.JTextField();
        txtTenKHLS = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtGiaTienLS = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNgayLapLS = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTrangThaiLS = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtGhiChuLS = new javax.swing.JTextArea();
        txtHinhThucTTLS = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm "));

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Màu sắc ", "Chất liệu", "SIZE", "Số lượng ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDSSP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.jpg"))); // NOI18N

        mnTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnTK.setText("             Thống kê");
        mnTK.setToolTipText("");
        mnTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnTKMouseClicked(evt);
            }
        });

        mnSP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnSP.setText("            Sản phẩm");
        mnSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSPMouseClicked(evt);
            }
        });

        mnHD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnHD.setText("             Bán hàng");
        mnHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnHDMouseClicked(evt);
            }
        });

        mnVC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnVC.setText("          Khuyến mại ");
        mnVC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnVCMouseClicked(evt);
            }
        });

        mnTKhoan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnTKhoan.setText("            Tài khoản");
        mnTKhoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnTKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnTKhoanMouseClicked(evt);
            }
        });

        mnThoat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnThoat.setText("               Thoát");
        mnThoat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mnLS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnLS.setText("           Lịch sử bán ");
        mnLS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnLSMouseClicked(evt);
            }
        });

        mnNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mnNV.setText("            Nhân viên ");
        mnNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mnNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnVC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnTKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(42, Short.MAX_VALUE))
            .addComponent(mnLS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mnNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(mnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnVC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnLS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnNV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mnTKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        home.setLayout(new java.awt.CardLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblSANPHAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm ", "Size", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSANPHAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSANPHAMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSANPHAM);
        if (tblSANPHAM.getColumnModel().getColumnCount() > 0) {
            tblSANPHAM.getColumnModel().getColumn(0).setResizable(false);
            tblSANPHAM.getColumnModel().getColumn(1).setResizable(false);
            tblSANPHAM.getColumnModel().getColumn(2).setResizable(false);
            tblSANPHAM.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setText("Mã sản phẩm");

        jLabel3.setText("Tên sản phẩm ");

        txtSze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSzeActionPerformed(evt);
            }
        });

        jLabel4.setText("Size");

        jLabel5.setText("Mô tả");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane6.setViewportView(txtMota);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnLoad.setText("LoadV");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(txtSze, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(txtTenSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addGap(2, 2, 2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTim)
                            .addComponent(btnTim))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenSp))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSze))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(btnLoad)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm ", jPanel2);

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MSPCT", "Mã sản phẩm", "Màu sắc", "Chất liệu ", "Số lượng ", "Giá", "Sale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSPCT);
        if (tblSPCT.getColumnModel().getColumnCount() > 0) {
            tblSPCT.getColumnModel().getColumn(0).setResizable(false);
            tblSPCT.getColumnModel().getColumn(1).setResizable(false);
            tblSPCT.getColumnModel().getColumn(2).setResizable(false);
            tblSPCT.getColumnModel().getColumn(3).setResizable(false);
            tblSPCT.getColumnModel().getColumn(4).setResizable(false);
            tblSPCT.getColumnModel().getColumn(5).setResizable(false);
            tblSPCT.getColumnModel().getColumn(6).setResizable(false);
        }

        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnLoad1.setText("LoadV");
        btnLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoad1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Màu sắc");

        txtMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMauSacActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã sản phẩm");

        jLabel12.setText("MSPCT");

        btnTim1.setText("Tìm");
        btnTim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTim1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Chất liệu");

        jLabel14.setText("Số lượng");

        jLabel15.setText("Giá");

        jLabel16.setText("Sale");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatableCT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaCT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtChatLieu)
                            .addComponent(txtSoL)
                            .addComponent(txtGia)
                            .addComponent(txtSale)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim1)
                    .addComponent(btnTim1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMatableCT))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaCT))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMauSac))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel3);

        javax.swing.GroupLayout sanphamLayout = new javax.swing.GroupLayout(sanpham);
        sanpham.setLayout(sanphamLayout);
        sanphamLayout.setHorizontalGroup(
            sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        sanphamLayout.setVerticalGroup(
            sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Sản phẩm");

        home.add(sanpham, "card3");

        javax.swing.GroupLayout thongkeLayout = new javax.swing.GroupLayout(thongke);
        thongke.setLayout(thongkeLayout);
        thongkeLayout.setHorizontalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        thongkeLayout.setVerticalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        home.add(thongke, "card2");

        hoadon.setPreferredSize(new java.awt.Dimension(1012, 450));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Ngày Lập", "Mã NV", "Trạng thái"
            }
        ));
        tblDanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhSachHoaDon);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng "));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Size", "Số Lượng", "Tiền", "Giảm giá", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setResizable(false);
            tblGioHang.getColumnModel().getColumn(1).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setResizable(false);
            tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblGioHang.getColumnModel().getColumn(3).setResizable(false);
            tblGioHang.getColumnModel().getColumn(4).setResizable(false);
            tblGioHang.getColumnModel().getColumn(5).setResizable(false);
            tblGioHang.getColumnModel().getColumn(6).setResizable(false);
        }

        jScrollPane8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm "));

        tblDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu sắc ", "Chất liệu", "SIZE", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSPMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDanhSachSP);
        if (tblDanhSachSP.getColumnModel().getColumnCount() > 0) {
            tblDanhSachSP.getColumnModel().getColumn(0).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(1).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(2).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(4).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(5).setResizable(false);
            tblDanhSachSP.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo hóa đơn"));

        jLabel18.setText("Tên Khách Hàng");

        jLabel20.setText("Mã NV");

        txtMaNV.setBackground(new java.awt.Color(242, 242, 242));

        jLabel22.setText("Ngày Lập");

        txtNgayLap.setEnabled(false);
        txtNgayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayLapActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 255, 51));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel24.setText("Hình thứ than toán");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Quẹt thẻ" }));
        cboHinhThucThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboHinhThucThanhToanMouseClicked(evt);
            }
        });

        jLabel25.setText("Tổng tiền tt");

        lblTongTien.setText("-");

        jLabel26.setText("Tiền Khách Đưa");

        txtTienKhachDua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienKhachDuaFocusLost(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        lblTienTraLai.setText("Tiền trả Khách");

        lblTienTraKhach.setText("-");

        jLabel29.setText("Mã HD");

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setText("Tạo hóa đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Ghi chú");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane9.setViewportView(txtGhichu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(txtMaNV)
                                    .addComponent(txtNgayLap)
                                    .addComponent(txtMaHD)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnHuy)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTienTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboHinhThucThanhToan, 0, 249, Short.MAX_VALUE)
                                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTienTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnThanhToan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienTraLai)
                    .addComponent(lblTienTraKhach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnThanhToan});

        jButton1.setText("Tìm");

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hoadonLayout = new javax.swing.GroupLayout(hoadon);
        hoadon.setLayout(hoadonLayout);
        hoadonLayout.setHorizontalGroup(
            hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonLayout.createSequentialGroup()
                .addGroup(hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(hoadonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTimkiem)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(209, 209, 209)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        hoadonLayout.setVerticalGroup(
            hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        home.add(hoadon, "card4");

        javax.swing.GroupLayout voucherLayout = new javax.swing.GroupLayout(voucher);
        voucher.setLayout(voucherLayout);
        voucherLayout.setHorizontalGroup(
            voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        voucherLayout.setVerticalGroup(
            voucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        home.add(voucher, "card5");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh sách tài khoản"));

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ Tên", "Mật khẩu", "Vai trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTaiKhoan);
        if (tblTaiKhoan.getColumnModel().getColumnCount() > 0) {
            tblTaiKhoan.getColumnModel().getColumn(0).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(1).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(2).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setText("Mã");

        jLabel17.setText("Họ tên");

        jLabel19.setText("Mật khẩu");

        jLabel21.setText("Vai trò");

        txtThemTaiK.setText("Thêm");
        txtThemTaiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThemTaiKActionPerformed(evt);
            }
        });

        txtSuaTaiK.setText("Sửa");
        txtSuaTaiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaTaiKActionPerformed(evt);
            }
        });

        txtXoaTaiK.setText("Xóa");
        txtXoaTaiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoaTaiKActionPerformed(evt);
            }
        });

        txtTimTaiK.setText("Tìm");
        txtTimTaiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimTaiKActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNV);
        rdoNV.setText("Nhân viên");

        buttonGroup1.add(rdoQL);
        rdoQL.setText("Quản lý");

        txtLoadTaiK.setText("LoadV");
        txtLoadTaiK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoadTaiKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taikhoanLayout = new javax.swing.GroupLayout(taikhoan);
        taikhoan.setLayout(taikhoanLayout);
        taikhoanLayout.setHorizontalGroup(
            taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taikhoanLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taikhoanLayout.createSequentialGroup()
                        .addComponent(txtSuaTaiK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLoadTaiK))
                    .addGroup(taikhoanLayout.createSequentialGroup()
                        .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaTk, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenTk, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNV)
                            .addComponent(rdoQL)))
                    .addGroup(taikhoanLayout.createSequentialGroup()
                        .addComponent(txtThemTaiK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtXoaTaiK))
                    .addGroup(taikhoanLayout.createSequentialGroup()
                        .addComponent(txtTimTK)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimTaiK)))
                .addGap(19, 19, 19))
        );
        taikhoanLayout.setVerticalGroup(
            taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(taikhoanLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimTaiK)
                    .addComponent(txtTimTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaTk))
                .addGap(18, 18, 18)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtHoTenTk))
                .addGap(18, 18, 18)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtMatKhau))
                .addGap(18, 18, 18)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(rdoNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoQL)
                .addGap(31, 31, 31)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThemTaiK)
                    .addComponent(txtXoaTaiK))
                .addGap(31, 31, 31)
                .addGroup(taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSuaTaiK)
                    .addComponent(txtLoadTaiK))
                .addGap(95, 95, 95))
        );

        home.add(taikhoan, "card6");

        nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanvienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nhanvienLayout = new javax.swing.GroupLayout(nhanvien);
        nhanvien.setLayout(nhanvienLayout);
        nhanvienLayout.setHorizontalGroup(
            nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        nhanvienLayout.setVerticalGroup(
            nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        home.add(nhanvien, "card7");

        lichsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lichsuMouseClicked(evt);
            }
        });

        tblLichS.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Hóa đơn"));
        tblLichS.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblLichSAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblLichS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSMouseClicked(evt);
            }
        });

        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày tạo", "Mã NV", "Trạng thái", "Tên KH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSuMouseClicked(evt);
            }
        });
        tblLichS.setViewportView(tblLichSu);
        if (tblLichSu.getColumnModel().getColumnCount() > 0) {
            tblLichSu.getColumnModel().getColumn(0).setResizable(false);
            tblLichSu.getColumnModel().getColumn(1).setResizable(false);
            tblLichSu.getColumnModel().getColumn(2).setResizable(false);
            tblLichSu.getColumnModel().getColumn(3).setResizable(false);
            tblLichSu.getColumnModel().getColumn(4).setResizable(false);
            tblLichSu.getColumnModel().getColumn(5).setResizable(false);
        }

        jScrollPane11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Sản phẩm"));

        tblSanPhamLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng ", "Giá", "Giảm giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tblSanPhamLichSu);
        if (tblSanPhamLichSu.getColumnModel().getColumnCount() > 0) {
            tblSanPhamLichSu.getColumnModel().getColumn(0).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(1).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(2).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(3).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(4).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(5).setResizable(false);
            tblSanPhamLichSu.getColumnModel().getColumn(6).setResizable(false);
        }

        jScrollPane12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin"));

        jLabel8.setText("Mã NV");

        jLabel9.setText("Tên KH");

        jLabel23.setText("Giá tiền");

        jLabel27.setText("Ngày lập");

        jLabel28.setText("Trạng thái");

        jLabel30.setText("Ghi chú");

        txtGhiChuLS.setColumns(20);
        txtGhiChuLS.setRows(5);
        jScrollPane10.setViewportView(txtGhiChuLS);

        jLabel31.setText("Hình thức tt");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNVLS, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTrangThaiLS))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayLapLS))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaTienLS))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenKHLS))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHinhThucTTLS)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaNVLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKHLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtGiaTienLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtNgayLapLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtTrangThaiLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtHinhThucTTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(jPanel4);

        javax.swing.GroupLayout lichsuLayout = new javax.swing.GroupLayout(lichsu);
        lichsu.setLayout(lichsuLayout);
        lichsuLayout.setHorizontalGroup(
            lichsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lichsuLayout.createSequentialGroup()
                .addGroup(lichsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tblLichS, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12))
        );
        lichsuLayout.setVerticalGroup(
            lichsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lichsuLayout.createSequentialGroup()
                .addComponent(tblLichS, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lichsuLayout.createSequentialGroup()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );

        home.add(lichsu, "card8");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnTKMouseClicked
        thongke.setVisible(true);
        sanpham.setVisible(false);
        hoadon.setVisible(false);
        voucher.setVisible(false);
        taikhoan.setVisible(false);
        nhanvien.setVisible(false);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnTKMouseClicked

    private void mnSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSPMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(true);
        hoadon.setVisible(false);
        voucher.setVisible(false);
        taikhoan.setVisible(false);
        nhanvien.setVisible(false);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnSPMouseClicked

    private void mnHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnHDMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(false);
        hoadon.setVisible(true);
        voucher.setVisible(false);
        taikhoan.setVisible(false);
        nhanvien.setVisible(false);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnHDMouseClicked

    private void mnVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnVCMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(false);
        hoadon.setVisible(false);
        voucher.setVisible(true);
        taikhoan.setVisible(false);
        nhanvien.setVisible(false);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnVCMouseClicked

    private void mnTKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnTKhoanMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(false);
        hoadon.setVisible(false);
        voucher.setVisible(false);
        taikhoan.setVisible(true);
        nhanvien.setVisible(false);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnTKhoanMouseClicked

    private void txtSzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSzeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSzeActionPerformed

    private void tblSANPHAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSANPHAMMouseClicked
        int row = tblSANPHAM.getSelectedRow();
        load(row);
    }//GEN-LAST:event_tblSANPHAMMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try {
            String maSP = txtTim.getText();
            if (maSP.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            }
            List<SanPham> productList = dao.findProductByMaSP(maSP);

            if (productList.isEmpty()) {
                MsgBox.alert(this, "Không tìm thấy sản phẩm có mã " + maSP);
            } else {
                updateTableKhiTim(productList);
                MsgBox.alert(this, "Tìm kiếm thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Tìm kiếm thất bại! Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        Table();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        deletesp();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        updatesp();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        insertsp();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnLoad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoad1ActionPerformed
        Tablesp();
    }//GEN-LAST:event_btnLoad1ActionPerformed

    private void txtMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMauSacActionPerformed

    private void btnTim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTim1ActionPerformed
        try {
            String maSPCT = txtTim1.getText();
            if (maSPCT.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            }
            List<SanPham> productList = dao.findProductByMaSP1(maSPCT);

            if (productList.isEmpty()) {
                MsgBox.alert(this, "Không tìm thấy sản phẩm có mã " + maSPCT);
            } else {
                updateTableKhiTimsp(productList);
                MsgBox.alert(this, "Tìm kiếm thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Tìm kiếm thất bại! Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTim1ActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        int row = tblSPCT.getSelectedRow();
        loadsp(row);
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        int row = tblTaiKhoan.getSelectedRow();
        loadtk(row);
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void tblDanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonMouseClicked
        int row = tblDanhSachHoaDon.getSelectedRow();
        loadhd(row);
    }//GEN-LAST:event_tblDanhSachHoaDonMouseClicked
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        // Load lại dữ liệu từ tblDanhSachSanPham vào tblGioHang
        returnQuantitiesToDanhSachSanPham(); // Gọi phương thức để load dữ liệu
        clearFormHD();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void mnLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnLSMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(false);
        hoadon.setVisible(false);
        voucher.setVisible(false);
        taikhoan.setVisible(false);
        nhanvien.setVisible(false);
        lichsu.setVisible(true);
    }//GEN-LAST:event_mnLSMouseClicked

    private void mnNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnNVMouseClicked
        thongke.setVisible(false);
        sanpham.setVisible(false);
        hoadon.setVisible(false);
        voucher.setVisible(false);
        taikhoan.setVisible(false);
        nhanvien.setVisible(true);
        lichsu.setVisible(false);
    }//GEN-LAST:event_mnNVMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblDanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSPMouseClicked
        if (evt.getClickCount() == 1) {
            int selectedRow = tblDanhSachSP.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tblDanhSachSP.getModel();
                String maSp = (String) model.getValueAt(selectedRow, 0);
                String tenSp = (String) model.getValueAt(selectedRow, 1);
                int soLuongHienTai = (int) model.getValueAt(selectedRow, 5);

                int newQuantity = promptForNewQuantity(tenSp, soLuongHienTai);
                if (newQuantity != -1) {
                    if (newQuantity <= soLuongHienTai) {
                        addToShoppingCart(maSp, tenSp, newQuantity);
                        int updatedQuantity = soLuongHienTai - newQuantity;
                        model.setValueAt(updatedQuantity, selectedRow, 5); // Cập nhật số lượng mới trong bảng tblDSSP
                    } else {
                        JOptionPane.showMessageDialog(null, "Số lượng nhập vào lớn hơn số lượng hiện có.");
                    }
                }
            }
        }
    }//GEN-LAST:event_tblDanhSachSPMouseClicked

    private void txtNgayLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayLapActionPerformed

    }//GEN-LAST:event_txtNgayLapActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKhachDuaFocusLost
        txtTienKhachDua.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
                    double tongTien = Double.parseDouble(lblTongTien.getText());
                    double tienTraKhach = tienKhachDua - tongTien;
                    lblTienTraKhach.setText(String.valueOf(tienTraKhach));
                } catch (NumberFormatException ex) {
                    lblTienTraKhach.setText("0"); // hoặc hiển thị thông báo lỗi
                }
            }
        });
    }//GEN-LAST:event_txtTienKhachDuaFocusLost

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        insertHoaDonChiTiet();
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        clearFormHD();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtXoaTaiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoaTaiKActionPerformed
        deletetk();
    }//GEN-LAST:event_txtXoaTaiKActionPerformed

    private void txtSuaTaiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaTaiKActionPerformed
        updatetk();
    }//GEN-LAST:event_txtSuaTaiKActionPerformed

    private void txtLoadTaiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoadTaiKActionPerformed
        Tabletk();
    }//GEN-LAST:event_txtLoadTaiKActionPerformed

    private void txtTimTaiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimTaiKActionPerformed
        try {
            String maNV = txtTimTK.getText();
            if (maNV.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            }
            List<TaiKhoan> productList = tk.findProductByMatk(maNV);

            if (productList.isEmpty()) {
                MsgBox.alert(this, "Không tìm thấy sản phẩm có mã " + maNV);
            } else {
                updateTableTaiKhoan(productList);
                MsgBox.alert(this, "Tìm kiếm thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Tìm kiếm thất bại! Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_txtTimTaiKActionPerformed

    private void txtThemTaiKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThemTaiKActionPerformed
        inserttk();
    }//GEN-LAST:event_txtThemTaiKActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inserthd();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboHinhThucThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThucThanhToanMouseClicked

    private void nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanvienMouseClicked

    }//GEN-LAST:event_nhanvienMouseClicked

    private void lichsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lichsuMouseClicked

    }//GEN-LAST:event_lichsuMouseClicked

    private void tblLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuMouseClicked
        int selectedRow = tblLichSu.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem đã chọn dòng nào chưa
            Object maHD = tblLichSu.getValueAt(selectedRow, 1); // Giả sử MaHD ở cột đầu tiên, cột 0
            HoaDon hoaDon = hd.layThongTinHoaDonTheoMaHD((int) maHD);
            if (hoaDon != null) {
                txtMaNVLS.setText(hoaDon.getMaNv());
                txtTenKHLS.setText(hoaDon.getTenKH());
                txtGiaTienLS.setText(String.valueOf(hoaDon.getGiaTien()));
                txtGhiChuLS.setText(hoaDon.getGhiChu());
                txtNgayLapLS.setText(String.valueOf(hoaDon.getNgayLap()));
                String trangThaiText = hoaDon.getTrangThai() ? "Đã thanh toán" : "Đang tạo";
                txtTrangThaiLS.setText(trangThaiText);
                txtHinhThucTTLS.setText(hoaDon.getHinhThucTT());
            }
            List<SanPham> danhSachSanPham = dao.laySanPhamTheoMaHD((int) maHD);
            DefaultTableModel model = (DefaultTableModel) tblSanPhamLichSu.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ trong bảng
            int i = 1;
            for (SanPham sp : danhSachSanPham) {
                // Thêm từng dòng dữ liệu vào bảng tblSanPhamLichSu
                model.addRow(new Object[]{
                    i++,
                    sp.getMaSp(),
                    sp.getTenSp(),
                    sp.getSoLuong(),
                    sp.getGia(),
                    sp.getGiamGia(),
                    // Tính toán TongTien
                    (sp.getGia() * sp.getSoLuong()) - (sp.getGiamGia() * sp.getSoLuong())
                });
            }
        }
    }//GEN-LAST:event_tblLichSuMouseClicked

    private void tblLichSAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblLichSAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLichSAncestorAdded

    private void tblLichSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLichSMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanAoSoMi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            BanAoSoMi frame = new BanAoSoMi();
            frame.setSize(1200, 650);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnLoad1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTim1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JPanel container;
    private javax.swing.JPanel hoadon;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTienTraKhach;
    private javax.swing.JLabel lblTienTraLai;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel lichsu;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel mnHD;
    private javax.swing.JLabel mnLS;
    private javax.swing.JLabel mnNV;
    private javax.swing.JLabel mnSP;
    private javax.swing.JLabel mnTK;
    private javax.swing.JLabel mnTKhoan;
    private javax.swing.JLabel mnThoat;
    private javax.swing.JLabel mnVC;
    private javax.swing.JPanel nhanvien;
    private javax.swing.JRadioButton rdoNV;
    private javax.swing.JRadioButton rdoQL;
    private javax.swing.JPanel sanpham;
    private javax.swing.JPanel taikhoan;
    private javax.swing.JTable tblDSSP;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTable tblDanhSachSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JScrollPane tblLichS;
    private javax.swing.JTable tblLichSu;
    private javax.swing.JTable tblSANPHAM;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTable tblSanPhamLichSu;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JPanel thongke;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextArea txtGhiChuLS;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaTienLS;
    private javax.swing.JTextField txtHinhThucTTLS;
    private javax.swing.JTextField txtHoTenTk;
    private javax.swing.JButton txtLoadTaiK;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaCT;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNVLS;
    private javax.swing.JTextField txtMaTk;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtMatableCT;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNgayLapLS;
    private javax.swing.JTextField txtSale;
    private javax.swing.JTextField txtSoL;
    private javax.swing.JButton txtSuaTaiK;
    private javax.swing.JTextField txtSze;
    private javax.swing.JTextField txtTenKHLS;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JButton txtThemTaiK;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTim1;
    private javax.swing.JTextField txtTimTK;
    private javax.swing.JButton txtTimTaiK;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTrangThaiLS;
    private javax.swing.JButton txtXoaTaiK;
    private javax.swing.JPanel voucher;
    // End of variables declaration//GEN-END:variables

    int width = 200;
    int height = 600;

    public void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    menu.setSize(i, height);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BanAoSoMi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }

    // dong menu
    public void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    menu.setSize(i, height);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BanAoSoMi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }
// san pham 

    private SanPham getForm() {
        SanPham cd = new SanPham();
        cd.setMaSp(txtMa.getText());
        cd.setTenSp(txtTenSp.getText());
        cd.setSize(txtSze.getText());
        cd.setMoTa(txtMota.getText());
        return cd;
    }

    private void setForm(SanPham cd) {
        txtMa.setText(cd.getMaSp());
        txtTenSp.setText(cd.getTenSp());
        txtSze.setText(cd.getSize());
        txtMota.setText(cd.getMoTa());
    }

    private void clearForm() {
        SanPham sp = new SanPham();
        this.setForm(sp);
    }

    public void load(int row) {
        if (row != -1) {
            String ma = (tblSANPHAM.getValueAt(row, 0) != null) ? tblSANPHAM.getValueAt(row, 0).toString() : "";
            String ten = (tblSANPHAM.getValueAt(row, 1) != null) ? tblSANPHAM.getValueAt(row, 1).toString() : "";
            String size = (tblSANPHAM.getValueAt(row, 2) != null) ? tblSANPHAM.getValueAt(row, 2).toString() : "";
            String mota = (tblSANPHAM.getValueAt(row, 3) != null) ? tblSANPHAM.getValueAt(row, 3).toString() : "";

            txtMa.setText(ma);
            txtTenSp.setText(ten);
            txtSze.setText(size);
            txtMota.setText(mota);
        }
    }

    private void Table() {
        if (tblSANPHAM != null) {
            DefaultTableModel model = (DefaultTableModel) tblSANPHAM.getModel();
            model.setRowCount(0); // Xóa các hàng hiện có

            try {
                List<SanPham> list = dao.selectAll();

                for (SanPham sp : list) {
                    Object[] row = {
                        sp.getMaSp(),
                        sp.getTenSp(),
                        sp.getSize(),
                        sp.getMoTa()
                    };
                    model.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace(); // In dãy đặc tả đầy đủ để gỡ lỗi
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            System.out.println("Lỗi: tableSanPham là null.");
        }
    }

    private void insert() {
        try {
            SanPham cd = getForm();
            dao.insert(cd);
            this.Table();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void update() {
        try {
            SanPham cd = getForm();
            dao.update(cd);
            this.Table();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void delete() {
        try {
            String maSP = txtMa.getText();
            if (maSP.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            } else {
                // Thực hiện xóa chuyên đề trong cơ sở dữ liệu
                dao.delete(maSP);
                this.Table();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Xóa thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void updateTableKhiTim(List<SanPham> productList) {
        DefaultTableModel model = (DefaultTableModel) tblSANPHAM.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (SanPham sanPham : productList) {
            Object[] rowData = {sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getSize(), sanPham.getMoTa()};
            model.addRow(rowData);
        }
    }
/// san pham chi tiết

    private SanPham getFormsp() {
        SanPham cd = new SanPham();
        cd.setMaSPCT(txtMaCT.getText());
        cd.setMaSp(txtMatableCT.getText());
        cd.setMauSac(txtMauSac.getText());
        cd.setChatLieu(txtChatLieu.getText());
        cd.setSoLuong(Integer.parseInt(txtSoL.getText()));
        cd.setGia(Integer.parseInt(txtGia.getText()));
        cd.setSale(Integer.parseInt(txtSale.getText()));
        return cd;
    }

    private void setFormsp(SanPham cd) {
        txtMaCT.setText(cd.getMaSPCT());
        txtMatableCT.setText(cd.getMaSp());
        txtMauSac.setText(cd.getMauSac());
        txtChatLieu.setText(cd.getChatLieu());
        txtSoL.setText(String.valueOf(cd.getSoLuong()));
        txtGia.setText(String.valueOf(cd.getGia()));
        txtSale.setText(String.valueOf(cd.getSale()));
    }

    private void clearFormsp() {
        SanPham sp = new SanPham();
        this.setFormsp(sp);
    }

    public void loadsp(int row) {
        if (row != -1) {
            String mact = (tblSPCT.getValueAt(row, 0) != null) ? tblSPCT.getValueAt(row, 0).toString() : "";
            String ma = (tblSPCT.getValueAt(row, 1) != null) ? tblSPCT.getValueAt(row, 1).toString() : "";
            String mau = (tblSPCT.getValueAt(row, 2) != null) ? tblSPCT.getValueAt(row, 2).toString() : "";
            String chatL = (tblSPCT.getValueAt(row, 3) != null) ? tblSPCT.getValueAt(row, 3).toString() : "";
            String soL = (tblSPCT.getValueAt(row, 4) != null) ? tblSPCT.getValueAt(row, 4).toString() : "";
            String Gia = (tblSPCT.getValueAt(row, 5) != null) ? tblSPCT.getValueAt(row, 5).toString() : "";
            String saLe = (tblSPCT.getValueAt(row, 6) != null) ? tblSPCT.getValueAt(row, 6).toString() : "";

            txtMaCT.setText(mact);
            txtMatableCT.setText(ma);
            txtMauSac.setText(mau);
            txtChatLieu.setText(chatL);
            txtSoL.setText(soL);
            txtGia.setText(Gia);
            txtSale.setText((saLe));
        }
    }

    private void Tablesp() {
        if (tblSPCT != null) {
            DefaultTableModel model = (DefaultTableModel) tblSPCT.getModel();
            model.setRowCount(0); // Xóa các hàng hiện có

            try {
                List<SanPham> list = dao.selectAll1();

                for (SanPham sp : list) {
                    Object[] row = {
                        sp.getMaSPCT(),
                        sp.getMaSp(),
                        sp.getMauSac(),
                        sp.getChatLieu(),
                        sp.getSoLuong(),
                        sp.getGia(),
                        sp.getSale()
                    };
                    model.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace(); // In dãy đặc tả đầy đủ để gỡ lỗi
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            System.out.println("Lỗi: tableSanPham là null.");
        }
    }

    private void insertsp() {
        try {
            SanPham cd = getFormsp();
            dao.insert1(cd);
            this.Tablesp();
            this.clearFormsp();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void updatesp() {
        try {
            SanPham cd = getFormsp();
            dao.update1(cd);
            this.Tablesp();
            this.clearFormsp();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void deletesp() {
        try {
            String maSPCT = txtMaCT.getText();
            if (maSPCT.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            } else {
                // Thực hiện xóa chuyên đề trong cơ sở dữ liệu
                dao.delete1(maSPCT);
                this.Tablesp();
                this.clearFormsp();
                MsgBox.alert(this, "Xóa thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Xóa thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void updateTableKhiTimsp(List<SanPham> productList) {
        DefaultTableModel model = (DefaultTableModel) tblSPCT.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (SanPham sanPham : productList) {
            Object[] rowData = {sanPham.getMaSPCT(), sanPham.getMaSp(), sanPham.getMauSac(),
                sanPham.getChatLieu(), sanPham.getSoLuong(), sanPham.getGia(), sanPham.getSale()};
            model.addRow(rowData);
        }
    }

    //////////////////////////Tài khoản
    private TaiKhoan getFormtk() {
        TaiKhoan cd = new TaiKhoan();
        cd.setMaNv(txtMaTk.getText());
        cd.setHoTen(txtHoTenTk.getText());
        cd.setMatKhau(txtMatKhau.getText());
        cd.setVaiTro(rdoQL.isSelected()); // True nếu Quản lý, False nếu Nhân viên
        return cd;
    }

    private void setFormtk(TaiKhoan cd) {
        txtMaTk.setText(cd.getMaNv());
        txtHoTenTk.setText(cd.getHoTen());
        txtMatKhau.setText(cd.getMatKhau());

        Boolean vaiTro = cd.getVaiTro();
        if (vaiTro != null) {
            if (vaiTro) {
                rdoNV.setSelected(true);
                rdoQL.setSelected(false);
            } else {
                rdoNV.setSelected(false);
                rdoQL.setSelected(true);
            }
        } else {
            rdoNV.setSelected(false);
            rdoQL.setSelected(false);
        }
    }

    private void clearFormtk() {
        TaiKhoan sp = new TaiKhoan();
        this.setFormtk(sp);
    }

    public void loadtk(int row) {
        if (row != -1) {
            String manv = (tblTaiKhoan.getValueAt(row, 0) != null) ? tblTaiKhoan.getValueAt(row, 0).toString() : "";
            String hoten = (tblTaiKhoan.getValueAt(row, 1) != null) ? tblTaiKhoan.getValueAt(row, 1).toString() : "";
            String matK = (tblTaiKhoan.getValueAt(row, 2) != null) ? tblTaiKhoan.getValueAt(row, 2).toString() : "";
            String vaiT = (tblTaiKhoan.getValueAt(row, 3) != null) ? tblTaiKhoan.getValueAt(row, 3).toString() : "";

            txtMaTk.setText(manv);
            txtHoTenTk.setText(hoten);
            txtMatKhau.setText(matK);

            if ("Quản lý".equals(vaiT)) {
                rdoQL.setSelected(true);
                rdoNV.setSelected(false);
            } else if ("Nhân viên".equals(vaiT)) {
                rdoQL.setSelected(false);
                rdoNV.setSelected(true);
            }
        }
    }

    private void Tabletk() {
        if (tblTaiKhoan != null) {
            DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
            model.setRowCount(0); // Xóa các hàng hiện có

            try {
                List<TaiKhoan> list = tk.selectAlltk();

                for (TaiKhoan sp : list) {
                    String vaiTroText = (sp.getVaiTro()) ? "Quản lý" : "Nhân viên";

                    Object[] row = {
                        sp.getMaNv(),
                        sp.getHoTen(),
                        sp.getMatKhau(),
                        vaiTroText // Sử dụng vaiTroText thay vì sp.getVaiTro()
                    };
                    model.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace(); // In dãy đặc tả đầy đủ để gỡ lỗi
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            System.out.println("Lỗi: tableSanPham là null.");
        }
    }

    private void inserttk() {
        try {
            TaiKhoan cd = getFormtk();
            tk.inserttk(cd);
            this.Tabletk();
            this.clearFormtk();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void updatetk() {
        try {
            TaiKhoan cd = getFormtk();
            tk.updatetk(cd);
            this.Tabletk();
            this.clearFormtk();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void deletetk() {
        try {
            String maNV = txtMaTk.getText();
            if (maNV.isEmpty()) {
                MsgBox.alert(this, "Mã sản phẩm không được để trống.");
                return;
            } else {
                // Thực hiện xóa chuyên đề trong cơ sở dữ liệu
                tk.deletetk(maNV);
                this.Tabletk();
                this.clearFormtk();
                MsgBox.alert(this, "Xóa thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Xóa thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void updateTableTaiKhoan(List<TaiKhoan> productList) {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (TaiKhoan sp : productList) {
            String vaiTroText = (sp.getVaiTro()) ? "Quản lý" : "Nhân viên";

            Object[] row = {
                sp.getMaNv(),
                sp.getHoTen(),
                sp.getMatKhau(),
                vaiTroText // Sử dụng vaiTroText thay vì sp.getVaiTro()
            };
            model.addRow(row);
        }
    }

    /////////////////////////////Hóa ĐƠn
    //fill table
    private void initHD() {
        fillTableDSHoaDon(listAll);
        fillTableDSSP(listAllSP);
    }
    HoaDonService hdservice = new HoaDonService();
    List<HoaDon> listAll = hdservice.selectAll();
    List<SanPham> listAllSP = hdservice.DSSanPham();

    private void fillTableDSHoaDon(List<HoaDon> list) {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        model.setRowCount(0);
        // Lấy danh sách hóa đơn từ service hoặc nguồn dữ liệu phù hợp
        list = hdservice.selectAll();
        // Thêm những hóa đơn có trạng thái là "Đang tạo" vào bảng
        for (HoaDon hd : list) {
            if (!hd.getTrangThai()) { // Trạng thái là false (0 - Đang tạo)
                String trangThai = hd.getTrangThai() ? "Đã thanh toán" : "Đang tạo";
                Object[] row = {hd.getMaHD(), hd.getNgayLap(), hd.getMaNv(), trangThai};
                model.addRow(row);
            }
        }
    }

    public void loadhd(int row) {
        if (row != -1) {
            String mahd = (tblDanhSachHoaDon.getValueAt(row, 0) != null) ? tblDanhSachHoaDon.getValueAt(row, 0).toString() : "";

            txtMaHD.setText(mahd);

        }
    }

    void fillTableGiaoHang() {
        List<SanPham> list = new ArrayList<>();
        SanPham row = new SanPham();
        list.add(row);

    }

    void fillTableDSSP(List<SanPham> list) {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachSP.getModel();
        model.setRowCount(0);

        list = hdservice.DSSanPham();

        for (SanPham sp : list) {
            Object[] row = {sp.getMaSp(), sp.getTenSp(), sp.getMauSac(), sp.getChatLieu(), sp.getSize(), sp.getSoLuong(), sp.getGia()};
            model.addRow(row);
        }
    }

    void setformHD(int index) {
        List<HoaDon> listAll = hdservice.getAllHD();
        HoaDon hd = listAll.get(index);
        txtMaHD.setText(hd.getMaHD() + "");
        txtTenKhachHang.setText(hd.getTenKH());
        txtMaNV.setText(hd.getMaNv());
        txtNgayLap.setText(hd.getNgayLap() + "");
        cboHinhThucThanhToan.setSelectedItem(hd.getMaVoucher());
        lblTongTien.setText(hd.getTongTien() + "");
    }

    void clearFormHD() {
        txtMaHD.setText("");
        txtTenKhachHang.setText("");
        txtMaNV.setText("");
        txtNgayLap.setText(XDate.toString(XDate.now(), "dd-MM-yyyy"));
        cboHinhThucThanhToan.setSelectedIndex(0);
        lblTongTien.setText("-");
        lblTienTraKhach.setText("-");
        txtGhichu.setText("");
        txtTienKhachDua.setText("");
    }

    private HoaDon getFormhd() {
        HoaDon cd = new HoaDon();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = dateFormat.parse(txtNgayLap.getText());
            cd.setNgayLap(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Xử lý hoặc báo lỗi nếu có vấn đề trong quá trình chuyển đổi
        }
        cd.setMaNv(txtMaNV.getText());
        return cd;
    }

    private void inserthd() {
        try {
            HoaDon cd = getFormhd();
            hd.inserthd(cd);
            this.fillTableDSHoaDon(listAll);
            this.clearFormsp();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để kiểm tra nguyên nhân
            MsgBox.alert(this, "Thêm mới thất bại! Lỗi: " + e.getMessage());
        }
    }

    private void moDialogDangNhap() {
        Dangnhap1 dangNhapDialog = new Dangnhap1(this, true); // Khởi tạo đối tượng DangNhap
        dangNhapDialog.setVisible(true); // Hiển thị dialog

        // Sau khi người dùng đăng nhập thành công và đóng dialog, lấy MaNV từ dialog
        // Cập nhật giá trị txtMaNV trong JFrame
        if (Auth.isLogin() && Auth.User != null) {
            txtMaNV.setText(Auth.User.getMaNv()); // Gán giá trị MaNV vào JTextField txtMaNV
        }

    }

//////////////////////////////////// bán hàng
//    private void refreshShoppingCartTable() {
//        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
//        model.setRowCount(0); // Xóa tất cả các dòng trong bảng
//
//        try {
//            List<SanPham> list = dao.getItemDetails(maSP);
//            for (SanPham item : list) {
//                Object[] row = {
//                    item.getMaSp(),
//                    item.getTenSp(),
//                    item.getSize(),
//                    item.getSoLuong(),
//                    item.getGia(),
//                    item.getGiamGia(),
//                    item.getThanhTien(),};
//                model.addRow(row); // Thêm dòng dữ liệu vào bảng
//            }
//        } catch (Exception e) {
//            MsgBox.alert(this, "Lỗi truy vấn dữ liệu giỏ hàng!");
//        }
//    }
    private int promptForNewQuantity(String productName, int currentQuantity) {
        String input = JOptionPane.showInputDialog(null, "Nhập số lượng mới cho sản phẩm " + productName + ":",
                "Nhập số lượng", JOptionPane.QUESTION_MESSAGE);
        try {
            if (input != null) {
                int newQuantity = Integer.parseInt(input);
                if (newQuantity >= 0) {
                    return newQuantity;
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng không âm.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập một số nguyên hợp lệ.");
        }
        return -1; // Trả về -1 nếu có lỗi hoặc người dùng hủy bỏ
    }
///Gio hang

    private void addToShoppingCart(String maSp, String tenSp, int quantity) {
        try {
            // Lấy thông tin sản phẩm từ cơ sở dữ liệu dựa trên mã sản phẩm
            SanPham sanPham = dao.getGiaByMaSP(maSp);
            int gia = sanPham.getGia(); // Lấy giá từ đối tượng SanPham
            String size = sanPham.getSize(); // Lấy thông tin về size
            int giamGia = sanPham.getGiamGia(); // Lấy thông tin về giảm giá

            // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
            DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
            boolean found = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String maSanPham = model.getValueAt(i, 0).toString(); // Lấy mã sản phẩm từ bảng giỏ hàng
                if (maSanPham.equals(maSp)) {
                    // Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng mới cho sản phẩm
                    int currentQuantity = Integer.parseInt(model.getValueAt(i, 3).toString());
                    int newQuantity = currentQuantity + quantity;
                    int thanhTien = newQuantity * gia; // Tính toán ThanhTien mới
                    model.setValueAt(newQuantity, i, 3); // Cập nhật số lượng mới cho sản phẩm
                    model.setValueAt(thanhTien, i, 6); // Cập nhật ThanhTien mới cho sản phẩm
                    found = true;
                    break;
                }
            }

            // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm hàng mới vào bảng giỏ hàng
            if (!found) {
                Object[] row = {maSp, tenSp, size, quantity, gia, giamGia, quantity * gia}; // Thêm thông tin size và giảm giá vào hàng mới
                model.addRow(row); // Thêm hàng mới vào bảng giỏ hàng
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu giỏ hàng!");
        }
        calculateTotal();
    }

    private void calculateTotal() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        int rowCount = model.getRowCount();
        int total = 0;

        // Tính tổng số tiền từ cột ThanhTien trong tblGioHang
        for (int i = 0; i < rowCount; i++) {
            int thanhTien = Integer.parseInt(model.getValueAt(i, 6).toString()); // ThanhTien ở cột thứ 6
            total += thanhTien;
        }

        // Hiển thị tổng số tiền trên lblTongTien
        lblTongTien.setText(String.valueOf(total));
    }

    // NÚT HỦY TẠO HÓA ĐƠN
    private void returnQuantitiesToDanhSachSanPham() {
        DefaultTableModel modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        DefaultTableModel modelDanhSachSanPham = (DefaultTableModel) tblDanhSachSP.getModel();

        for (int i = 0; i < modelGioHang.getRowCount(); i++) {
            String maSPGioHang = modelGioHang.getValueAt(i, 0).toString();
            int soLuongGioHang = Integer.parseInt(modelGioHang.getValueAt(i, 3).toString());

            // Tìm và cập nhật số lượng sản phẩm trong tblDanhSachSanPham
            for (int j = 0; j < modelDanhSachSanPham.getRowCount(); j++) {
                String maSPDanhSachSanPham = modelDanhSachSanPham.getValueAt(j, 0).toString();

                if (maSPGioHang.equals(maSPDanhSachSanPham)) {
                    int soLuongHienTai = Integer.parseInt(modelDanhSachSanPham.getValueAt(j, 5).toString());
                    int soLuongMoi = soLuongHienTai + soLuongGioHang;
                    modelDanhSachSanPham.setValueAt(soLuongMoi, j, 5); // Cập nhật số lượng mới
                    break;
                }
            }
        }

        // Cập nhật lại hiển thị của tblDanhSachSanPham (nếu cần)
        fillTableDSSP(listAllSP);
        // Gọi phương thức reloadDataForDanhSachSanPham() để load lại dữ liệu cho tblDanhSachSanPham
    }
//    private void updateSanPhamViewTable(int rowIndex, int newQuantity) {
//        // Cập nhật số lượng của sản phẩm trên bảng SanPham_View
//        tblDSSP.setValueAt(newQuantity, rowIndex, 5);
//    }

    /////////////////////////// THANH TOAN (HOA DON CHI TIET) 
    private void insertHoaDonChiTiet() {
        try {
            DefaultTableModel modelGioHang = (DefaultTableModel) tblGioHang.getModel();
            String maHD = txtMaHD.getText();
            String tenKhachHang = txtTenKhachHang.getText();
            String hinhThucThanhToan = cboHinhThucThanhToan.getSelectedItem().toString();
            String ghiChu = txtGhichu.getText();

            for (int i = 0; i < modelGioHang.getRowCount(); i++) {
                String maSP = modelGioHang.getValueAt(i, 0).toString();
                int soLuong = Integer.parseInt(modelGioHang.getValueAt(i, 3).toString());
                int tongTien = Integer.parseInt(modelGioHang.getValueAt(i, 6).toString());

                // Thực hiện insert dữ liệu vào bảng HoaDonChiTiet từ giá trị thu thập được
                HoaDon hoaDonChiTiet = new HoaDon();
                hoaDonChiTiet.setMaHD(Integer.parseInt(maHD));
                hoaDonChiTiet.setTenKH(tenKhachHang);
                hoaDonChiTiet.setMaSp(maSP);
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTiet.setGiaTien(tongTien);
                hoaDonChiTiet.setHinhThucTT(hinhThucThanhToan);
                hoaDonChiTiet.setGhiChu(ghiChu);

                // Gọi phương thức insertHoaDonChiTiet trong HoaDonChiTietService để thêm dữ liệu vào cơ sở dữ liệu
                hd.inserthdct(hoaDonChiTiet);

                HoaDon hoaDon = hd.selectByIdhd(Integer.parseInt(maHD));
                if (hoaDon != null) {
                    hoaDon.setTrangThai(true);
                    hd.updateHoaDonStatus(hoaDon.getMaHD(), true);
                    fillTableDSHoaDon(listAll);
                }
                MsgBox.alert(this, "Thanh toán thành công!");
                fillTableLICHSU(listAll);
            }
            updateSanPhamQuantity(tblGioHang);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi khi thêm dữ liệu vào bảng HoaDonChiTiet!");
        }
    }

    private void updateSanPhamQuantity(JTable tblGioHang) {
        SanPhamService dao = new SanPhamService(); // Khai báo và khởi tạo đối tượng SanPhamService

        try {
            DefaultTableModel modelGioHang = (DefaultTableModel) tblGioHang.getModel();

            for (int i = 0; i < modelGioHang.getRowCount(); i++) {
                String maSP = modelGioHang.getValueAt(i, 0).toString();
                int soLuong = Integer.parseInt(modelGioHang.getValueAt(i, 3).toString());

                int currentQuantity = dao.getSoLuongByMaSP(maSP);

                if (currentQuantity >= soLuong) {
                    int newQuantity = currentQuantity - soLuong;
                    dao.updateSoLuong(maSP, newQuantity);
                } else {
                    MsgBox.alert(this, "Sản phẩm không đủ số lượng!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ khi cập nhật dữ liệu bảng SanPham
        }
    }
    ///////////////////////////////////////////////////////////////////////////////// Lịch sử

    private void fillTableLICHSU(List<HoaDon> list) {
        DefaultTableModel model = (DefaultTableModel) tblLichSu.getModel();
        model.setRowCount(0);

        // Lấy danh sách hóa đơn từ service hoặc nguồn dữ liệu phù hợp
        list = hdservice.selectAlLICHSU();

        Map<Integer, HoaDon> mergedData = hd.mergeByMaHD(list); // Gọi phương thức từ service

        // Thêm những hóa đơn có trạng thái là "Đang tạo" vào bảng
        int i = 1;
        for (HoaDon hd : mergedData.values()) {
            String trangThai = hd.getTrangThai() ? "Đã thanh toán" : "Đang tạo";
            Object[] row = {i++, hd.getMaHD(), hd.getNgayLap(), hd.getMaNv(), trangThai, hd.getTenKH()};
            model.addRow(row);
        }
    }

}
