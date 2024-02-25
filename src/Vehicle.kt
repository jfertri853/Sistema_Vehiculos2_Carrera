abstract class Vehicle(
    val brand: String,
    val model: String,
    val fuelCapacity: Float,
    var currentFuel: Float,
    var currentKilometers: Float,
) {

    open val performance = calculatePerformance() // Este atributo me ahorra muchísimo código


    /** Calcula la cantidad de kilómetros por litro de combustible que es capaz de recorrer el vehículo
     *
     * @return cantidad de kilómetros por litro de combustible
     */
    open fun calculatePerformance(): Float {
        return 10.0f
    }


    /** Calcula la autonomía total del vehículo en kilómetros
     *
     * @return kilómetros de autonomía totales de este vehículo
     */
    open fun calculateTotalRange(): Float {
        return (fuelCapacity * performance)
    }


    /** Calcula la autonomía actual del vehículo en kilómetros
     *
     * @return kilómetors de autonomía restante de este vehículo
     */
    open fun calculateCurrentRange(): Float {
        return (currentFuel * performance)
    }


    /** Devuelve los kiómetros de autonomía restantes
     *
     * @return cadena de los kilómetros de autonomía restantes
     */
    fun obtainInfo(): String {
        return "${calculateCurrentRange()} km"
    }


    /** Realiza un recorrido completo o, en caso de que no tenga el combustible suficiente, parcial.
     * Se actualiza el nivel de combustible, se actualiza la cantidad total de kilómetros recorridos y
     * devuelve la distancia restante para terminar el recorrido.
     *
     * @param distance Distancia total del recorrido
     *
     * @return Distancia que ha quedado por recorrer
     */
    fun makeARoute(distance: Float): Float {
        val currentRange = calculateCurrentRange()

        val traveledDistance: Float
        val remainingDistance: Float
        if (distance > currentRange) {
            traveledDistance = currentRange
            remainingDistance = currentRange - distance
        } else {
            traveledDistance = distance
            remainingDistance = 0.0f
        }

        currentKilometers += traveledDistance

        val spentFuel = traveledDistance / performance
        currentFuel -= spentFuel

        return remainingDistance
    }


    /** Rellena una cantidad del depósito de combustible
     *
     * @param amount cantidad a rellenar
     *
     * @return cantidad de combustible rellenado
     */
    fun refuel(amount: Float): Float {
        val currentAmountPlusRefuelAmount = amount + currentFuel
        val totalRefueled: Float

        if (currentAmountPlusRefuelAmount > fuelCapacity) {
            totalRefueled = fuelCapacity - currentFuel
            currentFuel = fuelCapacity
        } else {
            totalRefueled = currentAmountPlusRefuelAmount
            currentFuel += currentAmountPlusRefuelAmount
        }

        return totalRefueled
    }


}