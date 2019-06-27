package com.ccreusot.customlintrules

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CustomRulesIssueRegistryTest {
    val registry = CustomRulesIssueRegistry()

    @Test
    fun testNumberOfIssue() {
        assertThat(registry.issues.size).isEqualTo(1)
    }

    @Test
    fun testCheckIssuesInRegistry() {
        assertThat(registry.issues).containsExactly(NoodleNamingDetector.ISSUE)
    }
}