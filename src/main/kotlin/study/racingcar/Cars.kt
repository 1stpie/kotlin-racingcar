package study.racingcar

data class Cars(private val cars: List<Car>) {

    private val _cars: List<Car> = cars.toList()

    val list: List<Car> get() = _cars.toList()

    fun moveAll(randomValueGenerator: () -> Int): Cars {
        return Cars(
            cars.map { car ->
                Car(car.name, car.position).apply { move(randomValueGenerator()) }
            }
        )
    }

    fun displayPositions(): List<String> {
        return cars.map { it.displayPosition() }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxByOrNull { it.position }?.position ?: 0
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
