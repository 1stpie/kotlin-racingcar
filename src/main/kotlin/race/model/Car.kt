package race.model

data class Car(
    private val _name: String,
    private val engine: Engine = RandomEngine()
) {

    val name: String get() = _name

    private var _position: Int = START_POSITION
    val position: Int get() = _position

    private fun move() {
        _position += 1
    }

    private fun isMove() = engine.cycle() >= MOVING_NUMBER

    fun go() {
        if (isMove()) {
            move()
        }
    }

    companion object {
        const val START_POSITION = 0
        const val MOVING_NUMBER = 4
    }
}