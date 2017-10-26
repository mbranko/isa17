# EJB i lifecycle callbacks sa ukusom AOP-a

Primer rukovanja događajima životnog ciklusa EJB session beana na način sličan
aspektima.

## Potrebne stvari

* [Gradle](https://gradle.org)

## Priprema primera

Ako se koristi neko od razvojnih okruženja, projekat se može pripremiti za njih pomoću komande

`gradle eclipse`

ili 

`gradle idea`

Nakon toga se projekat može otvoriti u izabranom alatu i podešavanja za 
projekat će već biti inicijalizovana.

## Bildovanje primera

`gradle alljars`

## Pokretanje primera

`java -jar build/libs/Server.jar`

`java -jar build/libs/Client.jar`

## Sadržaj primera

Klasa `Server` inicijalizuje EJB kontejner koji će automatski prepoznati
sve EJB komponente u classpath-u i registrovati ih. Klasa `Client` je
klijentski program koji će pronaći i pozvati `CountBean`.

`CountBean` je klasa koja je rukovanje događajima svog životnog ciklusa
prepustila klasi `CountCallbacks`. Anotacija korišćena za aspekte, 
`Interceptors`, koristi se i ovde, ali ima drugačiji smisao - sada se za
klasu ne vezuju aspekti nego obrada događaja iz životnog ciklusa.

Metoda označena sa `@Remove` je ostala u klasi `CountBean` i u njenom 
interfejsu - ona je namenjena klijentu i nije deo obrade lifecycle događaja,
mada ih izaziva.