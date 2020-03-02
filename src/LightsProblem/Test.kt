package LightsProblem

import org.junit.Test
import kotlin.test.assertEquals

// TODO CAREFUL DO NOT TOUCH THE TEST AT ANY POINTS !!!
class Test {
    @Test
    fun test1() {
        val speedLimit = 50
        val lights = listOf(
            Light(200, 15)
        )
        val answer = 50
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test2() {
        val speedLimit = 50
        val lights = listOf(
            Light(200, 10)
        )
        val answer = 36
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test3() {
        val speedLimit = 90
        val lights = listOf(
            Light(300, 30),
            Light(1500, 30),
            Light(3000, 30)
        )
        val answer = 90
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test4() {
        val speedLimit = 90
        val lights = listOf(
            Light(300, 10),
            Light(1500, 10),
            Light(3000, 10)
        )
        val answer = 54
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test5() {
        val speedLimit = 90
        val lights = listOf(
            Light(300, 30),
            Light(1500, 20),
            Light(3000, 10)
        )
        val answer = 67
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test6() {
        val speedLimit = 80
        val lights = listOf(
            Light(700, 25),
            Light(2200, 15),
            Light(3000, 10),
            Light(4000, 28)
        )
        val answer = 49
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test7() {
        val speedLimit = 200
        val lights = listOf(
            Light(1000, 15),
            Light(3000, 10),
            Light(4000, 30),
            Light(5000, 30),
            Light(6000, 5),
            Light(7000, 10)
        )
        val answer = 60
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test8() {
        val speedLimit = 130
        val lights = listOf(
            Light(500, 15),
            Light(1000, 15),
            Light(1500, 15),
            Light(2000, 15),
            Light(2500, 15),
            Light(3000, 15),
            Light(3500, 15),
            Light(4000, 15),
            Light(4500, 15),
            Light(5000, 15),
            Light(5500, 15),
            Light(6000, 15),
            Light(6500, 15),
            Light(7000, 15),
            Light(7500, 15),
            Light(8000, 15),
            Light(8500, 15),
            Light(9000, 15),
            Light(9500, 15),
            Light(10000, 15),
            Light(10500, 15),
            Light(11000, 15),
            Light(11500, 15),
            Light(12000, 15),
            Light(12500, 15),
            Light(13000, 15),
            Light(13500, 15),
            Light(14000, 15),
            Light(14500, 15),
            Light(15000, 15),
            Light(15500, 15),
            Light(16000, 15),
            Light(16500, 15),
            Light(17000, 15),
            Light(17500, 15),
            Light(18000, 15),
            Light(18500, 15),
            Light(19000, 15),
            Light(19500, 15),
            Light(20000, 15),
            Light(20500, 15),
            Light(21000, 15),
            Light(21500, 15),
            Light(22000, 15),
            Light(22500, 15),
            Light(23000, 15),
            Light(23500, 15),
            Light(24000, 15),
            Light(24500, 15),
            Light(25000, 15),
            Light(25500, 15),
            Light(26000, 15),
            Light(26500, 15),
            Light(27000, 15),
            Light(27500, 15),
            Light(28000, 15),
            Light(28500, 15),
            Light(29000, 15),
            Light(29500, 15),
            Light(30000, 15),
            Light(30500, 15),
            Light(31000, 15),
            Light(31500, 15),
            Light(32000, 15),
            Light(32500, 15),
            Light(33000, 15),
            Light(33500, 15),
            Light(34000, 15),
            Light(34500, 15),
            Light(35000, 15),
            Light(35500, 15),
            Light(36000, 15),
            Light(36500, 15),
            Light(37000, 15),
            Light(37500, 15),
            Light(38000, 15),
            Light(38500, 15),
            Light(39000, 15),
            Light(39500, 15),
            Light(40000, 15),
            Light(40500, 15),
            Light(41000, 15),
            Light(41500, 15),
            Light(42000, 15),
            Light(42500, 15),
            Light(43000, 15),
            Light(43500, 15),
            Light(44000, 15),
            Light(44500, 15),
            Light(45000, 15),
            Light(45500, 15),
            Light(46000, 15),
            Light(46500, 15),
            Light(47000, 15),
            Light(47500, 15),
            Light(48000, 15),
            Light(48500, 15),
            Light(49000, 15),
            Light(49500, 15),
            Light(50000, 15)
        )
        val answer = 60
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test9() {
        val speedLimit = 130
        val lights = listOf(
            Light(1100, 10),
            Light(1150, 15),
            Light(1200, 20),
            Light(1250, 25),
            Light(1300, 30),
            Light(2100, 10),
            Light(2150, 15),
            Light(2200, 20),
            Light(2250, 25),
            Light(2300, 30),
            Light(3100, 10),
            Light(3150, 15),
            Light(3200, 20),
            Light(3250, 25),
            Light(3300, 30),
            Light(4100, 10),
            Light(4150, 15),
            Light(4200, 20),
            Light(4250, 25),
            Light(4300, 30),
            Light(5100, 10),
            Light(5150, 15),
            Light(5200, 20),
            Light(5250, 25),
            Light(5300, 30),
            Light(6100, 10),
            Light(6150, 15),
            Light(6200, 20),
            Light(6250, 25),
            Light(6300, 30),
            Light(7100, 10),
            Light(7150, 15),
            Light(7200, 20),
            Light(7250, 25),
            Light(7300, 30),
            Light(8100, 10),
            Light(8150, 15),
            Light(8200, 20),
            Light(8250, 25),
            Light(8300, 30),
            Light(9100, 10),
            Light(9150, 15),
            Light(9200, 20),
            Light(9250, 25),
            Light(9300, 30),
            Light(10100, 10),
            Light(10150, 15),
            Light(10200, 20),
            Light(10250, 25),
            Light(10300, 30),
            Light(11100, 10),
            Light(11150, 15),
            Light(11200, 20),
            Light(11250, 25),
            Light(11300, 30),
            Light(12100, 10),
            Light(12150, 15),
            Light(12200, 20),
            Light(12250, 25),
            Light(12300, 30),
            Light(13100, 10),
            Light(13150, 15),
            Light(13200, 20),
            Light(13250, 25),
            Light(13300, 30),
            Light(14100, 10),
            Light(14150, 15),
            Light(14200, 20),
            Light(14250, 25),
            Light(14300, 30),
            Light(15100, 10),
            Light(15150, 15),
            Light(15200, 20),
            Light(15250, 25),
            Light(15300, 30),
            Light(16100, 10),
            Light(16150, 15),
            Light(16200, 20),
            Light(16250, 25),
            Light(16300, 30),
            Light(17100, 10),
            Light(17150, 15),
            Light(17200, 20),
            Light(17250, 25),
            Light(17300, 30),
            Light(18100, 10),
            Light(18150, 15),
            Light(18200, 20),
            Light(18250, 25),
            Light(18300, 30),
            Light(19100, 10),
            Light(19150, 15),
            Light(19200, 20),
            Light(19250, 25),
            Light(19300, 30),
            Light(20100, 10),
            Light(20150, 15),
            Light(20200, 20),
            Light(20250, 25),
            Light(20300, 30)
        )
        val answer = 6
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }

    @Test
    fun test10() {
        val speedLimit = 90
        val lights = listOf(
            Light(1234, 5),
            Light(2468, 5),
            Light(3702, 5),
            Light(6170, 5),
            Light(8638, 5),
            Light(13574, 5),
            Light(16042, 5),
            Light(20978, 5),
            Light(23446, 5),
            Light(28382, 5),
            Light(35786, 5),
            Light(38254, 5),
            Light(45658, 5),
            Light(50594, 5),
            Light(53062, 5),
            Light(57998, 5)
        )
        val answer = 74
        assertEquals(answer, Problem.solve(speedLimit, lights))
    }
}