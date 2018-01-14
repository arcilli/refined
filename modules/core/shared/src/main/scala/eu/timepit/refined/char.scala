package eu.timepit.refined

import eu.timepit.refined.api.{Result, Show, Validate}
import eu.timepit.refined.boolean.Or
import eu.timepit.refined.char._

/** Module for `Char` related predicates. */
object char extends CharValidate {

  /** Predicate that checks if a `Char` is a digit. */
  final case class Digit()

  /** Predicate that checks if a `Char` is a letter. */
  final case class Letter()

  /** Predicate that checks if a `Char` is a lower case character. */
  final case class LowerCase()

  /** Predicate that checks if a `Char` is an upper case character. */
  final case class UpperCase()

  /** Predicate that checks if a `Char` is white space. */
  final case class Whitespace()

  /** Predicate that checks if a `Char` is a letter or digit. */
  type LetterOrDigit = Letter Or Digit
}

private[refined] trait CharValidate {

  implicit def digitValidate: Validate.Plain[Char, Digit] =
    Validate.fromPredicate(_.isDigit, t => s"isDigit('$t')", Digit())

  implicit def digitShow: Show[Char, Digit] =
    new Show[Char, Digit] {
      override def showExpr(t: Char): String = s"isDigit('$t')"

      override def showResult[R](t: Char, result: Result[R]): Unit = ???
    }

  implicit def letterValidate: Validate.Plain[Char, Letter] =
    Validate.fromPredicate(_.isLetter, t => s"isLetter('$t')", Letter())

  implicit def lowerCaseValidate: Validate.Plain[Char, LowerCase] =
    Validate.fromPredicate(_.isLower, t => s"isLower('$t')", LowerCase())

  implicit def upperCaseValidate: Validate.Plain[Char, UpperCase] =
    Validate.fromPredicate(_.isUpper, t => s"isUpper('$t')", UpperCase())

  implicit def whitespaceValidate: Validate.Plain[Char, Whitespace] =
    Validate.fromPredicate(_.isWhitespace, t => s"isWhitespace('$t')", Whitespace())
}
