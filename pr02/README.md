# Primer RMI klijent/server programa

Ovaj primer predstavlja primer klijent/server programa koji koristi Javinu RMI tehnologiju za komunikaciju.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za projekat će već biti inicijalizovana.

## Bildovanje primera

`gradle server`

`gradle client`

## Pokretanje primera

`rmiregistry -J-Djava.rmi.server.codebase=file://full-path-to-Server.jar`

`java -jar build/libs/Server.jar`

`java -jar build/libs/Client.jar`

## Sadržaj primera

Server klijentima nudi jednu metodu i broji ukupan broj poziva metode. U sastav serverskog programa 
ulaze:

* `pr02.ServerI`
* `pr02.Server`
* `pr02.ServerMain`

U sastav klijentskog programa ulaze:

* `pr02.Client`
* `pr02.ServerI`

