package main.scala

class Main extends App {

  def balance(chars:List[Char]):Boolean = {
    isBalancedExpression(chars, "")
  }
  
  def isBalancedExpression(chars:List[Char], currentPar:String):Boolean = {
    if(chars.isEmpty) {
      currentPar.equals("")
    }
    else {
    	if(chars.head == '(' ) isBalancedExpression(chars.tail, currentPar + "(")
    	
	    else if(chars.head == ')') {
	      if(currentPar.contains("(")) {
	        val newPar = currentPar.replaceFirst("\\(", "")
	        isBalancedExpression(chars.tail, newPar)
	      }
	      else false
	    }
	    else isBalancedExpression(chars.tail, currentPar)
    }
    
  }
 
  
}