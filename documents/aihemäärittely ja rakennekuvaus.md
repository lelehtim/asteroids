Aihe: asteroids peli. Alus liikkuu nuolin�pp�imill� ja ampuu v�lily�nnist�. Tavoitteena tuhota mahdollisimman monta asteroidia ennen pelin p��ttymist�. Asteroidien m��r� lis��ntyy pelin edetess�. Peli p��ttyy kun alukseen osuu asteroidi.

K�ytt�j�t: Pelaaja.

K�ytt�j�n toiminnot: K�ytt�j� aloittaa pelin.

Rakennekuvaus:

Luokka Element on abstrakti luokka ja kaikki peliss� n�kyv�t ilmentym�t periv�t luokan Element. Luokka m��rittelee metodit draw ja takeCareOfImpact. N�iden metodien toteutus tapahtuu Element luokan periviss� luokissa. Element luokka toteuttaa itsess��n my�s muutamia metodeita. Element luokan periv�t luokat Ship, Asteroid ja Bullet. N�ist� luodaan peliss� tarvittavat ilmentym�t.

Luokka Vector m��rittelee vektorin, jota k�ytet��n merkitsem��n elementtien paikkaa ja nopeutta peliss�.

Luokka Game perii luokan JFrame ja on vastuussa itse pelin py�ritt�misest� sek� pelin elementtien luomisesta. Game alustaa kaiken valmiiksi pelin py�rimist� varten. Luokassa Game luodaan luokan Visible ilmentym�, joka hoitaa kaikkien elementtien piirt�misen n�yt�lle. Luokka game luo my�s luokan Timer ilmentym�n, joka on vastuussa ajan mittaamisesta peliss�. Timeria k�ytet��n mittaamaan kuinka nopeasti peli� py�ritt�v� loop py�rii ja t�t� tietoa hy�dynt�m�ll� voidaan p�ivitt�� peli� useita kertoja yhden loopin aikana jos peli meinaa j��d� j�lkee. Luokassa Game luodaan viel� Listener luokan ilmentym�, joka kuuntelee k�ytt�j�n antamia komentoja.