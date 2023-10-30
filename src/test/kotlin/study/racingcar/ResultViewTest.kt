package study.racingcar

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ResultViewTest {

    private val outputReceiver = mock<OutputReceiver>()

    @Test
    fun `display start title`() {
        val resultView = ResultView(outputReceiver)
        resultView.startDisplayResult()
        verify(outputReceiver).receive("실행 결과")
    }

    @Test
    fun `display cars positions`() {
        val resultView = ResultView(outputReceiver)
        val cars = Cars(listOf(Car("hong", 3), Car("lee", 1), Car("kim", 2)))
        resultView.displayRound(cars)
        verify(outputReceiver).receive("hong : ---\nlee : -\nkim : --\n")
    }
}
