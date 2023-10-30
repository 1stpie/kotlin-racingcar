package study.racingcar

class ResultView(private val outputReceiver: OutputReceiver) {

    fun startDisplayResult() {
        outputReceiver.receive("실행 결과")
    }

    fun displayRound(cars: Cars) {
        val result = cars.displayPositions().joinToString("\n") + "\n"
        outputReceiver.receive(result)
    }

    fun displayWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(", ")
        outputReceiver.receive("$winnerNames 가 최종 우승했습니다.")
    }
}
