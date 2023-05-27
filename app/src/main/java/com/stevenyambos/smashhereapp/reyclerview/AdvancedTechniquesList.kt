package com.stevenyambos.smashhereapp.reyclerview

/*
En Kotlin, une "data class" est une classe spéciale qui est principalement utilisée
pour représenter des données. Elle est utilisée pour créer des classes qui contiennent
des propriétés et des méthodes pour accéder à ces propriétés, mais sans logique métier complexe.
Les "data classes" sont créées en utilisant le mot-clé "data" devant la déclaration de la classe.
En plus des méthodes générées automatiquement, les "data classes" peuvent également inclure
des méthodes et des propriétés supplémentaires. Cependant, il est généralement recommandé de
garder ces classes simples et de les utiliser principalement pour stocker des données.
 */

data class AdvancedTechniquesList(
    var ATsImage: Int,
    var ATsTitle : String
)
