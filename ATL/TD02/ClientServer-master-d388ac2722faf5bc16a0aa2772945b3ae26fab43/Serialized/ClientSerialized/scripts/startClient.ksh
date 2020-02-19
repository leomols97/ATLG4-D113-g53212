#!/usr/bin/ksh

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

#echo "Attention au classpath - Penser a actualiser les jar"

dir="../"
messageDir="../../BasicMessage/build/classes"

classpath="${dir}build/classes:${messageDir}"

echo "classpath : " ${classpath}

fileName=esi.atl.client.EchoClient

java -cp "${classpath}" ${fileName}

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
