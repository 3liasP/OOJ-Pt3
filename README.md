# DTEK0066 harjoitustyöpohja

## Tehtävänanto

Tämän harj. työn [yleiset ohjeet](https://tech.utugit.fi/soft/tools/lectures/dtek0066/2022-fi1/harjoitukset/harjoitus3/index.html).

[Lue tehtävänanto klikkaamalla tästä!](tehtavananto.md)

## Työnkulku

```bash
1) Forkkaa alkup. tehtäväprojekti (GitLabin fork-nappi)

2) Kloonaa oma kopiosi projektista: 

$ git clone https://gitlab.utu.fi/OMATUNNUS/ooj2022-exercise3

tai

$ git clone ssh://git@gitlab.utu.fi/OMATUNNUS/ooj2022-exercise3

Sitten:

$ cd ooj2022-exercise3

3) Tee tehtävät

$ mvn compile
$ mvn javafx:run

4) Tallenna muutokset

$ git commit -am 'Add initial exercise implementation'
$ git push

4) korjaa/täydennä tehtäviä ja tallenna uudelleen

$ git commit -am 'Fix the task 3 implementation'
$ git push

5) Lopuksi zippaa projekti

$ git config --global alias.zip "archive --format=zip HEAD"
$ git zip > ooj2022-exercise3.zip

6) Palauta zip-tiedosto Moodlen palautuslokeroon
```

## GitLabin automaattinen projektikäännös

Voit tutkia myös GitLabista [tästä osoitteesta](../../../pages), miksi projektin
käännös mahdollisesti epäonnistuu. Huomaat ongelmatilanteen helposti, sillä GitLab
lähettää aina mailia, kun tunnukselle rekisteröity projekti ei käänny.
Harjoitustehtävien ehdoton tavoite on kääntyä palautusvaiheessa onnistuneesti!
Sähköpostiin tuleva virheilmoitus indikoi, että projektissa on vielä jäljellä
ratkaisemattomia ongelmia.
