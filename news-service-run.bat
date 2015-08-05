MKDIR d:\opt\
cd d:\opt\
git clone -b dev git@github.com:BatiushkovNikita/JD2NewsService.git

mysql.exe -u root -p < D:\opt\JD2NewsService\news-service-script\src\schema.sql

cd /d d:\opt\JD2NewsService\
call mvn clean install

cd news.service-dao\target\
call java -jar news-service-dao-0.0.1-SNAPSHOT.jar