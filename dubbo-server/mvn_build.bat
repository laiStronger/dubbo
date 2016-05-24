cd /d %~dp0
call mvn clean install eclipse:eclipse -Dwtpversion=2.0 -DdownloadSources -Dmaven.test.skip=true
pause

