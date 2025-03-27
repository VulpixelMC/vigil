import gay.sylv.vigil.gradle.Properties

plugins {
	id("conventions.common")
}

configurations {
	register("commonJava") {
		isCanBeResolved = true
	}
	register("commonClientJava") {
		isCanBeResolved = true
	}
	register("commonResources") {
		isCanBeResolved = true
	}
	register("commonClientResources") {
		isCanBeResolved = true
	}
	register("commonTestResources") {
		isCanBeResolved = true
	}
}

dependencies {
	compileOnly(project(":common")) {
		capabilities {
			requireCapability("$group:${Properties.MOD_ID}")
		}
	}
	"commonJava"(project(":common", "commonJava"))
	"commonClientJava"(project(":common", "commonClientJava"))
	"commonResources"(project(":common", "commonResources"))
	"commonClientResources"(project(":common", "commonClientResources"))
	"commonTestResources"(project(":common", "commonTestResources"))
}

tasks {
	named<JavaCompile>("compileJava").configure {
		dependsOn(configurations.getByName("commonJava"))
		source(configurations.getByName("commonJava"))
		dependsOn(configurations.getByName("commonClientJava"))
		source(configurations.getByName("commonClientJava"))
	}
	named<ProcessResources>("processResources").configure {
		dependsOn(configurations.getByName("commonResources"))
		from(configurations.getByName("commonResources"))
		from(configurations.getByName("commonResources"))
		dependsOn(configurations.getByName("commonClientResources"))
		from(configurations.getByName("commonClientResources"))
		from(configurations.getByName("commonClientResources"))
	}
	named<ProcessResources>("processTestResources").configure {
		dependsOn(configurations.getByName("commonTestResources"))
		from(configurations.getByName("commonTestResources"))
		from(configurations.getByName("commonTestResources"))
	}
	named<Javadoc>("javadoc").configure {
		dependsOn(configurations.getByName("commonJava"))
		source(configurations.getByName("commonJava"))
		dependsOn(configurations.getByName("commonClientJava"))
		source(configurations.getByName("commonClientJava"))
	}
	named<Jar>("sourcesJar").configure {
		dependsOn(configurations.getByName("commonJava"))
		from(configurations.getByName("commonJava"))
		dependsOn(configurations.getByName("commonClientJava"))
		from(configurations.getByName("commonClientJava"))
		dependsOn(configurations.getByName("commonResources"))
		from(configurations.getByName("commonResources"))
		dependsOn(configurations.getByName("commonClientResources"))
		from(configurations.getByName("commonClientResources"))
	}
}
