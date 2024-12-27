// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "Y",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "Y",
            targets: ["ImageCropperPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "ImageCropperPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/ImageCropperPlugin"),
        .testTarget(
            name: "ImageCropperPluginTests",
            dependencies: ["ImageCropperPlugin"],
            path: "ios/Tests/ImageCropperPluginTests")
    ]
)