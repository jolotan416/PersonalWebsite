package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import coil3.compose.AsyncImage
import com.jolotan.personalwebsite.ui.atoms.CustomButton
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.molecules.SectionIcon.Drawable
import com.jolotan.personalwebsite.ui.styles.colors
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.DetailsType
import com.jolotan.personalwebsite.ui.util.LocalCompact
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.beautymnl
import personalwebsite.shared.generated.resources.beautymnl_screenshot_0
import personalwebsite.shared.generated.resources.beautymnl_screenshot_1
import personalwebsite.shared.generated.resources.beautymnl_screenshot_2
import personalwebsite.shared.generated.resources.beautymnl_screenshot_3
import personalwebsite.shared.generated.resources.beautymnl_screenshot_4
import personalwebsite.shared.generated.resources.beautymnl_screenshot_5
import personalwebsite.shared.generated.resources.beautymnl_screenshot_6
import personalwebsite.shared.generated.resources.beautymnl_screenshot_7
import personalwebsite.shared.generated.resources.beautymnl_screenshot_8
import personalwebsite.shared.generated.resources.beautymnl_screenshot_9
import personalwebsite.shared.generated.resources.favicon
import personalwebsite.shared.generated.resources.github
import personalwebsite.shared.generated.resources.nokia
import personalwebsite.shared.generated.resources.paradoxcat
import personalwebsite.shared.generated.resources.spotlight
import personalwebsite.shared.generated.resources.up_diliman
import personalwebsite.shared.generated.resources.wais_screenshot_accounts
import personalwebsite.shared.generated.resources.wais_screenshot_budget
import personalwebsite.shared.generated.resources.wais_screenshot_cashflow
import personalwebsite.shared.generated.resources.wais_screenshot_dashboard
import personalwebsite.shared.generated.resources.wais_screenshot_savings
import personalwebsite.shared.generated.resources.wais_screenshot_transactions

