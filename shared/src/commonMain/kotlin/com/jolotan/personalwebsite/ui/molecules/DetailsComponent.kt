package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.DetailsType
import com.jolotan.personalwebsite.ui.util.LocalCompact

@Composable
fun DetailsComponent(
    modifier: Modifier = Modifier,
    style: Style = Style,
    detailsType: DetailsType,
) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            style = AppTheme.styles.text.detailsTitleText then TextAlignmentStyle(),
            text = detailsType.title
        )

        DetailsSections(modifier = Modifier.fillMaxWidth(), detailsType = detailsType)
    }
}

@Composable
fun DetailsSections(
    modifier: Modifier = Modifier,
    style: Style = Style,
    detailsType: DetailsType
) {
    when (detailsType) {
        DetailsType.Skills -> SkillsDetailsSections(modifier, style)
        DetailsType.Experience -> ExperienceDetailsSections(modifier, style)
        DetailsType.Projects -> ProjectsDetailsSections(modifier, style)
    }
}

@Composable
fun SkillsDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Architecture that scales") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I design and migrate apps with intentional use of different design patterns like Unidirectional Data Flow, MVVM and MVI. The goal is not to just follow the new trending architecture, but to build software that's predictable maintainable and less prone to crashes.
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Quality you can measure") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I've led testing initiatives that raised code coverage above 80% across 10 production applications and have built CI/CD pipelines that ensure the quality we've worked on stays the same. 
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Users front and center") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I build apps that are technically sound and polished enough to feel effortless to use. This means thinking beyond the usual user scenarios and designing for edge cases that users may face in the real world.
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Technical leadership") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I review code, mentor teammates, write migration and testing guides, and introduce workflow improvements that help the team ship faster and with more confidence.
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Skills and Tools") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Languages and UI:
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    • Kotlin (Android & Kotlin Multiplatform)
                    • Jetpack Compose
                    • XML with ViewBinding and DataBinding
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Architecture:
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    • Unidirectional Data Flow
                    • MVVM/MVI
                    • Gradle modularization and convention plugins
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Android Platform:
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    • Components (Activities, Services, Content Providers and Broadcast Receivers)
                    • WorkManager
                    • Interprocess communication using AIDL and multi-user handling
                    • Android Automotive OS
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Libraries:
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    • Kotlin Coroutines & Flow 
                    • Dependency Injection: Hilt, Dagger, Koin
                    • Networking: OkHttp, Ktor, Retrofit
                    • Data Persistence: Room, DataStore
                    • Image Loading: Coil, Glide
                    • Testing: JUnit, MockK, Espresso, Compose Testing, Robolectric
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Backend & Delivery:
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    • REST APIs 
                    • MQTT
                    • Git
                    • CI/CD: Zuul, Bitrise
                """.trimIndent()
            )
        }
    }
}

@Composable
fun ExperienceDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {

}

@Composable
fun ProjectsDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {

}

@Composable
fun DetailsSection(
    modifier: Modifier = Modifier,
    style: Style = Style,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.styleable(style = style then AppTheme.styles.container.section),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = AppTheme.styles.text.sectionHeaderText then TextAlignmentStyle()
        )

        content()
    }
}

@Composable
fun SubSectionTitleStyle() = AppTheme.styles.text.subSectionText then TextAlignmentStyle()

@Composable
fun SectionTextStyle() =
    AppTheme.styles.text.bodyText then AppTheme.styles.text.sectionText then TextAlignmentStyle()

@Composable
fun TextAlignmentStyle() = if (LocalCompact.current) {
    Style { textAlign(TextAlign.Center) }
} else {
    Style { textAlign(TextAlign.Start) }
}