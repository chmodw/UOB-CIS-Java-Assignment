cd bin

start rmiregistry -J-Djava.rmi.server.hostname=192.168.1.1:1099

start java -classpath "".;sqlite-jdbc.jar"" main.Main