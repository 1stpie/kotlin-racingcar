package study.racingcar

import study.racingcar.domain.Race
import study.racingcar.view.DefaultInputProvider
import study.racingcar.view.DefaultOutputReceiver
import study.racingcar.view.InputView
import study.racingcar.view.ResultView

fun main() {
    val inputView = InputView(DefaultInputProvider())
    val carNames = inputView.getCarNames()
    val numberOfRounds = inputView.getNumberOfRounds()

    val race = Race(carNames, numberOfRounds)
    val resultView = ResultView(DefaultOutputReceiver())

    resultView.startDisplayResult()
    race.run { cars ->
        resultView.displayRound(cars)
    }
    resultView.displayWinners(race.cars.getWinners())
}
