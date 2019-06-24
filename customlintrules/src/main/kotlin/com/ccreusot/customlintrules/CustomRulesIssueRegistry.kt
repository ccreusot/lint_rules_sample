package com.ccreusot.customlintrules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*
import java.util.*

class CustomRulesIssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        Issue.create(
            "JudgeDredd",
            "You can't use Judge()",
             "You can't construct a Judge by your self, only a Judge can instance it self. (Judge.newInstance())",
            Category.CORRECTNESS,
            5,
            Severity.FATAL,
            Implementation(
                JudgeConstructDetector::class.java,
                EnumSet.of(Scope.JAVA_FILE, Scope.TEST_SOURCES)
            )
        )
    )

    override val api: Int
        get() = CURRENT_API
}
