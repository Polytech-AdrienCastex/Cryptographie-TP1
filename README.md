# Cryptographie-TP1

1. Lister tous les élements x appartenant à Zn, pour lesquels il existe y appartenant à Zn tel que y² = x mod n pour n = 48 et n = 53. Que constate-t-on?


2. Compter le nombre d'éléments inversibles dans Z48 et Z53.
3. Implémenter un test de primalité naif.
4. Comparer (en termes de temps de calcul) le test précédent au test de Fermat. Conclusion?
5. Générer 2 entiers p et q de 512 bits.
6. Calculer n=pq et phin=(p-1)(q-1)
7. Générer un nombre premier e de 16 bits qui soit premier avec phin.
8. Calculer l'inverse modulaire d de e modulo phin. Quelle relation vérifient e et d? La vérifier.
9. Pour plusieurs éléments x appartenant à Zn, calculer X=x^e mod n et X^d mod n. Que conste-t-on?
10. Déduire de ce qui précède un cryptosystème à clé publique. On explicitera précisément les fonctions KeyGen, Encrypt et Decrypt. Quelle est la complexité de ces fonctions?
11. Dire sur quoi pourrait reposer la sécurité de ce cryptosystème?

12. On imagine le protocole suivant : Alice génère un couple de clés privée/publique et publie la clé publique avec le cryptosystème précéde,t. Alice pose des questions binaires (réponse par oui ou non) à Bob qui lui répond en envoyant une encryption de 1 si la réponse est oui et de 2 sinon. Dire en quoi ce protocole n'est pas sure. Proposer une amélioration (en terme de sécurité) de ce protocole.

Ceci n'est pas sur car le message crypté du 1 et du 2 sont toujours les mêmes, ce qui signifie qu'il est facile de décrypter sémentiquement les messages. Il suffit de rajouter un message créé aléatoirement à la fin du message avant de le crypter et de le retirer après la décryption.
