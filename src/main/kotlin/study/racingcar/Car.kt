package study.racingcar

class Car(val name: String, position: Int = 0) {

    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
    }

    var position = position
        private set

    fun move(randomValue: Int) {
        if (randomValue >= 4) {
            position += 1
        }
    }

    fun displayPosition(): String = "$name : " + "-".repeat(position)
}
