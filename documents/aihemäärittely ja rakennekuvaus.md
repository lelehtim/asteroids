Aihe: asteroids peli. Alus liikkuu nuolinäppäimillä ja ampuu välilyönnistä. Tavoitteena tuhota mahdollisimman monta asteroidia ennen pelin päättymistä. Asteroidien määrä lisääntyy pelin edetessä. Peli päättyy kun alukseen osuu asteroidi.

Käyttäjät: Pelaaja.

Käyttäjän toiminnot: Käyttäjä aloittaa pelin.

Rakennekuvaus:

Luokka Element on abstrakti luokka ja kaikki pelissä näkyvät ilmentymät perivät luokan Element. Luokka määrittelee metodit draw ja takeCareOfImpact. Näiden metodien toteutus tapahtuu Element luokan perivissä luokissa. Element luokka toteuttaa itsessään myös muutamia metodeita. Element luokan perivät luokat Ship, Asteroid ja Bullet. Näistä luodaan pelissä tarvittavat ilmentymät.

Luokka Vector määrittelee vektorin, jota käytetään merkitsemään elementtien paikkaa ja nopeutta pelissä.

Luokka Game perii luokan JFrame ja on vastuussa itse pelin pyörittämisestä sekä pelin elementtien luomisesta. Game alustaa kaiken valmiiksi pelin pyörimistä varten. Luokassa Game luodaan luokan Visible ilmentymä, joka hoitaa kaikkien elementtien piirtämisen näytölle. Luokka game luo myös luokan Timer ilmentymän, joka on vastuussa ajan mittaamisesta pelissä. Timeria käytetään mittaamaan kuinka nopeasti peliä pyörittävä loop pyörii ja tätä tietoa hyödyntämällä voidaan päivittää peliä useita kertoja yhden loopin aikana jos peli meinaa jäädä jälkee. Luokassa Game luodaan vielä Listener luokan ilmentymä, joka kuuntelee käyttäjän antamia komentoja.