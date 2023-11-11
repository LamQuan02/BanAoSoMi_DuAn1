    CREATE DATABASE DuAn1;
    GO
    USE DuAn1;
    GO

    --DROP DATABASE DuAn1

    CREATE TABLE TaiKhoan
    (
        MaNV VARCHAR(10) PRIMARY KEY,
        HoTen NVARCHAR(50),
        MatKhau VARCHAR(25) NOT NULL,
        VaiTro bit NOT NULL
    );
GO

CREATE TABLE Voucher
(
    MaVoucher INT IDENTITY(1,1) PRIMARY KEY,
    TenKM NVARCHAR(25),
    NgayBatDau DATE,
    NgayKetThuc DATE,
    GiamGia INT,
    TrangThai BIT,
);

    GO

    CREATE TABLE HoaDon
    (
        MaHD INT IDENTITY(1,1) PRIMARY KEY,
        TenKH NVARCHAR(50),
        NgayLap DATE NOT NULL,
        MaNV VARCHAR(10),
        TongTien INT,
        FOREIGN KEY (MaNV) REFERENCES TaiKhoan(MaNV)
    );
GO

    CREATE TABLE SanPham
    (
        MaSP VARCHAR(25) PRIMARY KEY,
        TenSP NVARCHAR(50),
        SIZE VARCHAR(2),
        MoTa NVARCHAR(255),
    );
GO

    CREATE TABLE SanPhamChiTiet
    (
        MaSPCT VARCHAR(25) PRIMARY KEY,
        MaSP VARCHAR(25),
        MauSac VARCHAR(25),
        ChatLieu VARCHAR(25),
        SoLuong INT,
        Gia INT,
        SALE INT,
        FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
    );
GO

    CREATE TABLE HoaDonChiTiet
    (
        MaHDCT INT IDENTITY(1,1) PRIMARY KEY,
        MaHD INT,
        MaSP VARCHAR(25),
        SoLuong INT NOT NULL,
        GiaTien INT NOT NULL,
        MaVoucher INT,
        TrangThai BIT NOT NULL,
        GhiChu NVARCHAR(50),
        FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
        FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
        FOREIGN KEY (MaVoucher) REFERENCES Voucher(MaVoucher)
    );
  

SELECT * FROM TaiKhoan
SELECT * FROM HoaDon
SELECT * FROM HoaDonChiTiet
SELECT * FROM SanPham
SELECT * FROM SanPhamChiTiet
SELECT * FROM Voucher

INSERT INTO TaiKhoan (MaNV, HoTen, MatKhau, VaiTro)
VALUES ('NV001', N'Nguyễn Văn A', 'password123', 1),
       ('NV002', N'Nguyễn Thị B', 'securepass', 0),
       ('NV003', N'Trần Văn C', '123456', 1),
       ('NV004', N'Lê Thị D', 'pass1234', 0),
       ('NV005', N'Phạm Văn E', 'abcde', 1);

INSERT INTO Voucher (TenKM, NgayBatDau, NgayKetThuc, GiamGia, TrangThai)
VALUES (N'Voucher1', '2023-11-01', '2023-11-30', 10, 1),
       (N'Voucher2', '2023-12-01', '2023-12-31', 20, 1),
       (N'Voucher3', '2023-10-01', '2023-10-31', 15, 1),
       (N'Voucher4', '2023-11-15', '2023-11-30', 5, 1),
       (N'Voucher5', '2023-12-15', '2023-12-31', 25, 1);
INSERT INTO Voucher (TenKM, NgayBatDau, NgayKetThuc, GiamGia, TrangThai)
VALUES (N'Voucher6', '2023-11-01', '2023-11-30', 10, 0)


INSERT INTO HoaDon (TenKH, NgayLap, MaNV, TongTien)
VALUES (N'Khách Hàng 1', '2023-11-05', 'NV001', 1000),
       (N'Khách Hàng 2', '2023-11-10', 'NV002', 1500),
       (N'Khách Hàng 3', '2023-11-15', 'NV003', 800),
       (N'Khách Hàng 4', '2023-11-20', 'NV004', 1200),
       (N'Khách Hàng 5', '2023-11-25', 'NV005', 2000);

INSERT INTO SanPham (MaSP, TenSP, SIZE, MoTa)
VALUES ('SP001', N'Sản phẩm 1', 'M', N'Mô tả sản phẩm 1'),
       ('SP002', N'Sản phẩm 2', 'L', N'Mô tả sản phẩm 2'),
       ('SP003', N'Sản phẩm 3', 'S', N'Mô tả sản phẩm 3'),
       ('SP004', N'Sản phẩm 4', 'XL', N'Mô tả sản phẩm 4'),
       ('SP005', N'Sản phẩm 5', 'M', N'Mô tả sản phẩm 5');

INSERT INTO SanPhamChiTiet (MaSPCT, MaSP, MauSac, ChatLieu, SoLuong, Gia, SALE)
VALUES ('SPCT001', 'SP001', 'Đỏ', 'Vải', 10, 500, 0),
       ('SPCT002', 'SP001', 'Xanh', 'Lụa', 5, 800, 0),
       ('SPCT003', 'SP002', 'Trắng', 'Jeans', 8, 700, 0),
       ('SPCT004', 'SP003', 'Đen', 'Da', 15, 1200, 0),
       ('SPCT005', 'SP004', 'Xám', 'Len', 20, 1500, 0);

	   
INSERT INTO HoaDonChiTiet (MaHD, MaSP, SoLuong, GiaTien, MaVoucher, TrangThai, GhiChu)
VALUES (1, 'SP001', 2, 1000, 1, 1, N''),
       (2, 'SP002', 3, 1400, 2, 1, N''),
       (3, 'SP003', 1, 700, 3, 1, N''),
       (4, 'SP004', 2, 2400, 4, 1, N''),
       (5, 'SP005', 5, 7500, 5, 1, N'');