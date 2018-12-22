cd bin

start rmiregistry -J-Djava.rmi.server.hostname=localhost:1099

start java -classpath ".;sqlite-jdbc.jar.;tone-analyzer.jar" main.Main