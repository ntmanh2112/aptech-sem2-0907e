if exists (select * from dbo.sysobjects where name = 'sp_GetSoGheConTrong')
begin
	drop proc sp_GetSoGheConTrong
end
go
create proc sp_GetSoGheConTrong
	@maChuyenXe nvarchar(40)
as
begin 
if exists(select * from SoGhe where MaChuyenXe = @maChuyenXe)
		begin
			select 
				*
			From SoGhe 
			Where SoGhe.TinhTrang = 'Còn Trống' And SoGhe.MaChuyenXe = @maChuyenXe
			
		end
	else
		begin
			select 
				*
			From SoGhe 
			Where SoGhe.TinhTrang = 'Còn Trống' 
		end
end


