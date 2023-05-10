package com.uladzislau_pravalenak.authorization.internal

import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

internal val Project.libs
	get() = the<LibrariesForLibs>()

internal val Project.libraryExtensions
	get() = the<LibraryExtension>()