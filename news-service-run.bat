MKDIR d:\opt\
cd d:\opt\
git clone -b dev git@github.com:BatiushkovNikita/JD2NewsService.git

mysql.exe -u root -p < D:\opt\JD2NewsService\news-service-script\src\dump.sql

cd /d d:\opt\JD2NewsService\
mvn clean install