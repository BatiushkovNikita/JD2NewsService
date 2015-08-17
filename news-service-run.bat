MKDIR d:\opt\
cd d:\opt\

git clone -b dev git@github.com:BatiushkovNikita/JD2NewsService.git

mysql.exe -u root -p < D:\opt\JD2NewsService\news-service-script\src\schema.sql
mysql.exe -u root -p < D:\opt\JD2NewsService\news-service-script\src\data.sql

cd %CATALINA_HOME%/bin/
call startup.bat

cd /d d:\opt\JD2NewsService\
call mvn clean tomcat7:redeploy