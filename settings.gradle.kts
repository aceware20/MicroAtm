pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url=uri ("https://jitpack.io")
            url=uri ("https://maven.google.com/")
        }

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        maven ("https://jitpack.io")
        maven {
            url=uri ("https://jitpack.io")
            url=uri ("https://maven.google.com/")
        }
    }

}



rootProject.name = "MicroAtm"
include(":app")
include(":mylibrary")
include (":acemicroatm-release")