@Composable
fun DetailsComponent(
    modifier: Modifier = Modifier,
    style: Style = Style,
    detailsType: DetailsType?,
) {
    detailsType ?: return

    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.getColumnVerticalSpacing(
                LocalCompact.current
            )
        )
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
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.getColumnVerticalSpacing(
                LocalCompact.current
            )
        )
    ) {
        if (LocalCompact.current) {
            DetailsSection(
                modifier = Modifier.fillMaxWidth(),
                title = "Architecture that scales",
                sectionIcon = SectionIcon.Vector(Icons.Default.Architecture)
            ) {
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SectionTextStyle(),
                    text = """
                    I use Unidirectional Data Flow, MVVM and MVI to build apps that are predictable, maintainable and crash-resistant, not just trendy.
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
                    80%+ code coverage across 10 production apps, protected by CI/CD pipelines I built.
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
                    I build polished, effortless apps designed for real-world edge cases, not just the happy path.
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
                    I review code, mentor teammates, and write guides that help teams ship faster and with confidence.
                """.trimIndent()
                )
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing)
            ) {
                DetailsSection(
                    modifier = Modifier.weight(1f)
                        .fillMaxHeight(),
                    title = "Architecture that scales",
                    sectionIcon = SectionIcon.Vector(Icons.Default.Architecture)
                ) {
                    StyledText(
                        modifier = Modifier.fillMaxWidth(),
                        style = SectionTextStyle(),
                        text = """
                    I use Unidirectional Data Flow, MVVM and MVI to build apps that are predictable, maintainable and crash-resistant, not just trendy.
                """.trimIndent()
                    )
                }
                DetailsSection(
                    modifier = Modifier.weight(1f)
                        .fillMaxHeight(),
                    title = "Quality you can measure",
                    sectionIcon = SectionIcon.Vector(Icons.Default.VerifiedUser)
                ) {
                    StyledText(
                        modifier = Modifier.fillMaxWidth(),
                        style = SectionTextStyle(),
                        text = """
                    80%+ code coverage across 10 production apps, protected by CI/CD pipelines I built.
                """.trimIndent()
                    )
                }
                DetailsSection(
                    modifier = Modifier.weight(1f)
                        .fillMaxHeight(),
                    title = "Users front and center",
                    sectionIcon = SectionIcon.Vector(Icons.Default.Groups)
                ) {
                    StyledText(
                        modifier = Modifier.fillMaxWidth(),
                        style = SectionTextStyle(),
                        text = """
                    I build polished, effortless apps designed for real-world edge cases, not just the happy path.
                """.trimIndent()
                    )
                }
                DetailsSection(
                    modifier = Modifier.weight(1f)
                        .fillMaxHeight(),
                    title = "Technical leadership",
                    sectionIcon = SectionIcon.Vector(Icons.Default.Handshake)
                ) {
                    StyledText(
                        modifier = Modifier.fillMaxWidth(),
                        style = SectionTextStyle(),
                        text = """
                    I review code, mentor teammates, and write guides that help teams ship faster and with confidence.
                """.trimIndent()
                    )
                }
            }
        }

        DetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Skills and Tools",
            sectionIcon = SectionIcon.Vector(Icons.Default.Construction)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(
                    AppTheme.dimensions.getColumnVerticalSpacing(true)
                ),
                horizontalAlignment = if (LocalCompact.current) Alignment.CenterHorizontally else Alignment.Start
            ) {
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Languages and UI:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "Kotlin",
                        "Native Android",
                        "Kotlin Multiplatform",
                        "Jetpack Compose",
                        "XML with ViewBinding and DataBinding",
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Architecture:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "Unidirectional Data Flow Architecture",
                        "MVVM/MVI",
                        "Gradle modularization",
                        "Conventional plugins"
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Android Platform:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "Activities",
                        "Services",
                        "Content providers",
                        "Broadcast receivers",
                        "WorkManager",
                        "Interprocess communication using AIDL",
                        "Multi-user handling",
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Architecture Libraries:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "Kotlin Coroutines",
                        "Flow",
                        "Hilt",
                        "Dagger",
                        "Koin",
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Data and Image Libraries:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "OkHttp",
                        "Ktor",
                        "Retrofit",
                        "Room",
                        "DataStore",
                        "Coil",
                        "Glide",
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Testing Libraries:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "JUnit",
                        "MockK",
                        "Espresso",
                        "Compose testing",
                        "Robolectric"
                    )
                )
                StyledText(
                    modifier = Modifier.fillMaxWidth(),
                    style = SubSectionTitleStyle(),
                    text = """
                    Backend & Delivery:
                """.trimIndent()
                )
                TagsList(
                    modifier = Modifier.fillMaxWidth(), listOf(
                        "REST APIs",
                        "MQTT",
                        "Git",
                        "Zuul",
                        "Bitrise"
                    )
                )
            }
        }

        if (!LocalCompact.current) {
            Spacer(modifier = Modifier.height(AppTheme.dimensions.getColumnVerticalSpacing(false)))
        }
    }
}

@Composable
fun ExperienceDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.getColumnVerticalSpacing(
                LocalCompact.current
            )
        )
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
                    I’m a technical expert for BMW’s Android Automotive OS telematics use cases, shaping requirements and planning across multiple ECUs while implementing, maintaining, and reviewing features.

                    I moved multiple apps to Unidirectional Data Flow and added multi-user communication through AIDL, improving performance, shortening development time, and reducing crashes. I also started unit and instrumented testing that raised code coverage above 80% across 10 apps.
                """.trimIndent()
            )
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
                    I implemented and maintained telematics features across 10 BMW Android Automotive OS apps, including MQTT and REST API communication, call handling, car signal processing, and video playback.

                    For new BMW car generations, I added multi-ECU support to existing apps through new Jetpack Compose screens, multiple backend frameworks, and product flavors in our CI/CD pipeline. I also built several apps from scratch for new telematics requirements.
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
                    I led feature development for BeautyMnl’s e-commerce app, working with different departments to take features from idea to launch.

                    My biggest contribution was rebuilding the app from the ground up for the company’s rebranding, introducing MVVM with Kotlin Coroutines and Retrofit for a more maintainable codebase. I launched features that increased conversions, improved the user experience, and added new payment methods. I also replaced a 20–30-minute manual deployment with a Bitrise CI/CD pipeline and started the team’s unit testing practice.
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
                    I progressed from R&D Engineer to Team Technical Lead in under two years, serving as the team’s point person for technical specifications and its primary code reviewer.

                    I led the introduction of data traffic features in a 5G network component simulator, enabling system demos of Nokia’s main product, and led the initial virtualization of multiple network component simulators for future development setups.
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
                    I competed in and won several hackathons as a front-end designer, programmer, and presenter, and served as Marketing Head of the Association for Computing Machinery, UP Diliman Student Chapter.
                """.trimIndent()
            )
        }
    }
}

