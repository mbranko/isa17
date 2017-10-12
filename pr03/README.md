# Primer prenosa programskog koda putem RMI

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

`gradle alljars`

## Pokretanje primera

`rmiregistry -J-Djava.rmi.server.codebase=file://full-path-to-Server.jar`

`java -Djava.security.policy=src/main/resources/server.policy -Djava.rmi.server.hostname=localhost -jar build/libs/Server.jar`

`java -Djava.security.policy=src/main/resources/client.policy -jar build/libs/Client.jar`

## Sadržaj primera

Primer prenošenja programskog koda preko RMI. Serverska metoda kao parametar
ima interfejs, a klijentski program prilikom poziva metode prosleđuje instancu
podtipa (klase koja implementira interfejs, i koja nije poznata serveru).

Za RMI dynamic code downloading potrebno je uključiti `RMISecurityManager` i na
klijentu i na serveru. Ovaj security manager ne podrazumeva pravo aplikacije da
uspostavlja konekcije i čita fajlove iz fajl-sistema pa se ta prava moraju
eksplicitno dodeliti programima kroz "security policy" fajlove. Prilikom poziva
servera i klijenta definiše se i security policy fajl.

| fajl | namena |
| ---- | ------ |
| `Compute.java`       | definicija RMI interfejsa                                  |
| `ComputeServer.java` | implementacija RMI interfejsa                              |
| `Task.java`          | interfejs koji predstavlja parametar metode RMI interfejsa |
| `Pi.java`            | implementacija Task interfejsa                             |
| `ComputeClient.java` | klijentski program                                         |
| `server.policy`      | security policy fajl za serverski program                  |
| `client.policy`      | security policy fajl za klijentski program                 |

U sastav serverskog programa ulaze:

* `pr02.Compute`
* `pr03.Task`
* `pr03.ComputeServer`

U sastav klijentskog programa ulaze:

* `pr03.Compute`
* `pr03.Task`
* `pr03.ComputeClient`
* `pr03.Pi`

