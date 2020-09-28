
object bulls extends App {
  val nmin = 1234
  val nmax = 9876
  val maxTries = 10
  val num1,num2,num3,num4 = 1 to 9
val attempts = 0
  import java.util
  import java.util.Random
// TODO GenerateSet
  val r = new Random
  val s = new util.HashSet[Integer]
  while ( {
    s.size < 4
  }) s.add(r.nextInt(9))
  val generateNumber = Set(s)
  println(s)
  // TODO StartGame
  println ("Welcome to Bulls and Cows game!\nYou need to guess a 4-digit number with no duplicate digits")
  println ("There are two hints:\nCows will hint matching digits of your guess but in incorrect position\nBulls will hint how many of your guessed digits matches and is in the correct position\n")
  print("Guess a 4-digit number with no duplicate digits: ")
// TODO Bulls and Cows validation


  // TODO won/ lost the game
  if (attempts < maxTries)
  println(s"You won after $attempts guesses!")
  else print(s"You didn't guess after $maxTries, correct number was $generateNumber")
}