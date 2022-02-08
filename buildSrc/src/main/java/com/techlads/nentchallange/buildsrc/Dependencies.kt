/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techlads.nentchallange.buildsrc

import com.techlads.nentchallange.buildsrc.Versions.kotlin_version

object Versions {
    const val ktLint = "0.41.0"
    const val compose = "1.2.0-alpha01"
    const val kotlin_version = "1.6.10"
    const val moshi = "1.13.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val room = "2.3.0"
}

object AndroidApp {
    const val applicationId = "com.techlads.nentchallange"
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = compileSdk
    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "com.techlads.nentchallange.HiltTestRunner"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshi_adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val okhttp_bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor"

    object Accompanist {
        const val version = "0.22.0-rc"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlin_version}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${kotlin_version}"

        object Coroutines {
            private const val version = "1.5.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        }

        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val core_ktx = "androidx.core:core-ktx:1.7.0"
        const val splash = "androidx.core:core-splashscreen:1.0.0-beta01"

        const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
        const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
        const val room_compiler = "androidx.room:room-compiler:${Versions.room}"

        const val navigation = "androidx.navigation:navigation-compose:2.4.0-rc01"

        object Compose {
            const val snapshot = ""

            const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val runtimeLivedata =
                "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
            const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val animation = "androidx.compose.animation:animation:${Versions.compose}"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        }

        object Lifecycle {
            private const val version = "2.4.0"
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Test {
            private const val version = "1.3.0"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.3"
                const val junit_ktx = "androidx.test.ext:junit-ktx:$version"
                const val junit = "androidx.test.ext:junit:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        }
    }

    object Hilt {
        private const val version = "2.38.1"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val testing_compiler = "com.google.dagger:hilt-android-compiler:$version"

        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0-rc01"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object Test {
        const val truth = "com.google.truth:truth:1.1"
    }
}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo = "https://androidx.dev/snapshots/builds/" +
            "${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}
