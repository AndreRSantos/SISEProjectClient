@echo off
if not "%JAVA_HOME%" == "" goto USE_JAVA_HOME

set JAVA=java
goto LAUNCH

:USE_JAVA_HOME
set JAVA="%JAVA_HOME%\bin\java"
goto LAUNCH

:LAUNCH
%JAVA% -cp "..\libs\javax.activation.jar;..\libs\webservices-api.jar;..\libs\istack-commons-runtime.jar;..\libs\jaxb-runtime.jar;..\libs\jaxws-tools.jar;..\libs\jaxb-jxc.jar"  com.sun.tools.ws.WsImport -d ..\libs\  %*