package com.ccreusot.customlintrules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue

class NoodleNamingDetectorTest : LintDetectorTest() {
    override fun getDetector(): Detector = NoodleNamingDetector()

    override fun getIssues(): MutableList<Issue> = mutableListOf(NoodleNamingDetector.ISSUE)

    fun testDetectorExpectingAnIssue() {
        lint().files(
            kotlin("""
                package co.noodle

                class NFactory
            """)
        ).run()
            .expectErrorCount(1)
    }
}