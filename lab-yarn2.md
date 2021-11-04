# Rapport - TP YARN N°2

## 1.6 Send the JAR to the edge node
### 1.6.3 Run the job
After sending the newly created jar files to the edge, we execute the following command to see if it's working well : 

```
[flavien.lallemand@hadoop-edge01 ~]$ yarn jar yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \wordcount davinci.txt wordcountPerso
```

All ran good, we obtain the following output :

```
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=277697
	File Output Format Counters 
		Bytes Written=113653
```

## 1.8 Remarkable trees of Paris
### 1.8.1 Districts containing trees (very easy)

Après avoir uploadé le fichier trees.csv sur le edge ainsi que le package nouvellement crée *-with-dependencies.jar, nous éxécutons la commande suivante permettant de lancer le job Map Reduce sur le fichier trees.csv nous donnant le nombre d'arbre par arrondissement : 

```
[flavien.lallemand@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \districtsTreesContaining trees.csv exo1TreesContainingTest4
```


### Exercices suivants : 
Reprendre le fonctionnement du job, mapper et reducer du premier exercice avec les treesDistrictsContaining
