package com.ccreusot.customlintrules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.junit.Assert.*

class NoodleCaseDetectorTest : LintDetectorTest() {

    override fun getDetector(): Detector = NoodleCaseDetector()

    override fun getIssues(): MutableList<Issue> = mutableListOf(NoodleCaseDetector.ISSUE)

    fun testDetectorExpectingAnIssueOnFunction() {
        lint().files(
            kotlin(
                """
                fun ourPreferenceGoesToTheBestNoodleWorkShop() {
                }
                
                fun OurPreferenceGOesTOTheBestNOOdleWOrkShOp() {
                }

                class Noodle

                class LesNouillesCestLaVie : Thread() {
                    fun makeSomePasta() : Noodle {
                        return Noodle()
                    }

                    fun undonSaute() : Noodle {
                        return Noodle()
                    }

                    fun pourLaGloireDesNouilles() {
                    }
                    
                    fun jOygivesOnegreatjOy() {
                    }
                    
                    override fun run(){super.run()
                    }
                }
            """
            )
        ).run()
            .expectErrorCount(5)
    }

    fun testDetectorExpectingNoIssueOnFunction() {
        lint().files(
            kotlin(
                """
                fun ourpreferencegOestOthebestnOOdlewOrkshOp() {
                }

                class Noodle

                class LesNouillesCestLaVie {
                    fun makesOmepasta() : Noodle {
                        return Noodle()
                    }

                    fun undOnsaute() : Noodle {
                        return Noodle()
                    }

                    fun pOurlaglOiredesnOuilles() {
                    }
                    
                    fun jOygivesOnegreatjOy() {
                    }
                }
            """
            )
        ).run()
            .expectClean()
    }
}