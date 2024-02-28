class Automobile(
    brand: String,
    model: String,
    fuelCapacity: Float,
    currentFuel: Float,
    currentKilometers: Float,
    private val isHybrid: Boolean,
    private var britishCondition: Boolean
): Vehicle(brand, model, fuelCapacity, currentFuel, currentKilometers) {

    /** Calcula la autonomía total del automóvil teniendo en cuenta si es híbrido o no
     *
     * @return kilómetros de autonomía totales de este automóvil
     */
    override fun calculateTotalRange(): Float {
        return if (isHybrid) {
            fuelCapacity * (KM_PER_LITER + 5.0f)
        } else {
            super.calculateTotalRange()
        }

    }


    /** Calcula la autonomía actual del automóvil teniendo en cuenta si es híbrido o no
     *
     * @return kilómetors de autonomía restante de este automóvil
     */
    override fun calculateCurrentRange(): Float {
        return if (isHybrid) {
            currentFuel * (KM_PER_LITER + 5.0f)
        } else {
            super.calculateCurrentRange()
        }

    }


    /** Calcula el combustible que gasta este automóvil en recorrer una distancia teniendo en cuenta si es híbrido o no
     *
     * @param distance distancia recorrida en kilómetros
     *
     * @return litros de combustible gastados
     */
    override fun calculateSpentFuel(distance: Float): Float {
        return if (isHybrid) {
            distance / (KM_PER_LITER + 5.0f)
        } else {
            super.calculateSpentFuel(distance)
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