#!/usr/bin/sh

################################################################################
#####                                                                      #####
#####                       Entrée du programme                            #####
#####                                                                      #####
################################################################################

clear
DDATE=`date "+%d-%m-%Y %H:%M:%S"`
echo "*****************************************************"
echo " Begin of $0 at $DDATE"
echo "*****************************************************"
echo "  "

FDATE=`date "+%d%m%Y_%H%M%S"`

dir=../build/classes/:/home/jlc/Documents/ESITemp/OCSF/ChatFX/MessageChat/dist/MessageChat.jar

java -cp ${dir} view.console.ChatServerConsole


################################################################################
#####                                                                      #####
#####                       Fin du programme                               #####
#####                                                                      #####
################################################################################

echo""
echo " $0 has been performed sucessfully."
echo "              "
eDATE=`date "+%d-%m-%Y %H:%M:%S"`
echo "*****************************************************"
echo " end of $0 at $eDATE"

exit 0
