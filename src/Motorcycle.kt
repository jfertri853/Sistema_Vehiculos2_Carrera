class Motorcycle(
    brand: String,
    model: String,
    fuelCapacity: Float,
    currentFuel: Float,
    currentKilometers: Float,
    private val cubicCapacity: Int,
): Vehicle(brand, model, fuelCapacity, currentFuel, currentKilometers) {

    init {
        verifyCubicCapacity(cubicCapacity)
    }


    companion object {
        const val MINIMUM_CC = 125
        const val MAXIMUM_CC = 1000
    }


    /** Calcula la autonomía total de la motocicleta según su cilindrada
     *
     * @return kilómetros de autonomía totales de esta motocicleta
     */
    override fun calculateTotalRange(): Float {
        return (fuelCapacity * (KM_PER_LITER * 2)) - (1 - (cubicCapacity.toFloat() / 1000.0f))
    }


    /** Calcula la autonomía actual de la motocicleta según su cilindrada
     *
     * @return kilómetros de autonomía actuales de esta motocicleta
     */
    override fun calculateCurrentRange(): Float {
        return (currentFuel * (KM_PER_LITER * 2)) - (1 - (cubicCapacity.toFloat() / 1000.0f))
    }


    /** Calcula el combustible que gasta esta motocicleta en recorrer una distancia según su cilindrada
     *
     * @param distance distancia recorrida en kilómetros
     *
     * @return litros de combustible gastados
     */
    override fun calculateSpentFuel(distance: Float): Float {
        val kmPerLiter = (KM_PER_LITER * 2) - (1 - (cubicCapacity.toFloat() / 1000.0f))
        return distance / (kmPerLiter)
    }


    /** Asegura que la cilindrada no pueda tener valores inválidos.
     *
     * @param cubicCapacity cilindrada de la moto
     */
    private fun verifyCubicCapacity(cubicCapacity: Int) {
        require(this.cubicCapacity in MINIMUM_CC..MAXIMUM_CC) {
            "La cilindrada debe estar entre $MINIMUM_CC y $MAXIMUM_CC"
        }

    }


    /** Simula un caballito y gasta el equivalente en combustible a haber viajado 6.5Km
     *
     * @return combustible restante tras el caballito
     */
    fun doWheelie(): Float {
        makeARoute(6.5f)
        return currentFuel
    }

}