rmdir /s /q %CATALINA_HOME%\webapps\news-service-web
del /s /q %CATALINA_HOME%\webapps\news-service-web.war

cd %CATALINA_HOME%/bin/
call startup.bat

cd /d d:\Projects\JD2NewsService\

call mvn clean tomcat7:redeploy -DskipTests -T 4