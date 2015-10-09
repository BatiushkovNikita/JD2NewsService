cd %CATALINA_HOME%/bin/
call shutdown.bat

sleep 2

rmdir /s /q %CATALINA_HOME%\webapps\news-service-web
del /s /q %CATALINA_HOME%\webapps\news-service-web.war
del /s /q %CATALINA_HOME%\webapps\ROOT\*.*
del /s /q %CATALINA_HOME%\logs\*.*

cd %CATALINA_HOME%/bin/
call startup.bat

cd /d d:\Projects\JD2NewsService\news-service-web\src\main\resources\

native2ascii -encoding Cp1251 content_ru.properties content_ru.properties

cd /d d:\Projects\JD2NewsService\

call mvn -T 2 clean install -DskipTests 
call mvn -T 2 clean tomcat7:redeploy -DskipTests