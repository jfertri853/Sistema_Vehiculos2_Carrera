fun main() {
    val moto = Motorcycle("Hyundai", "Kiko",
        100.0f, 100.0f,
        0.0f, 125)


    println(moto.calculateTotalRange())
    println(moto.calculateSpentFuel(20.0f))

}