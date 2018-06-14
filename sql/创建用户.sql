
--创建myhr用户
create user myhr identified by myhr;
--授权权限
grant connect,resource,create view to myhr;