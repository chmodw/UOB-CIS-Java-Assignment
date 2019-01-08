cd bin

start rmiregistry -J-Djava.rmi.server.hostname=192.168.8.102:1099
start java -classpath ".;sqlite-jdbc.jar.;tone-analyzer.jar.;gson.jar" main.Main