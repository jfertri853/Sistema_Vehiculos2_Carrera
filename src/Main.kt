fun main() {
    val moto = Motorcycle("Hyundai", "Kiko",
        100.0f, 100.0f,
        0.0f, 750)

    println(moto.performance)
    println(moto.calculateTotalRange())

}