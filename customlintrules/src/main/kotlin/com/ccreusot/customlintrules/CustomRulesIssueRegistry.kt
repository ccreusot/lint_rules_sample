package com.ccreusot.customlintrules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*

class CustomRulesIssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        NoodleNamingDetector.ISSUE
    )

    override val api: Int
        get() = CURRENT_API
}
