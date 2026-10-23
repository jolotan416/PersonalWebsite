package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
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
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
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
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
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
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
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
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Paradox Cat GmbH · Germany") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Senior Developer | July 2024 – Present
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I serve as a technical expert for BMW Android Automotive OS telematics use cases. I help shape requirements and planning across multiple ECUs while also implementing and maintaining the features myself.
                    
                    My architectural changes moved multiple applications to a Unidirectional Data Flow architecture and introduced multi-user communication via AIDL. This improved performance, shortened development time, and cut down on crashes and critical issues. I also led a testing push that brought code coverage above 80% across 10 applications. Through code reviews and documentation, I help the team keep that quality bar high.
                """.trimIndent()
            )
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Software Developer | August 2022 – June 2024
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I implemented and maintained telematics features across 10 BMW Android Automotive OS applications. These covered MQTT and REST backend communication, call handling, car signal processing, and video playback.
                    
                    I also led the work to support multiple ECUs. That meant building new Jetpack Compose screens, maintaining several backend communication frameworks, and adding multiple product flavors to the Zuul CI/CD pipeline. This work made it possible to release our apps in new BMW car generations. Along the way, I built several applications from scratch to meet new telematics
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "BeautyMnl · Philippines") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Mobile Developer (Android) | July 2019 – April 2022
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I led feature development for BeautyMnl’s e-commerce app, working closely with design, business, and other departments to take features from idea to launch.
                    
                    My biggest project was rebuilding the app from the ground up. The rebuild supported the company’s rebranding and introduced MVVM architecture with Kotlin Coroutines and Retrofit, which made the codebase much easier to maintain. I launched features that increased conversions, improved the shopping experience, and added new payment methods. I also set up a Bitrise CI/CD pipeline that replaced a 20–30 minute manual deployment process, and I started the team’s unit testing practice.
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Nokia Technology Center · Philippines"
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Team Technical Lead & Code Guard | February 2019 – June 2019
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I was the go-to person for technical specifications on 5G network component simulators, and the primary code reviewer for the team. I led the introduction of data traffic features into a 5G simulator, which made system demos of Nokia’s flagship product possible.
                """.trimIndent()
            )
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Deputy Code Guard | October 2018 – February 2019
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I reviewed code for optimization and readability in a newly formed scrum team and identified opportunities for architectural improvement.
                """.trimIndent()
            )
            Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Scrum Feature Owner & R&D Engineer | June 2017 - October 2018
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I developed 5G network simulator features in C++ and wrote technical specifications covering virtualization, networking, platform compatibility, and component integration. I also coordinated across teams. My work leading the initial virtualization of multiple network simulators set the foundation for future development configurations.
                """.trimIndent()
            )
        }
        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "Education") {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    University of the Philippines Diliman
                    Bachelor of Science in Computer Science, Cum Laude (2013 – 2017)
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    During university I competed in several hackathons as a front-end designer, programmer, and presenter. I won first place at Hackzilla and Hack UP, and placed third at Accenture: Program the Future. I also served as Marketing Head of the Association for Computing Machinery, UP Diliman Student Chapter.
                """.trimIndent()
            )
        }
    }
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