package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.assertj.core.api.Java6Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `race runs for given rounds`() {
        val random = 5
        val race = Race(listOf("hong", "lee", "kim"), 5) { random }
        race.run {}
        assertThat(race.cars.list.all { it.position == 5 }).isTrue
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertThatThrownBy {
            Race(listOf("hong", "lee", "kim"), -5)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Number of rounds must be positive")
    }
}
