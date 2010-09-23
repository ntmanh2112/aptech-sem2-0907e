if exists (select * from dbo.sysobjects where name = 'sp_GetAllChuyenXe')
begin
	drop proc sp_GetAllChuyenXe
end
go
create proc sp_GetAllChuyenXe
	
as
begin 
	select * from ChuyenXe
end


