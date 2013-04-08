package test.scala

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers
import main.scala.Main

class MyMainSpec extends FunSpec with BeforeAndAfter with ShouldMatchers {
  
  var analyser:Main = _
  
  before {
    analyser = new Main
  }
  
  describe("Parentheses balancing") {
    describe("When receiving an empty array of chars") {
      it("should accept as balanced") {
        val chars = "".toList
        val result = analyser.balance(chars)
        result should equal(true)
      }
    }
    
    describe("When receiving the simple '()' string") {
      it("should accept as balanced") {
        val chars = "()".toList
        val result = analyser.balance(chars)
        result should equal(true)
      }
    }
    
    it("should not accept any sequence starting with ')'") {
      val result1 = analyser.balance(")".toList)
      val result2 = analyser.balance(")()()()".toList)
      val result3 = analyser.balance(")))(((".toList)
      result1 should equal(false)
      result2 should equal(false)
      result3 should equal(false)
    }
    
    it("should accept any balanced sequence") {
      val result1 = analyser.balance("()()()".toList)
      val result2 = analyser.balance("((aa)(aa)(aa))".toList)
      val result3 = analyser.balance("((aaa(aaa))a)".toList)
      val result4 = analyser.balance("(((())))  ()()()((aa)(aa)(aa))((aaa(aaa))a)".toList)
      result1 should equal(true)
      result2 should equal(true)
      result3 should equal(true)
      result4 should equal(true)
    }
    
     it("should not accept any unbalanced sequence") {
      val result1 = analyser.balance("())()".toList)
      val result2 = analyser.balance("((aasdasd(aa)(aa))".toList)
      val result3 = analyser.balance("((aaa(aaa))a) ()(".toList)
      val result4 = analyser.balance("((((abc)))) )( ()()()((aa)(aa)(aa))((aaa(aaa))a)".toList)
      result1 should equal(false)
      result2 should equal(false)
      result3 should equal(false)
      result4 should equal(false)
    }
    
  }

}