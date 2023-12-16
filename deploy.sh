# git checkout Cognizant
git pull
mvn clean package install -Dmaven.test.skip=true -T 1C
pm2 restart demo
sleep 10
tail -f /data/logs/demo/*
