if exists (select * from dbo.sysobjects where name = 'sp_GetGheDatRoi')
	begin
		drop proc sp_GetGheDatRoi
	end
go
create proc sp_GetGheDatRoi 
	@maChuyenXe nvarchar(40)
as
begin 
if exists(select * from SoGhe where MaChuyenXe = @maChuyenXe)
		begin
			select 
				*
			From SoGhe 
			Where SoGhe.TinhTrang = 'Đặt Rồi' And SoGhe.MaChuyenXe = @maChuyenXe
			
		end
	else
		begin
			select 
				*
			From SoGhe 
			Where SoGhe.TinhTrang = 'Đặt Rồi' 
		end
end