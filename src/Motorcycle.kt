class Motorcycle(
    brand: String,
    model: String,
    fuelCapacity: Float,
    currentFuel: Float,
    currentKilometers: Float,
    private val cubicCapacity: Int,
): Vehicle(brand, model, fuelCapacity, currentFuel, currentKilometers) {

    override val performance = calculatePerformance()


    init {
        verifyCubicCapacity(cubicCapacity)
    }


    companion object {
        const val MINIMUM_CC = 125
        const val MAXIMUM_CC = 1000
    }


    /** Calcula la cantidad de kilómetros por litro de combustible que es capaz de recorrer la moto teniendo
     * en cuenta su cilindrada
     *
     * @return cantidad de kilómetros por litro de combustible
     */
    override fun calculatePerformance(): Float {
        return 20.0f - (1 - (cubicCapacity.toFloat() / 1000.0f))

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