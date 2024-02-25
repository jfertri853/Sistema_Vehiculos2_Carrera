class Automobile(
    brand: String,
    model: String,
    fuelCapacity: Float,
    currentFuel: Float,
    currentKilometers: Float,
    private val isHybrid: Boolean,
    private var britishCondition: Boolean
): Vehicle(brand, model, fuelCapacity, currentFuel, currentKilometers) {

    override val performance = calculatePerformance()


    /** Calcula la cantidad de kilómetros por litro de combustible que es capaz de recorrer el automóvil teniendo en
     * cuenta si es híbrido o no
     *
     * @return cantidad de kilómetros por litro de combustible
     */
    override fun calculatePerformance(): Float {
        return if (isHybrid) {
            15.0f
        } else {
            super.calculatePerformance()
        }

    }


    /** Cambia la conducción a británica o a no británica
     *
     * @param newCondition tipo de conducción
     */
    fun changeBritishCondition(newCondition: Boolean) {
        britishCondition = newCondition
    }


    /** Simula un derrape, gasta más o menos combustible según sea o no híbrido
     *
     * @return combustible restante tras el derrape
     */
    fun drift(): Float {
        if (isHybrid) {
            makeARoute(6.25f)
        } else {
            makeARoute(7.5f)
        }

        return currentFuel
    }



}