package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.molecules.SectionIcon.Drawable
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.DetailsType
import com.jolotan.personalwebsite.ui.util.LocalCompact
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.beautymnl
import personalwebsite.shared.generated.resources.favicon
import personalwebsite.shared.generated.resources.github
import personalwebsite.shared.generated.resources.nokia
import personalwebsite.shared.generated.resources.paradoxcat
import personalwebsite.shared.generated.resources.spotlight
import personalwebsite.shared.generated.resources.up_diliman
import personalwebsite.shared.generated.resources.wais

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
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Architecture that scales",
            sectionIcon = SectionIcon.Vector(Icons.Default.Architecture)
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I design and migrate apps with intentional use of different design patterns like Unidirectional Data Flow, MVVM and MVI. The goal is not to just follow the new trending architecture, but to build software that's predictable maintainable and less prone to crashes.
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Quality you can measure",
            sectionIcon = SectionIcon.Vector(Icons.Default.VerifiedUser)
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I've led testing initiatives that raised code coverage above 80% across 10 production applications and have built CI/CD pipelines that ensure the quality we've worked on stays the same. 
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Users front and center",
            sectionIcon = SectionIcon.Vector(Icons.Default.Groups)
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I build apps that are technically sound and polished enough to feel effortless to use. This means thinking beyond the usual user scenarios and designing for edge cases that users may face in the real world.
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Technical leadership",
            sectionIcon = SectionIcon.Vector(Icons.Default.Handshake)
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    I review code, mentor teammates, write migration and testing guides, and introduce workflow improvements that help the team ship faster and with more confidence.
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Skills and Tools",
            sectionIcon = SectionIcon.Vector(Icons.Default.Construction)
        ) {
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
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Paradox Cat GmbH · Germany",
            sectionIcon = Drawable(Res.drawable.paradoxcat)
        ) {
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
                    I serve as a technical expert for BMW’s Android Automotive OS telematics use cases, helping with requirements creation and planning across multiple ECUs while also implementing, maintaining, and reviewing features across the codebase.
                    
                    I introduced architectural changes to multiple applications by shifting them towards a Unidirectional Data Flow architecture and adding multi-user communication through AIDL, which improved performance, shortened development time, and reduced crashes and critical issues. I also enhanced our code quality by initiating local unit tests and instrumented tests that brought code coverage above 80% across 10 applications.
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
                    I implemented and maintained telematics features across 10 BMW Android Automotive OS applications, covering backend communication over MQTT and REST APIs, call handling, car signal processing, and video playback.
                    
                    To support the release of new BMW car generations, I introduced multi-ECU support to existing applications, which involved building new Jetpack Compose screens, maintaining multiple backend communication frameworks and data structures, and supporting multiple product flavors in our CI/CD pipeline. I also built multiple applications from scratch to meet new telematics requirements.
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "BeautyMnl · Philippines",
            sectionIcon = Drawable(Res.drawable.beautymnl)
        ) {
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
                    I led feature development for BeautyMnl’s e-commerce mobile app, working closely with different departments to take features from idea to launch.
                    
                    My biggest contribution was rebuilding the app from the ground up to support the company’s rebranding. Along the way, I introduced architectural improvements using MVVM with Kotlin Coroutines and Retrofit, which made the codebase much easier to maintain. I launched several features that increased user conversions, improved the user experience, and added new payment methods. I also set up a Bitrise CI/CD pipeline that replaced a 20–30-minute manual deployment process, and initiated the team’s unit testing practice.                   
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Nokia Technology Center · Philippines",
            sectionIcon = Drawable(Res.drawable.nokia)
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SubSectionTitleStyle(),
                text = """
                    Team Technical Lead & Code Guard | February 2019 – June 2019
                    Deputy Code Guard | October 2018 – February 2019
                    Scrum Feature Owner & R&D Engineer | June 2017 - October 2018
                """.trimIndent()
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                    During my stay, I progressed from R&D Engineer to Team Technical Lead in under two years, serving as the team’s point person for technical specifications and its primary code reviewer for correctness, optimization, and readability.
                    
                    I led the introduction of data traffic features in a 5G network component simulator, which made it possible to run system demos of Nokia’s main product. I also laid the groundwork for future development setups by leading the initial virtualization of multiple network component simulators. 
                """.trimIndent()
            )
        }
        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Education",
            sectionIcon = Drawable(Res.drawable.up_diliman)
        ) {
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
                    As a university student, I competed in and won several hackathons as a front-end designer, programmer, and presenter. I also served as Marketing Head of the Association for Computing Machinery, UP Diliman Student Chapter.
                """.trimIndent()
            )
        }
    }
}

