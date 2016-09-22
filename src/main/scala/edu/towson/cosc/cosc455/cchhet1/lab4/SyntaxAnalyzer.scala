package edu.towson.cosc.cosc455.cchhet1.lab4

import java.lang

import edu.towson.cosc.cosc455.cchhet1.lab4

class SyntaxAnalyzer {

  // For ease, store the terminal literals in a List
  val ARTICLES: List[String] = List("teh", "a")
  val VERBS: List[String] = List("ates", "lovez", "hatez")
  val NOUNS: List[String] = List("kat", "dawg", "rat")
  val ADJECTIVE: List[String] = List("fat", "hungry", "happy", "mean")

  // Flag for errors and helper methods
  var errorFound: Boolean = false

  def setError() = errorFound = true

  def resetError() = errorFound = false

  def getError: Boolean = errorFound


  // This method implements the BNF rule for a sentence <S> ::= <NP> <ADV> <V> <NP>
  def Sentence() = {
    resetError()
    if (!errorFound) NounPhrase()

    if (!errorFound) Verb()
    if (!errorFound) NounPhrase()
  }

  // This method implements the BNF rule for a noun phrase <NP> ::= <A> <Adj> <N>
  def NounPhrase() = {
    if (!errorFound) Article()
    if (!errorFound) Adjective()
    if (!errorFound) Noun()
  }

  // This method implements the BNF rule for a verb <V> ::= ates | hatez | hatez
  def Verb() = {
    if (VERBS contains lab4.Compiler.currentToken)
      lab4.Compiler.Scanner.getNextToken()
    else {
      println("SYNTAX ERROR - A verb was expected when '" + lab4.Compiler.currentToken + "' was found.")
      setError()
    }
  }

  // This method implements the BNF rule for an article <adjective> ::= fat|hungry|happy|mean
  def Adjective() = {
    if (ADJECTIVE contains lab4.Compiler.currentToken)
      lab4.Compiler.Scanner.getNextToken()
    else {
      println("SYNTAX ERROR - An article was expected when '" + lab4.Compiler.currentToken + "' was found.")
      setError()
    }
  }


  // This method implements the BNF rule for a noun <N> ::= dawg | kat | rat
  def Noun() = {
    if (NOUNS contains lab4.Compiler.currentToken)
      lab4.Compiler.Scanner.getNextToken()
    else {
      println("SYNTAX ERROR - A noun was expected when '" + lab4.Compiler.currentToken + "' was found.")
      setError()
    }
  }

  // This method implements the BNF rule for an article <N> ::= teh | a
  def Article() = {
    if (ARTICLES contains lab4.Compiler.currentToken)
      lab4.Compiler.Scanner.getNextToken()
    else {
      println("SYNTAX ERROR - An article was expected when '" + lab4.Compiler.currentToken + "' was found.")
      setError()
    }
  }
}


