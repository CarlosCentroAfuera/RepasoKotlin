


var l1 = mutableListOf("Carlos", "Sergio", "Javier", "Ignacio","Manuel", "Stefanel", "Néstor")

class Humano(var nombre: String, var edad: Int)
var l2 = mutableListOf(Humano("Carlos", 33), Humano("Sergio", 20), Humano("Javier", 21), Humano("Ignacio", 22),Humano("Manuel", 23), Humano("Stefanel", 24), Humano("Néstor", 25))

class HumanoComparable(var nombre: String, var edad: Int) : Comparable<HumanoComparable> {
    override fun compareTo(other: HumanoComparable): Int {
        return edad - other.edad
    }

    override fun toString(): String {
        return "$nombre de $edad años"
    }
}

var l3 = mutableListOf(HumanoComparable("Carlos", 33), HumanoComparable("Sergio", 20), HumanoComparable("Javier", 21), HumanoComparable("Ignacio", 22),HumanoComparable("Manuel", 23), HumanoComparable("Stefanel", 24), HumanoComparable("Néstor", 25))

var vocales = listOf("a", "e", "i", "o", "u")
fun main() {

    println("Lista original = $l1")

    // Filtrado
    val r1 = l1.filter { true }
    println(r1)

    val r2 = l1.filter {
        it.startsWith("C")
    }
    println(r2)

    // Ej1: Busca a todas las personas que no se llaman Sergio pero que tienen una "s" en su nombre.
    println("Ej1: ${l1.filter { it.toLowerCase().contains("s") && !it.contentEquals("Sergio")}}")

    // Ej2: Busca a todas las personas cuyo nombre tiene un número de letras par.
    println("Ej2: ${l1.filter { it.length % 2 == 0}}")

    // Ej3: Busca a todas las personas cuyo nombre tiene un número de letras superior a 6 y que su nombre empieza por vocal.
    println("Ej3: ${l1.filter { nombre ->
        var empiezaPorVocal = false
        vocales.forEach { vocal ->
            if (nombre.startsWith(vocal, true)) empiezaPorVocal = true
        }
        // Sería una alternativa a lo anterior: vocales.contains(nombre[0].toLowerCase())
        nombre.length > 6 && empiezaPorVocal}}")
    // Ej4: Busca a todas las personas cuyo nombre tiene más de 3 vocales distintas.
    println("Ej4: ${l1.filter { contarVocales(it) >= 3 }}")


    // Ordenación.
    // Sort: Atentos a que aquí no devuelve otra lista sino que ordena la original.
    // Lista ordenada Alfabéticamente
    l1.sort()
    println(l1)

    // Sorted: Atento que este si devuelve otra lista.
    // Lista ordenada Alfabéticamente
    val o1 = l1.sorted()
    println(o1)

    // SortBy
    // Lista ordenada por lengitud del nombre
    l1.sortByDescending { it.length }
    println(l1)

    // Lista ordenada por número de vocales
    l1.sortBy { contarVocales(it) }
    println(l1)


    // Fíjate que sobre l2 NO deja hacer un sort. Eso es debido a que Humano no es una clase "Comparable"
    // l2.sort()

    // Fíjate que sobre l3 SI deja hacer un sort.
    println("Lista original = $l3")

    l3.sort()
    println(l3)
}

fun contarVocales(s: String):Int {
    var out = 0
    s.toLowerCase().forEach {
        if (vocales.contains(it.toString())) out++
    }
    return out
}


