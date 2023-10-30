package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `car moves if random value is 4 or more`() {
        val car = Car("hong")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
        car.move(5)
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    fun `car stays if random value is less than 4`() {
        val car = Car("hong")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `display position`() {
        val car = Car("hong", 3)
        assertThat(car.displayPosition()).isEqualTo("hong : ---")
    }

    @Test
    fun `get winners after race`() {
        val cars = Cars(listOf(Car("hong", 3), Car("lee", 3), Car("kim", 2)))
        val winners = cars.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("hong", "lee")
    }

    @Test
    fun `car name cannot exceed 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
        assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters")
    }
}
