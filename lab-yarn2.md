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

Nous obtenons le résultat suivant qui nous prouve que cela a bien fonctionné : 
```
[flavien.lallemand@hadoop-edge01 ~]$ hdfs dfs -cat exo1TreesContainingTest4/part-r-00000
11	1
12	29
13	2
14	3
15	1
16	36
17	1
18	1
19	6
20	3
3	1
4	1
5	2
6	1
7	3
8	5
9	1
```

Vous pouvez trouver le code du job, du map et du reducer respectivement dans les classes suivantes : DistrictContainingTrees, TreesMapper & TreesRoundingReducer

Hash du commit : 489f0989d01881fb6e1595dac5e3943066ed7edc


### 1.8.2 Show all existing species

Après avoir uploadé le fichier trees.csv sur le edge ainsi que le package nouvellement crée *-with-dependencies.jar, nous éxécutons la commande suivante permettant de lancer le job Map Reduce sur le fichier trees.csv nous donnant la liste des espèces des arbres : 

```
[flavien.lallemand@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \showSpecies trees.csv showSpecies1.8.2-t13
```

Nous obtenons le résultat suivant qui nous prouve que cela a bien fonctionné : 
```
[flavien.lallemand@hadoop-edge01 ~]$ hdfs dfs -cat showSpecies1.8.2-t13/part-r-00000
araucana	1
atlantica	2
australis	1
baccata	2
bignonioides	1
biloba	5
bungeana	1
cappadocicum	1
carpinifolia	4
colurna	3
coulteri	1
decurrens	1
dioicus	1
distichum	3
excelsior	1
fraxinifolia	2
giganteum	5
giraldii	1
glutinosa	1
grandiflora	1
hippocastanum	3
ilex	1
involucrata	1
japonicum	1
kaki	2
libanii	2
monspessulanum	1
nigra	3
nigra laricio	1
opalus	1
orientalis	8
papyrifera	1
petraea	2
pomifera	1
pseudoacacia	1
sempervirens	1
serrata	1
stenoptera	1
suber	1
sylvatica	8
tomentosa	2
tulipifera	2
ulmoides	1
virginiana	2
x acerifolia	11
```

Malgrès nos nombreux efforts pour essayer de renvoyer uniquement la liste des espèces et non la liste des espèces ainsi que le nombre d'arbres appartenant à cet espèce.

Vous pouvez trouver le code du job, du map et du reducer respectivement dans les classes suivantes : ShowSpecies, ShowSpeciesMapper & ShowSpeciesReducer

Hash du commit : 01a5c9120a9744f35142b46cbb51e190fc7ca96c


### 1.8.3 Number of trees by kinds (easy)

Après avoir uploadé le fichier trees.csv sur le edge ainsi que le package nouvellement crée *-with-dependencies.jar, nous éxécutons la commande suivante permettant de lancer le job Map Reduce sur le fichier trees.csv nous la liste des espèces dans le csv tree.csv nous donant la liste des types d'arbres ainsi que le nombres d'arbres de chaque type : 

```
[flavien.lallemand@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \kindNumber trees.csv kindNumber1.8.3-t1
```

Nous obtenons le résultat suivant qui nous prouve que cela a bien fonctionné : 
```
[flavien.lallemand@hadoop-edge01 ~]$ hdfs dfs -cat kindNumber1.8.3-t1/part-r-00000
Acer	3
Aesculus	3
Ailanthus	1
Alnus	1
Araucaria	1
Broussonetia	1
Calocedrus	1
Catalpa	1
Cedrus	4
Celtis	1
Corylus	3
Davidia	1
Diospyros	4
Eucommia	1
Fagus	8
Fraxinus	1
GENRE	1
Ginkgo	5
Gymnocladus	1
Juglans	1
Liriodendron	2
Maclura	1
Magnolia	1
Paulownia	1
Pinus	5
Platanus	19
Pterocarya	3
Quercus	4
Robinia	1
Sequoia	1
Sequoiadendron	5
Styphnolobium	1
Taxodium	3
Taxus	2
Tilia	1
Ulmus	1
Zelkova	4
```


Vous pouvez trouver le code du job, du map et du reducer respectivement dans les classes suivantes : KindNumber, KindNumberMapper & ShowSpeciesReducer

Hash du commit : 489f0989d01881fb6e1595dac5e3943066ed7edc


### 1.8.4 Maximum height per kind of tree (average)

Après avoir uploadé le fichier trees.csv sur le edge ainsi que le package nouvellement crée *-with-dependencies.jar, nous éxécutons la commande suivante permettant de lancer le job Map Reduce sur le fichier trees.csv nous la liste des espèces dans le csv tree.csv nous donant la liste des types d'arbres ainsi que l'arbre le plus haut par type d'arbre : 

```
[flavien.lallemand@hadoop-edge01 ~]$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \maxHeightKinds trees.csv maxHeightKinds1.8.4-t5
```

Nous obtenons le résultat suivant qui nous prouve que cela a bien fonctionné : 
```
[flavien.lallemand@hadoop-edge01 ~]$ hdfs dfs -cat maxHeightKinds1.8.4-t5/part-r-00000
araucana	9.0
atlantica	25.0
australis	16.0
baccata	13.0
bignonioides	15.0
biloba	33.0
bungeana	10.0
cappadocicum	16.0
carpinifolia	30.0
colurna	20.0
coulteri	14.0
decurrens	20.0
dioicus	10.0
distichum	35.0
excelsior	30.0
fraxinifolia	27.0
giganteum	35.0
giraldii	35.0
glutinosa	16.0
grandiflora	12.0
hippocastanum	30.0
ilex	15.0
involucrata	12.0
japonicum	10.0
kaki	14.0
libanii	30.0
monspessulanum	12.0
nigra	30.0
nigra laricio	30.0
opalus	15.0
orientalis	34.0
papyrifera	12.0
petraea	31.0
pomifera	13.0
pseudoacacia	11.0
sempervirens	30.0
serrata	18.0
stenoptera	30.0
suber	10.0
sylvatica	30.0
tomentosa	20.0
tulipifera	35.0
ulmoides	12.0
virginiana	14.0
x acerifolia	45.0
```


Vous pouvez trouver le code du job, du map et du reducer respectivement dans les classes suivantes : MaxHeightKinds, MaxHeightKindsMapper & MaxHeightKindsReducer

Hash du commit : 489f0989d01881fb6e1595dac5e3943066ed7edc

### Exercices suivants : 
Reprendre le fonctionnement du job, mapper et reducer du premier exercice avec les treesDistrictsContaining