@Composable
fun ProjectsDetailsSections(modifier: Modifier = Modifier, style: Style = Style) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.getColumnVerticalSpacing(
                LocalCompact.current
            )
        )
    ) {
        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Wais: Budget Tracker App",
            image = null,
            tags = listOf(
                "Android",
                "iOS",
                "Kotlin Multiplatform",
                "Jetpack Compose",
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
            ),
            link = "https://github.com/jolotan416/WaisPublic"
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                Wais is a Kotlin Multiplatform app that simplifies financial organization, especially for (but not limited to) Filipinos. It supports multiple profiles, automatic exchange rates, savings goals, budget allocations, and cash flow tracking in one easy-to-use app.

                It's offline-first, persisting user data and Ktor-fetched exchange rates with Room and DataStore, and ships to both the Google Play Store and Apple App Store with Firebase analytics and crash tracking.
                """.trimIndent()
            )
            ImageRow(
                modifier = Modifier.fillMaxWidth(),
                images = listOf(
                    Res.drawable.wais_screenshot_dashboard,
                    Res.drawable.wais_screenshot_savings,
                    Res.drawable.wais_screenshot_budget,
                    Res.drawable.wais_screenshot_cashflow,
                    Res.drawable.wais_screenshot_accounts,
                    Res.drawable.wais_screenshot_transactions,
                )
            )
        }

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "BMW Panoramic iDrive Telematics Apps",
            image = null,
            tags = listOf(
                "Android",
                "Jetpack Compose",
                "Unidirectional Data Flow Architecture",
                "MVVM",
                "Hilt",
                "Retrofit",
                "Room Database",
                "Coroutines and Flows",
                "DataStore",
                "Coil"
            ),
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = """
                At Paradox Cat, I refactored several BMW Telematics apps to support the technical and visual redesign for the BMW Neue Klasse, migrating their UIs to Jetpack Compose. I also restructured the codebase to be more flexible between ECU variants and backend connections.
                """.trimIndent()
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(
                        horizontal = AppTheme.dimensions.getInternalContainerPadding(
                            LocalCompact.current
                        )
                    )
                    .clip(AppTheme.shapes.extraLarge)
                    .clickable(onClick = { uriHandler.openUri("https://www.youtube.com/watch?v=2sbGe6ELVpo") }),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth()
                        .aspectRatio(16f / 9f),
                    model = "https://img.youtube.com/vi/2sbGe6ELVpo/maxresdefault.jpg",
                    contentDescription = null
                )
                CustomButton(
                    leftIcon = Icons.Default.PlayArrow,
                    onButtonClick = { uriHandler.openUri("https://www.youtube.com/watch?v=2sbGe6ELVpo") })
            }
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle() then Style {
                    fontStyle(FontStyle.Italic)
                    textAlign(TextAlign.Center)
                },
                text = "BMW’s “Developing the BMW Panoramic iDrive” video, about the platform I built Telematics apps for. My apps aren’t shown.".trimIndent()
            )
        }

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "BeautyMnl",
            image = null,
            tags = listOf(
                "Android",
                "XML (DataBinding)",
                "MVVM",
                "LiveData",
                "Hilt",
                "Retrofit",
                "Coroutines",
                "Room",
                "RESTful API Design",
                "Glide"
            ),
        ) {
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle(),
                text = "BeautyMnl was the #1 homegrown e-commerce brand in the Philippines, and was where I began my career as an Android developer. I joined a two-person Android team during the app’s rebranding, and later became the sole developer responsible for building major new features. The app included a backend-driven homepage that could be reconfigured without an app update, product listing and browsing pages, customer reviews, a checkout workflow, and a loyalty rewards program."
            )
            ImageRow(
                modifier = Modifier.fillMaxWidth(),
                images = listOf(
                    Res.drawable.beautymnl_screenshot_0,
                    Res.drawable.beautymnl_screenshot_1,
                    Res.drawable.beautymnl_screenshot_2,
                    Res.drawable.beautymnl_screenshot_3,
                    Res.drawable.beautymnl_screenshot_4,
                    Res.drawable.beautymnl_screenshot_5,
                    Res.drawable.beautymnl_screenshot_6,
                    Res.drawable.beautymnl_screenshot_7,
                    Res.drawable.beautymnl_screenshot_8,
                    Res.drawable.beautymnl_screenshot_9,
                )
            )
            StyledText(
                modifier = Modifier.fillMaxWidth(),
                style = SectionTextStyle() then Style {
                    fontStyle(FontStyle.Italic)
                    textAlign(TextAlign.Center)
                },
                text = "Screenshots from BeautyMnl's former Play Store listing".trimIndent()
            )
        }

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Personal Website",
            description = "The site you're browsing, built with Kotlin Multiplatform and deployed on Firebase Hosting.",
            image = Res.drawable.favicon,
            tags = listOf(
                "Kotlin Multiplatform",
                "Jetpack Compose",
                "Styles API",
                "Firebase Hosting",
            ),
            link = "https://github.com/jolotan416/PersonalWebsite"
        )

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Unraid App Project",
            description = "My first Kotlin Multiplatform project, connecting to Unraid NAS servers through their GraphQL API.",
            image = Res.drawable.github,
            tags = listOf(
                "Kotlin Multiplatform",
                "Jetpack Compose",
                "Unidirectional Data Flow Architecture",
                "MVVM",
                "Koin",
                "Ktor",
                "Room Database",
                "Coroutines and Flows",
                "Coil",
            ),
            link = "https://github.com/jolotan416/UnraidAppProject"
        )

        ProjectsDetailsSection(
            modifier = Modifier.fillMaxWidth(),
            title = "Spotlight: To-do List App",
            description = "My first Android app built from scratch, designed to help users focus on one task at a time.",
            image = Res.drawable.spotlight,
            tags = listOf(
                "Android",
                "Jetpack Compose",
                "Fragments",
                "MVVM with LiveData",
                "Unidirectional Data Flow Architecture",
                "Room Database",
                "Coroutines and Flows",
                "Hilt",
                "WorkManager"
            ),
            link = "https://github.com/jolotan416/spotlight-app"
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
    link: String? = null,
    tags: List<String>
) {
    ProjectsDetailsSection(
        modifier = modifier,
        style = style,
        title = title,
        image = image,
        tags = tags,
        link = link
    ) {
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            style = SectionTextStyle(),
            text = description
        )
    }
}

@Composable
fun ProjectsDetailsSection(
    modifier: Modifier = Modifier,
    style: Style = Style,
    title: String,
    image: DrawableResource?,
    tags: List<String>,
    link: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val uriHandler = LocalUriHandler.current
    DetailsSection(
        modifier = modifier.styleable(style = style),
        title = title
    ) {
        if (LocalCompact.current) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    AppTheme.dimensions.getColumnVerticalSpacing(
                        LocalCompact.current
                    )
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                image?.let {
                    Image(
                        modifier = Modifier.size(AppTheme.dimensions.compactImageWidth),
                        painter = painterResource(it),
                        contentDescription = null
                    )
                }
                content()
                TagsList(modifier = Modifier.fillMaxWidth(), tags = tags)
                link.takeIf { !it.isNullOrBlank() }
                    ?.let {
                        TextButton(onClick = {
                            uriHandler.openUri(it)
                        }) {
                            StyledText(
                                modifier = Modifier.fillMaxWidth(),
                                style = SectionTextStyle(),
                                text = "Explore on Github >"
                            )
                        }
                    }
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
                    verticalArrangement = Arrangement.spacedBy(
                        AppTheme.dimensions.getColumnVerticalSpacing(
                            LocalCompact.current
                        )
                    )
                ) {
                    content()
                    TagsList(modifier = Modifier.fillMaxWidth(), tags = tags)
                    link.takeIf { !it.isNullOrBlank() }
                        ?.let {
                            TextButton(onClick = {
                                uriHandler.openUri(it)
                            }) {
                                StyledText(
                                    style = SectionTextStyle() then Style {
                                        contentColor(colors.primary)
                                    },
                                    text = "Explore on Github >"
                                )
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun TagsList(modifier: Modifier = Modifier, tags: List<String>) {
    FlowRow(
        modifier = modifier,
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
    val isCompact = LocalCompact.current
    Column(
        modifier = modifier.styleable(
            style = style then AppTheme.styles.container.getStyleSection(isCompact)
        ),
        verticalArrangement = Arrangement.spacedBy(
            AppTheme.dimensions.getColumnVerticalSpacing(
                isCompact
            )
        ),
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