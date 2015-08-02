MKDIR d:\opt\
cd d:\opt\
git clone -b dev git@github.com:BatiushkovNikita/JD2NewsService.git

cd /d c:\Program Files\MySQL\MySQL Server 5.6\bin\
mysql.exe -u root -p < D:\opt\JD2NewsService\news-service-script\src\dump.sql

cd /d d:\opt\JD2NewsService\
mvn clean install