# KMP/CMP News App

<div align="center">
  <img src="screenshots/android_ss_1.png" alt="News App" width="200"/>
</div>

## 📱 Project Description

This is a modern [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) news application that demonstrates the power of shared code across multiple platforms. Built with 100% Compose UI, this app delivers a consistent and beautiful user experience across:

- 📱 **Android** - Native Android application
- 🍎 **iOS** - Native iOS application  
- 🖥️ **Desktop** - Cross-platform desktop application
- 🌐 **Web (WebAssembly)** - Modern web application

## ✨ Features

- 📰 **Browse News Categories** - Explore news across multiple categories including National, Business, Sports, Technology, and more
- 🔄 **Real-time News Updates** - Fetch latest news articles from reliable sources
- 📱 **Responsive Design** - Adaptive UI that works seamlessly across different screen sizes
- 🎨 **Material Design 3** - Modern and intuitive user interface
- 🌙 **Dark/Light Theme Support** - Automatic theme switching based on system preferences
- ⚡ **Fast Performance** - Optimized for smooth scrolling and quick loading
- 🔗 **Deep Linking** - Navigate directly to specific news categories
- 📸 **Image Loading** - Efficient image loading with caching support

## 🏗️ Architecture

### Project Structure

- **`/composeApp`** - Shared code across all platforms
  - **`commonMain`** - Common code for all targets
  - **`androidMain`** - Android-specific implementations
  - **`iosMain`** - iOS-specific implementations
  - **`desktopMain`** - Desktop-specific implementations
  - **`wasmJsMain`** - Web-specific implementations
- **`/iosApp`** - iOS application entry point and SwiftUI integration

### Key Components

- **MVVM Architecture** - Clean separation of concerns with ViewModels
- **Repository Pattern** - Centralized data management
- **Dependency Injection** - Koin for clean dependency management
- **Navigation** - Type-safe navigation with Compose Navigation
- **State Management** - Reactive UI with StateFlow and Compose State

## 🛠️ Technology Stack

### Core Technologies
- **[Kotlin](https://kotlinlang.org/)** - Primary programming language
- **[Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)** - Code sharing across platforms
- **[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform)** - Declarative UI framework

### UI & Navigation
- **[Material Design 3](https://m3.material.io/)** - Modern design system
- **[Compose Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html#sample-project)** - Type-safe navigation
- **[Window Size Class](https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes)** - Responsive design support

### Networking & Data
- **[Ktor Client](https://ktor.io/)** - HTTP client for API communication
- **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)** - JSON serialization
- **[InShorts API](https://github.com/cyberboysumanjay/Inshorts-News-API)** - News data source

### Architecture & DI
- **[ViewModel](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)** - Lifecycle-aware UI state management
- **[Koin](https://insert-koin.io/)** - Dependency injection framework
- **[Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines)** - Asynchronous programming

### Image Loading & Utilities
- **[Coil](https://coil-kt.github.io/coil/)** - Image loading library
- **[Ktlint](https://ktlint.github.io/)** - Code formatting and style enforcement

## 🚀 Getting Started

### Prerequisites

- **JDK 11** or higher
- **Android Studio** (for Android development)
- **Xcode** (for iOS development, macOS only)
- **IntelliJ IDEA** or **Android Studio** (for desktop development)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/CMP-News-App.git
   cd CMP-News-App
   ```

2. **Open the project**
   - Open the project in Android Studio or IntelliJ IDEA
   - Wait for Gradle sync to complete

### Running the Application

#### Android
```bash
./gradlew :composeApp:installDebug
```
Or run directly from Android Studio

#### iOS
1. Open `iosApp/iosApp.xcodeproj` in Xcode
2. Select your target device/simulator
3. Press Run (⌘+R)

#### Desktop
```bash
./gradlew :composeApp:run
```

#### Web (WebAssembly)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```
The web application will be available at `http://localhost:8080`

## 📖 Usage

### Basic Navigation

1. **Browse Categories** - Launch the app to see available news categories
2. **Select Category** - Tap on any category to view related news articles
3. **Read Articles** - Scroll through the list of articles with images and summaries
4. **Navigate Back** - Use the back button to return to categories

### API Integration

The app uses the [Unofficial InShorts News API](https://github.com/cyberboysumanjay/Inshorts-News-API) to fetch news data:

```kotlin
// Example API call
val response = repository.getCategoryNews("technology")
```

Available categories:
- `all` - All news
- `national` - National news
- `business` - Business news
- `sports` - Sports news
- `world` - World news
- `politics` - Political news
- `technology` - Technology news
- `startup` - Startup news
- `entertainment` - Entertainment news
- `science` - Science news
- `automobile` - Automobile news

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./gradlew test

# Run Android tests
./gradlew :composeApp:testDebugUnitTest

# Run common tests
./gradlew :composeApp:testDebugUnitTest
```

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Make your changes**
   - Follow the existing code style
   - Add tests for new functionality
   - Update documentation as needed
4. **Run code formatting**
   ```bash
   ./gradlew ktlintFormat
   ```
5. **Commit your changes**
   ```bash
   git commit -m 'Add some amazing feature'
   ```
6. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
7. **Open a Pull Request**

### Code Style

- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Add KDoc comments for public APIs
- Ensure all tests pass before submitting

## 📱 Screenshots

### Android

|                                   |                                   |
|:---------------------------------:|:---------------------------------:|
| ![](screenshots/android_ss_1.png) | ![](screenshots/android_ss_2.png) |

### iOS

|                               |                               |
|:-----------------------------:|:-----------------------------:|
| ![](screenshots/ios_ss_1.png) | ![](screenshots/ios_ss_2.png) |

### Desktop

|                                   |                                   |
|:---------------------------------:|:---------------------------------:|
| ![](screenshots/desktop_ss_1.png) | ![](screenshots/desktop_ss_2.png) |

### Web

|                               |                               |
|:-----------------------------:|:-----------------------------:|
| ![](screenshots/web_ss_1.png) | ![](screenshots/web_ss_2.png) |

## 🔧 Configuration

### API Configuration

The app uses the InShorts API endpoint configured in `di/Koin.kt`:

```kotlin
single<NewsApi> { NewsNetworkApi(get(), baseUrl = "https://inshortsapi.vercel.app") }
```

### Build Configuration

Key build configurations can be found in:
- `composeApp/build.gradle.kts` - Main build configuration
- `gradle/libs.versions.toml` - Dependency versions
- `gradle.properties` - Project properties

## 🚀 Deployment

### Android
1. Generate signed APK/AAB through Android Studio
2. Upload to Google Play Console

### iOS
1. Archive the project in Xcode
2. Upload to App Store Connect

### Desktop
1. Build distribution package:
   ```bash
   ./gradlew :composeApp:packageDistributionForCurrentOS
   ```

### Web
1. Build for production:
   ```bash
   ./gradlew :composeApp:wasmJsBrowserDistribution
   ```
2. Deploy the generated files from `build/dist/wasmJs/productionExecutable/`

## 📄 License

```
Designed and developed by Muaz KADAN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 👨‍💻 Author

**Muaz KADAN**
- LinkedIn: [Muaz Kadan](https://www.linkedin.com/in/muaz-kadan-727911107/)

## 🙏 Acknowledgments

- [JetBrains](https://www.jetbrains.com/) for Kotlin Multiplatform and Compose Multiplatform
- [InShorts API](https://github.com/cyberboysumanjay/Inshorts-News-API) for providing the news data
- The Kotlin and Compose communities for their excellent documentation and support

---

<div align="center">
  Made with ❤️ using Kotlin Multiplatform
</div>