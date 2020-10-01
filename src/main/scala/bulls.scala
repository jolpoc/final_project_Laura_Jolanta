object CowsBulls extends App {
  // GenerateSet of unique digits
  def getRandomUniqueDigits(digitSeq: String = "0123456789", getDigitCount: Int = 4) = {
    val digitList = digitSeq.toList
    val shuffledList = scala.util.Random.shuffle(digitList)
    val offset = if (shuffledList(0) != '0') 0 else 1
    val myDigits = shuffledList.slice(offset, getDigitCount + offset)
    myDigits
  }

  val computerGeneratedNumber = getRandomUniqueDigits()
  println(computerGeneratedNumber) //in real game this won't be visible

  // StartGame
  println("Welcome to Bulls and Cows game!\nYou need to guess a 4-digit number with no duplicate digits")
  println("There are two hints:\nCows will hint matching digits of your guess but in incorrect position\nBulls will hint how many of your guessed digits matches and is in the correct position\n")


  // Bulls and Cows validation
  var attempts =0
  val maxAttempts = 10
  var won = false
  var lose = false
  while (!won && !lose) {
    attempts += 1
    var bulls = 0
    var cows = 0

    println("Please enter 4-digit number without duplicate digits ")

    val userGuess = scala.io.StdIn.readLine()
    if (validate(userGuess)) {
      val userGuessNumber = userGuess.toList
      for (i <- 0 to 3) {
        if (computerGeneratedNumber(i) == userGuessNumber(i)) {
          bulls += 1
        }
        else if (computerGeneratedNumber.contains(userGuessNumber(i)))
          cows += 1
      }
      if (bulls == 4) {
        won = true

      }
      if (won) {
        println(s"You won in $attempts attempts!")
      } else if (attempts >= maxAttempts) {
        println("You loose! Too many attempts")
        lose = true
      } else {
        println(s"You have $bulls bulls and $cows cows. Try again!")
      }} else {
    }
  }

  def validate(userInput: String): Boolean = {
    if (userInput.length ==4) {
      true
    }else {
      println("Wrong input number size")
      false
    }
  }

}