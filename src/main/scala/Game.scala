object Game extends App {
  val systemDigitCount = 4 //how many digits in computer generated number and how many allowed for guess

  var systemSet : Set[String] = Set()
  var guessSet : Set[String] = Set()

  var systemString = ""
  var guessString = ""

  var guessBulls = 0 // returns to zero after each attempt
  var guessCows = 0 // returns to zero after each attempt

  var attempts = 0 // increases by one after each valid guess (valid = 4 digits, not exit, only unique digits)

  var gameWon = false
  var gameEnd = false
  var gameLost = false




  generateSystemSet()
  startGameMessage()

  while ( !gameWon && !gameEnd && !gameLost ) {
    readGuess()

    if( !gameEnd ){
      compareGuessSetAndSystemSet()
      checkVictoryHandleCounters()
      midGameMessage()
    }
  }

  if( gameWon ){
    wonGameMessage()
  } else if (gameLost){
    println(s"You lost after $attempts")
  }
  else {
    endGameMessage()
  }




  def generateSystemSet(digitString: String = "0123456789") = {
      val digitList = digitString.toList
      val shuffledList = scala.util.Random.shuffle(digitList)
      val offset = if (shuffledList(0) != '0') 0 else 1
      val myDigits = shuffledList.slice(offset, systemDigitCount + offset)

      //myDigits.mkString("")
    systemString = myDigits.mkString("") //teksts ar cipariem sistema
    println(systemString) //for actual game need to remove this line
    for (i <- 0 until (systemDigitCount)) {
      systemSet += systemString.charAt(i).toString
    }
  }

 def startGameMessage() {
   println("\nWelcome to Bulls and Cows game!\nYou need to guess a 4-digit number with no duplicate digits")
   println("There are two hints:\nCows will hint matching digits of your guess but in incorrect position\nBulls will hint how many of your guessed digits matches and are in the correct position\n")
   println("If you want to exit the game write [exit]")
 }
  def readGuess(){
    var validGuess = false

    while ( !validGuess && !gameEnd ) {
      //guessString = scala.io.StdIn.readLine()//read option 1
      println("Please guess a 4-digit number with no duplicate digits:\n")
      guessString = readLine() //read option 2
      validGuess = validateGuess( guessString )
    }
  }

  def validateGuess( inputString : String )={
    var inputValid = true

    val patternForOnlyDigits = "^[0-9]*$"

      //giving possibility to exit game any moment without guessing:
    if( inputString == "exit" ){
      gameEnd = true
      inputValid = false
    } else if( inputString.length() > systemDigitCount ){
      inputValid = false
      println(inputString + " is too long. It now has " +inputString.length()+ " characters")
      println("Please try "+systemDigitCount+" digit long input. Or type 'exit' to stop the game");
    } else if( inputString.length() < systemDigitCount ){
      inputValid = false
      println(inputString + " is too short. ")
      println("Please try "+systemDigitCount+" digit long input. Or type 'exit' to stop the game");
    } else if( !(inputString matches patternForOnlyDigits) ){ // checking if input has only digits and turning condition to opposite
      inputValid = false
      println(inputString + " does not contain only digits.")
      println("Please try "+systemDigitCount+" digit long input. Or type 'exit' to stop the game");
    }
    // if everything is fine then we check if there are no duplicates
    if( inputValid ){
      inputValid = transformInputIntoSet( inputString )

      if( !inputValid ){
        println(inputString + " has repetitive digits.")
        println("Please try "+systemDigitCount+" UNIQUE digit long input. Or type 'exit' to stop the game");
      }
    }

    inputValid
  }

  def transformInputIntoSet( inputString : String )={
    var duplicatesValid = true

    guessSet = Set() //clears previous guess

    for (i <- 0 until (systemDigitCount)) {
      if(guessSet contains inputString.charAt(i).toString){
        duplicatesValid = false
      } else {
        guessSet += inputString.charAt(i).toString // if not duplicate -> writes in guess set for further validations
      }
    }

    duplicatesValid // returns value
  }

  def compareGuessSetAndSystemSet(){
    guessBulls = 0
    guessCows = 0

    for (i <- 0 until (systemDigitCount)) {
      if( systemString.charAt(i).toInt == guessString.charAt(i).toInt ){
        guessBulls += 1
      } else if(systemSet contains guessString.charAt(i).toString){
        guessCows += 1
      }
    }
  }
  def checkVictoryHandleCounters(){
    if( guessBulls == systemDigitCount){
      gameWon = true
    }
    attempts += 1
    if (attempts == 10 && !gameWon){
      gameLost = true
    }
  }


  def midGameMessage(){
    println("\n Guess:" + guessString + " had "+guessBulls+" Bulls and "+guessCows+" Cows.")
  }

  def wonGameMessage(){
    println("\nCongratulations!\nYou won in " + attempts + " attempt/s!")
  }

  def endGameMessage(){
    println("\nSad to see you go!\nBetter luck next time!")
    println(s"Correct answer was $systemString.")
  }

}
