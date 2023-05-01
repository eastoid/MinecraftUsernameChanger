import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.io.File
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.system.exitProcess
/*
button = 1059, 618
submit = 1119, 790



48 -- 0
49 -- 1
50 -- 2
51 -- 3
52 -- 4
53 -- 5
54 -- 6
55 -- 7
56 -- 8
57 -- 9

65 -- A
66 -- B
67 -- C
68 -- D
69 -- E
70 -- F
71 -- G
72 -- H
73 -- I
74 -- J
75 -- K
76 -- L
77 -- M
78 -- N
79 -- O
80 -- P
81 -- Q
82 -- R
83 -- S
84 -- T
85 -- U
86 -- V
87 -- W
88 -- X
89 -- Y
90 -- Z

 */

val charCode = mapOf(
    '0' to 48,
    '1' to 49,
    '2' to 50,
    '3' to 51,
    '4' to 52,
    '5' to 53,
    '6' to 54,
    '7' to 55,
    '8' to 56,
    '9' to 57,
    'A' to 65,
    'B' to 66,
    'C' to 67,
    'D' to 68,
    'E' to 69,
    'F' to 70,
    'G' to 71,
    'H' to 72,
    'I' to 73,
    'J' to 74,
    'K' to 75,
    'L' to 76,
    'M' to 77,
    'N' to 78,
    'O' to 79,
    'P' to 80,
    'Q' to 81,
    'R' to 82,
    'S' to 83,
    'T' to 84,
    'U' to 85,
    'V' to 86,
    'W' to 87,
    'X' to 88,
    'Y' to 89,
    'Z' to 90
)

var i = 0
var co = 0
fun main() {
    println("! Enter your namelist file below")
    println("Program will toggle if you move your mouse, mouse pos values are hard coded, and only 3 letter names work. For longer names program must be edited, and to change mouse positions edit robot().")

    thread { sleep(2000) }

    var nameList = mutableListOf<String>()
    val file = File("")
    if (!file.exists()) { println("File '$file' does not exist! Enter your NameList file"); exitProcess(420) }
    file.forEachLine {

        nameList.add(it)

    }

    while (co < 500 ) {
        val username = nameList[co]
        println("username: $username")
        val a = username[0]
        val b = username[1]
        val c = username[2]

        println("$co < Count")
        co++
        robot(a, b, c)
    }

}


fun robot(one: Char, two: Char, three: Char) {
    val aa = if (one.isLetter()) { one.uppercaseChar() } else { one }
    val bb = if (two.isLetter()) { two.uppercaseChar() } else { two }
    val cc = if (three.isLetter()) { three.uppercaseChar() } else { three }

    val a = charCode[aa]
    val b = charCode[bb]
    val c = charCode[cc]
    //println("$a, $b, $c = a, b, c")
    if (a == null || b == null || c == null) { return }



    val robot = Robot()

    robot.mouseMove(1140, 618)  //  Mouse position 1 - nickname bar
    robot.delay(200)
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    robot.delay(200)
    robot.keyPress(KeyEvent.VK_BACK_SPACE)
    robot.keyRelease(KeyEvent.VK_BACK_SPACE)
    robot.keyPress(KeyEvent.VK_BACK_SPACE)
    robot.keyRelease(KeyEvent.VK_BACK_SPACE)
    robot.keyPress(KeyEvent.VK_BACK_SPACE)
    robot.keyRelease(KeyEvent.VK_BACK_SPACE)
    robot.delay(200)



    robot.keyPress(a)
    robot.keyRelease(a)

    robot.keyPress(b)
    robot.keyRelease(b)

    robot.keyPress(c)
    robot.keyRelease(c)



    robot.delay(200)


    robot.mouseMove(1119, 790)  // Mouse position 2 - submit button
    robot.delay(2000)

    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    robot.delay(3000)   // Edit delay to run faster


    val pos = MouseInfo.getPointerInfo().location.toString()  //  Move mouse to stop program
    if (!pos.contains("1059") && !pos.contains("1119")) {
        println("TOGGLING! END: $co from 0.")
        exitProcess(69)
    }

}
