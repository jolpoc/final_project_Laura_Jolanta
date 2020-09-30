object bulls extends App {
  // TODO GenerateSet
  def getRandomUniqueDigits(digitSeq: String = "0123456789", getDigitCount: Int = 4) = {
    val digitList = digitSeq.toList
    val shuffledList = scala.util.Random.shuffle(digitList)
    val offset = if (shuffledList(0) != '0') 0 else 1
    val myDigits = shuffledList.slice(offset, getDigitCount + offset)
    myDigits
  }

  val baseNumber = getRandomUniqueDigits()
  println(baseNumber)

  // TODO StartGame
  println("Welcome to Bulls and Cows game!\nYou need to guess a 4-digit number with no duplicate digits")
  println("There are two hints:\nCows will hint matching digits of your guess but in incorrect position\nBulls will hint how many of your guessed digits matches and is in the correct position\n")


  // TODO Bulls and Cows validation
  var attempts =0
  val maxAttempts = 15
  var won = false
  var lost = false
  while (!won && !lost) {
    attempts += 1
    var bulls = 0
    var cows = 0
    println("Please enter 4-digit number")
    val userGuess = scala.io.StdIn.readLine()
    val userGuessList = userGuess.toList
    for (i <- 0 to 3) {
      if (baseNumber(i) == userGuessList(i)) {
        bulls += 1
      }
      else if (baseNumber.contains(userGuessList(i)))
        cows += 1
    }
    if (bulls == 4) {
      won = true
    }
    if (won) {
      println(s"You won in $attempts attempts!")
    } else if (attempts >= maxAttempts) {
      println("You loose! Too many attempts")
      lost = true
    } else {
      println(s"You have $bulls bulls and $cows cows. Try again!")
    }
  }
}