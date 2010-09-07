if exists (select * from dbo.sysobjects where name = 'sp_checklogin')
begin
	drop proc sp_checklogin
end
go
create proc sp_checklogin
	@username varchar(50),
	@password varchar(50),
	@result int output
as
begin 
	if exists(select * from users where username = @username and password = @password)
		begin
			set @result = 1
		end
	else
		begin
			set @result = 0
		end
end
	