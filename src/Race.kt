class Race(
    val name: String,
    val totalDistance: Float,
    val totalContestants: Int
) {

    var contestants = listOf<Vehicle>()
    var status: Boolean = false
    var record = mutableMapOf<String, MutableList<String>>()
    var positions = mutableListOf<Pair<String, Int>>()

    companion object {
        const val SECTION_DISTANCE = 20.0f  // Tamaño en Km de cada tramo de la carrera
    }


    /** Total de tramos en los que se divide la carrera
     */
    val sections = totalDistance.toInt() / SECTION_DISTANCE.toInt()


    /** Distancia del último tramo de la carrera
     */
    val distanceLeftovers = totalDistance - (sections.toFloat() * SECTION_DISTANCE)



    /** Anuncia que la carrera ha comenzado
     */
    fun announceStart() {
        println("La carrera $name ha comenzado!")
    }


    fun initializeRace() {
        announceStart()
        status = true
    }


    fun vehicleAdvance() {
        val vehicle = contestants.random()


    }


}