rootdir=`pwd`
jarname=demo
rm -rf $rootdir/logs/*
rm -rf $rootdir/logPath_IS_UNDEFINED
rm -rf /data/logs/$jarname
java -jar target/$jarname.jar

