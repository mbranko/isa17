# EJB: bean1 zove bean2 uz ručno uspostavljanje veza

Jedan session bean može biti klijent za drugi session bean, u okviru iste ili
različite VM. Ovaj primer ilustruje situaciju kada su oba beana u istoj VM i
mogu da komuniciraju putem lokalnog interfejsa. Klijentski program se pokreće
u posebnoj VM.

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
klijentski program koji će pronaći i pozvati `PurchaseBean`.

`PurchaseBean` će interno pozivati `PaymentBean` za šta mu je potrebna
referenca na njega. Referencu će dobaviti na isti način kao i klijent,
pomoću pristupa registru po imenu.