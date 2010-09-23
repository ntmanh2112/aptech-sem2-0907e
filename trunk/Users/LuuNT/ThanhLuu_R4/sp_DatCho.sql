if exists (select * from dbo.sysobjects where name = 'sp_DatCho')
begin
	drop proc sp_DatCho
end
go
create proc sp_DatCho
	@maChuyenXe nvarchar(40),
	@maGhe nvarchar(40),
	@result int output
as
begin 
if exists(select * from SoGhe where TenGhe = @maGhe)
		begin
			update SoGhe
			set TinhTrang = 'Đặt Rồi' 
			Where TenGhe = @maGhe
			set @result = 1
		end
	else
		begin
			set @result = 0
		end
end


