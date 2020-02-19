@echo off
ECHO  ---------------------------------------------------------------------
ECHO    Debut  - %DATE% %TIME% %0
ECHO  ---------------------------------------------------------------------

set classpath="../build/classes"
set filename=esi.atl.server.EchoServeurMulticlient

java -cp %classpath% %filename%

ECHO  ---------------------------------------------------------------------
ECHO    Fin    - %DATE% %TIME% %0
ECHO  ---------------------------------------------------------------------

goto :eof