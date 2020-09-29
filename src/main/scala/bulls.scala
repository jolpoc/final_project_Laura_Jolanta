import BullCow.hasDups

object bulls extends App {
var attempts = 0
  def getRandomUniqueDigit(digitSeq: String = "0123456789", getDigitCount: Int = 4) = {
    val digitList = digitSeq.toList
    val shuffledList = scala.util.Random.shuffle(digitList)
    val offset = if (shuffledList(0) != '0') 0 else 1
    val myDigits = shuffledList.slice(offset, getDigitCount+offset)
    myDigits.mkString(" ")
  }
  println(getRandomUniqueDigit(getDigitCount = 4))
  println(getRandomUniqueDigits(getDigitCount = 4))

  // TODO jāizvēlas viens no def kurš labāku random ciparu dod
    def getRandomUniqueDigits(digitSeq: String = "0123456789", getDigitCount: Int = 4) = {
      val digitList = digitSeq.toList
      val shuffledList = scala.util.Random.shuffle(digitList)
      val offset = if (shuffledList(0) != '0') 0 else 1
      val myDigits = shuffledList.slice(offset, getDigitCount + offset)
      //    println(myDigits.mkString(""))
      myDigits.mkString("").toInt

      //  println(getRandomUniqueDigits(getDigitCount = 5))
      //  println("*"*30)
      //  println(getRandomUniqueDigits())
      //  for (i <- 0 to 10) println(getRandomUniqueDigits())
      //    val lotsOfNumbers = for (i <- 1 to 10000) yield getRandomUniqueDigits()
      //    val under1200 = lotsOfNumbers.filter(_ < 1200)
      //  under1200.foreach(println)
    }

  // Start a game

  println("\nWelcome to Bulls and Cows game!\nYou need to guess a 4-digit number with no duplicate digits")


  println("There are two hints:\nCows will hint matching digits of your guess but in incorrect position\nBulls will hint how many of your guessed digits matches and is in the correct position\n")
  print("Guess a 4-digit number with no duplicate digits: ")
  // TODO Bulls and Cows validation
//  val input = Console.readInt
//  val digits = input.toString.map(_.asDigit).toList
//  if (input >= 1111 && input <= 9999 && !hasDups(digits)) {

    attempts += 1
    var bulls, cows = 0
    for (i <- 0 to 3)

      cows += 1

    if (bulls == 4)

      println(s"$cows Cows and $bulls Bulls.".format(cows, bulls))

    //    // TODO won/ lost the game
    //    if (attempts < maxTries)
    //      println(s"You won after $attempts guesses!")
    //    else print(s"You didn't guess after $maxTries, correct number was $generateNumber")
    //  }
  }
}