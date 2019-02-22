# RatingVideos
Rating Videos IT Academy Backend

Crear una Rest API amb Java Spring

Es vol crear una Rest API que ens permeti llistar els videos dels diferents itineraris de l’ITAcademy per a poder puntuar si als alumnes els hi han agradat o no.

Aquest Api ha de servir per a que es desenvolupi  una pàgina web o aplicació Android que donat un itinerari (que l’usuari selecciona), es mostri el llistat de videos (fent la crida GET de l’API Rest).

Després, quan l’usuari selecciona un dels vídeos, aquest ha de poder afegir la seva valoració numèrica entre 0 i 5, i un comentari. Quan l’usuari cliqui el botó de “Guardar”, aquestes dades s’enviaran al servidor mitjançant la crida POST de l’API Rest.

En cas de que l’usuari valori dos cops el mateix video, es sobreescriurà (en el servidor) la valoració. Per tant, desde frontend / Android NO us heu de preocupar de carregar la valoració anterior.

