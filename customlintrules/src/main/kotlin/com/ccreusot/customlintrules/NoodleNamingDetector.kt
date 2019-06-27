package com.ccreusot.customlintrules

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.util.isConstructorCall
import java.util.*

class NoodleNamingDetector : Detector(), Detector.UastScanner {

    companion object {
        val ISSUE = Issue.create(
            "\uD83C\uDF5C Naming",
            "You need to put \uD83C\uDF5C as prefix of your class",
            "As naming convention we're using \uD83C\uDF5C as prefix for naming every class in our project",
            Category.CORRECTNESS,
            5,
            Severity.ERROR,
            Implementation(
                NoodleNamingDetector::class.java,
                EnumSet.of(Scope.JAVA_FILE)
            )
        )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return listOf(UClass::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                if (!node.name?.startsWith("Noodle", false)!!) {
                    context.report(ISSUE, context.getNameLocation(node), "Doesn't start with \uD83C\uDF5C!!!")
                }
            }
        }
    }
}