@Composable
fun ProjectsDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        val uriHandler = LocalUriHandler.current

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {
                    uriHandler.openUri("https://github.com/jolotan416/budget-tracker-app")
                }),
            title = "Wais: Budget Tracker App",
            description = """
                Wais is a Kotlin Multiplatform application that aims to simplify financial organization, especially for (but not limited to) Filipinos. It supports multiple profiles, automatic exchange rates, savings goals, budget allocations, and cash flow tracking, all packaged in one easy-to-use app.
                
                It uses an offline-first approach, using Room and DataStore to persist user data and exchange rates fetched through Ktor. It also supports deployment to both the Google Play Store and the Apple App Store, with Firebase integrations for analytics events and crash tracking.
                """.trimIndent(),
            image = Res.drawable.wais,
            tags = listOf(
                "Android",
                "iOS",
                "Kotlin Multiplatform",
                "Compose",
                "Unidirectional Data Flow Architecture",
                "MVVM",
                "Styles API",
                "Koin",
                "Ktor",
                "Room Database",
                "Coroutines and Flows",
                "DataStore",
                "Firebase Hosting and Analytics",
                "AI-assisted"
            )
        )

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {
                    uriHandler.openUri("https://github.com/jolotan416/PersonalWebsite")
                }),
            title = "Personal Website",
            description = "This site that you're currently browsing, built with Kotlin Multiplatform and deployed on Firebase Hosting.",
            image = Res.drawable.favicon,
            tags = listOf(
                "Kotlin Multiplatform",
                "Compose",
                "Styles API",
                "Firebase Hosting",
            )
        )

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {
                    uriHandler.openUri("https://github.com/jolotan416/UnraidAppProject")
                }),
            title = "Unraid App Project",
            description = """This is my first Kotlin Multiplatform project that connects to Unraid NAS servers through its GraphQL API.""",
            image = Res.drawable.github,
            tags = listOf(
                "Kotlin Multiplatform",
                "Compose",
                "Unidirectional Data Flow Architecture",
                "MVVM",
                "Koin",
                "Ktor",
                "Room Database",
                "Coroutines and Flows",
                "Coil",
            )
        )

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {
                    uriHandler.openUri("https://github.com/jolotan416/spotlight-app")
                }),
            title = "Spotlight: To-do List App",
            description = """This is my first Android project that was made from scratch, designed to help users focus on one task at a time.""",
            image = Res.drawable.spotlight,
            tags = listOf(
                "Android",
                "Compose",
                "Fragments",
                "MVVM with LiveData",
                "Unidirectional Data Flow Architecture",
                "Room Database",
                "Coroutines and Flows",
                "Hilt",
                "WorkManager"
            )
        )
    }
}

@Composable
fun ProjectsDetailsSection(
    modifier: Modifier = Modifier,
    style: Style = Style,
    title: String,
    description: String,
    image: DrawableResource?,
    tags: List<String>
) {
    DetailsSection(
        modifier = modifier.styleable(style = style),
        title = title
    ) {
        if (LocalCompact.current) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                image?.let {
                    Image(
                        modifier = Modifier.size(AppTheme.dimensions.compactImageWidth),
                        painter = painterResource(it),
                        contentDescription = null
                    )
                }
                ProjectDetails(description = description, tags = tags)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                image?.let {
                    Image(
                        modifier = Modifier.size(AppTheme.dimensions.compactImageWidth),
                        painter = painterResource(it),
                        contentDescription = null
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
                ) {
                    ProjectDetails(description = description, tags = tags)
                }
            }
        }
    }
}

@Composable
fun ProjectDetails(description: String, tags: List<String>) {
    StyledText(
        modifier = Modifier.fillMaxWidth(),
        style = SectionTextStyle(),
        text = description
    )

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.rowSmallHorizontalSpacing, if (LocalCompact.current) {
                Alignment.CenterHorizontally
            } else {
                Alignment.Start
            }
        )
    ) {
        tags.forEach { tag ->
            FilterChip(
                selected = false,
                onClick = {},
                label = {
                    StyledText(style = AppTheme.styles.text.helperText, text = tag)
                })
        }
    }
}

@Composable
fun DetailsSection(
    modifier: Modifier = Modifier,
    style: Style = Style,
    title: String,
    sectionIcon: SectionIcon? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.styleable(style = style then AppTheme.styles.container.section),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing),
        horizontalAlignment = if (LocalCompact.current) Alignment.CenterHorizontally else Alignment.Start
    ) {
        if (LocalCompact.current) {
            DetailsSectionIcon(
                modifier = Modifier.size(AppTheme.dimensions.largeIconSize),
                sectionIcon = sectionIcon
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = AppTheme.styles.text.sectionHeaderText then TextAlignmentStyle()
            )
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DetailsSectionIcon(
                    modifier = Modifier.size(AppTheme.dimensions.largeIconSize),
                    sectionIcon = sectionIcon
                )
                StyledText(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = AppTheme.styles.text.sectionHeaderText then TextAlignmentStyle()
                )
            }
        }

        content()
    }
}

@Composable
fun DetailsSectionIcon(
    modifier: Modifier = Modifier,
    style: Style = Style,
    sectionIcon: SectionIcon?
) {
    when (sectionIcon) {
        is SectionIcon.Vector -> {
            Icon(
                modifier = modifier.styleable(style = style),
                imageVector = sectionIcon.imageVector,
                contentDescription = null,
                tint = AppTheme.colors.onSurface
            )
        }

        is Drawable -> {
            Image(
                modifier = modifier.styleable(style = style),
                painter = painterResource(sectionIcon.drawableResource),
                contentDescription = null
            )
        }

        else -> {}
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

sealed interface SectionIcon {
    data class Vector(val imageVector: ImageVector) : SectionIcon
    data class Drawable(val drawableResource: DrawableResource) : SectionIcon
}