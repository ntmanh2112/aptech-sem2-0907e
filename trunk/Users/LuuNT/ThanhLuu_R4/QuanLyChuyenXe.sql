
Create database QUANLYCHUYENXE
GO
USE
	QUANLYCHUYENXE
GO
CREATE TABLE [ChuyenXe] (
    [TenChuyenXe] NVARCHAR(40),
    CONSTRAINT [PK_ChuyenXe] PRIMARY KEY ([TenChuyenXe])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "SoGhe"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE [SoGhe] (
    [ID] INTEGER IDENTITY(0,1) NOT NULL,
    [MaChuyenXe] nvarchar(40),
    [TinhTrang] NVARCHAR(40),
	[TenGhe] NVARCHAR(40),
    CONSTRAINT [PK_SoGhe] PRIMARY KEY ([ID])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "TinhTrang"                                                  */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */



ALTER TABLE [SoGhe] ADD CONSTRAINT [ChuyenXe_SoGhe] 
    FOREIGN KEY ([MaChuyenXe]) REFERENCES [ChuyenXe] ([TenChuyenXe])
GO
Insert into ChuyenXe values ('Bus01')
Insert into ChuyenXe values ('Bus02')
Insert into ChuyenXe values ('Bus03')
Insert into ChuyenXe values ('Bus04')
Insert into ChuyenXe values ('Bus05')
Insert into ChuyenXe values ('Bus06')
Insert into ChuyenXe values ('Bus07')
GO
Insert into SoGhe values ('Bus01','Còn Trống','Bus01A')
Insert into SoGhe values ('Bus01','Còn Trống','Bus01B')
Insert into SoGhe values ('Bus01','Còn Trống','Bus01C')
Insert into SoGhe values ('Bus01','Còn Trống','Bus01D')
Insert into SoGhe values ('Bus01','Còn Trống','Bus01E')

Insert into SoGhe values ('Bus02','Còn Trống','Bus02A')
Insert into SoGhe values ('Bus02','Còn Trống','Bus02B')
Insert into SoGhe values ('Bus02','Còn Trống','Bus02C')
Insert into SoGhe values ('Bus02','Còn Trống','Bus02D')
Insert into SoGhe values ('Bus02','Còn Trống','Bus02E')

Insert into SoGhe values ('Bus03','Còn Trống','Bus03A')
Insert into SoGhe values ('Bus03','Còn Trống','Bus03B')
Insert into SoGhe values ('Bus03','Còn Trống','Bus03C')
Insert into SoGhe values ('Bus03','Đặt Rồi','Bus03D')
Insert into SoGhe values ('Bus03','Đặt Rồi','Bus03E')

Insert into SoGhe values ('Bus04','Còn Trống','Bus04A')
Insert into SoGhe values ('Bus04','Còn Trống','Bus04B')
Insert into SoGhe values ('Bus04','Còn Trống','Bus04C')
Insert into SoGhe values ('Bus04','Còn Trống','Bus04D')
Insert into SoGhe values ('Bus04','Còn Trống','Bus04E')

Insert into SoGhe values ('Bus05','Còn Trống','Bus05A')
Insert into SoGhe values ('Bus05','Còn Trống','Bus05B')
Insert into SoGhe values ('Bus05','Còn Trống','Bus05C')
Insert into SoGhe values ('Bus05','Còn Trống','Bus05D')
Insert into SoGhe values ('Bus05','Còn Trống','Bus05E')

Insert into SoGhe values ('Bus06','Còn Trống','Bus06A')
Insert into SoGhe values ('Bus06','Còn Trống','Bus06B')
Insert into SoGhe values ('Bus06','Còn Trống','Bus06C')
Insert into SoGhe values ('Bus06','Còn Trống','Bus06D')
Insert into SoGhe values ('Bus06','Còn Trống','Bus06E')

Insert into SoGhe values ('Bus07','Còn Trống','Bus07A')
Insert into SoGhe values ('Bus07','Còn Trống','Bus07B')
Insert into SoGhe values ('Bus07','Còn Trống','Bus07C')
Insert into SoGhe values ('Bus07','Còn Trống','Bus07D')
Insert into SoGhe values ('Bus07','Còn Trống','Bus07E')
GO