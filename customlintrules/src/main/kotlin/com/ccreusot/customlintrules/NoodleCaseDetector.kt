package com.ccreusot.customlintrules

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod
import java.util.*

class NoodleCaseDetector : Detector(), Detector.UastScanner {

    companion object {
        val ISSUE = Issue.create(
            "\uD83C\uDF5CCase function name",
            "You don't respect camel case",
            "You should name your function in \uD83C\uDF5CCase like so \"fun yOurfunctiOndOingsOmething()\"" +
                    "only O is in Uppercase",
            Category.CORRECTNESS,
            5,
            Severity.ERROR,
            Implementation(
                NoodleCaseDetector::class.java,
                EnumSet.of(Scope.JAVA_FILE)
            )
        )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {

        }
    }
}