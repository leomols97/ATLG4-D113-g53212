@echo off
ECHO  ---------------------------------------------------------------------
ECHO    Debut  - %DATE% %TIME% %0
ECHO  ---------------------------------------------------------------------

set classpath="../build/classes;../../BasicMessage/build/classes"
set filename=esi.atl.client.EchoClient

java -cp %classpath% %filename%

ECHO  ---------------------------------------------------------------------
ECHO    Fin    - %DATE% %TIME% %0
ECHO  ---------------------------------------------------------------------

goto :eof