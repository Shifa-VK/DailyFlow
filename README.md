# DailyFlow

DailyFlow is a simple task management Android app that I built to practice and demonstrate modern Android development with Kotlin and Jetpack Compose.

The idea behind the app is straightforward: quickly add tasks, give them a priority, keep track of completed work, and search through the task list. Tasks are stored locally, so they are still available when the app is opened again.

## What the app can do

- Add a task with a title and priority
- Choose Low, Medium, or High priority
- Mark a task as completed
- Delete a task
- Search tasks by title
- Save tasks locally using Room Database
- Show a clean empty state when there are no tasks

## Technologies used

- **Kotlin** – application development
- **Jetpack Compose** – UI
- **Material 3** – UI components
- **MVVM** – presentation architecture
- **Room Database** – local data storage
- **Hilt** – dependency injection
- **Kotlin Coroutines** – background work
- **Flow / StateFlow** – observing and managing UI state

## Project structure

The project is separated into different layers so that the UI, business logic, and data handling are not tightly coupled.

## How it works

When a task is added, the ViewModel sends it to the repository. The repository uses Room to save it in the local database.

Room exposes the task list as a `Flow`, which is observed by the ViewModel. When the database changes, the UI automatically receives the updated list.

For example:

Compose UI
↓
HomeViewModel
↓
TaskRepository
↓
TaskDao
↓
Room Database

Hilt is used to provide the database, DAO, and repository to the classes that need them.

### Requirements

- Android Studio
- JDK 11 or higher
- Android SDK 36
- Android emulator or physical Android device

### Run the project

Clone the repository:

git clone https://github.com/YOUR_USERNAME/DailyFlow.git

Open the project in Android Studio and let Gradle sync.

Then select an emulator or connected Android device and click **Run**.

## Screenshot
<img width="1080" height="2400" alt="Screenshot_20260919_001713" src="https://github.com/user-attachments/assets/a5407401-5343-464d-862c-980e289b810b" />


<img width="1080" height="2400" alt="Screenshot_20260919_001731" src="https://github.com/user-attachments/assets/2509f1f2-e040-477e-a203-06adff081773" />

<img width="1080" height="2400" alt="Screenshot_20260919_001747" src="https://github.com/user-attachments/assets/cd081a18-6dc8-47be-90d5-4dcd80fa72a6" />



<img width="1080" height="2400" alt="Screenshot_20260918_233925" src="https://github.com/user-attachments/assets/58a4da70-eb0d-4ed4-a326-dc3f474be25a" />



## What I learned from this project

This project helped me practice building an Android application from the ground up using a modern Android stack. In particular, I worked with Compose UI, Room persistence, Hilt dependency injection, Coroutines, Flow, and ViewModel-based state management.

I also used this project to keep the code separated into data, domain, and presentation responsibilities instead of putting the application logic directly inside the activity.

## Future improvements

Some features I would like to add later:

- Edit existing tasks
- Due dates and reminders
- Task categories
- Sorting and filtering
- Notifications
- More UI tests
- Dark theme improvements
- Cloud synchronization

## Author

**Shifa VK**

Android Developer | Kotlin | Jetpack Compose
