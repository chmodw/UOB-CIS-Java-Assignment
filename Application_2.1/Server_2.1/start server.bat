cd bin

start rmiregistry -J-Djava.rmi.server.hostname=192.168.1.2:1099

start java -classpath ".;sqlite-jdbc.jar.;tone-analyzer.jar" main.Main