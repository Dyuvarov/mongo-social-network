rootProject.name = "mongo-social-network"
include("mongock-migration")
include("socialnetwork")

plugins {
    val kotlinVersion = "1.9.25"
    kotlin("jvm") version kotlinVersion apply false
}
