if exists (select * from dbo.sysobjects where name = 'sp_DeleteChuyenXe')
begin
	drop proc sp_DeleteChuyenXe
end
go
create proc sp_DeleteChuyenXe
	@maChuyenXe nvarchar(40),
	@result int output
as
begin 
if exists(select * from ChuyenXe where TenChuyenXe = @maChuyenXe)
		begin
			Delete 
			From SoGhe 
			Where MaChuyenXe = @maChuyenXe

			Delete 
			From ChuyenXe 
			Where TenChuyenXe = @maChuyenXe
			
			Set @result = 1
		end
	else if(@maChuyenXe = 'All')
		begin
			Delete 
			From SoGhe 
			Delete 
			From ChuyenXe 
			Set @result = 1
		end
	else
		begin
			Set @result = 0
		end
end


