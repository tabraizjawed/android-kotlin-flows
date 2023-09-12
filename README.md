

# Learn Kotlin Flow by real examples for Android

## About this project:

* This project is for someone who wants to get started with Kotlin Flow.
* I have tried to add the examples we implement in our Android project frequently.


## You will learn the following from this Learn Kotlin Flow project:

* How to use Kotlin Flow in Android Project?
* Doing simple task in background using Kotlin Flow.
* Doing tasks in series using Kotlin Flow.
* Doing tasks in parallel using Kotlin Flow. 
* Making two network calls in parallel using Kotlin Flow.
* Using operators like filter, map, reduce, flatMapConcat, zip, and etc.
* Exception handling in Kotlin Flow
* How to use onCompletion in Flow?
* Retry Task using retry operator in Flow.
* Retry Task with Exponential Backoff in Flow. 
* Using Kotlin Flow with Retrofit. 
* Using Kotlin Flow with Room
  Database. 
* Using Kotlin Flow with various 3rd party libraries.
* Making two network calls in parallel using Kotlin Flow.
* Doing task in series using Kotlin Flow.
* Writing Unit-Test for ViewModel which uses Kotlin Flow. 

## Kotlin Flow Examples for Android Development: Activity and ViewModel

* **Single Network Call:** Learn how to make a network call using Kotlin Flow. This is a very simple
  use-case in Android App Development.

    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallViewModel.kt)

* **Series Network Calls:** Learn how to make network calls in series using Kotlin Flow. This is
  useful when you want to make a network call which is dependent on an another network call.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/series/SeriesNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/series/SeriesNetworkCallsViewModel.kt)

* **Parallel Network Calls:** Learn how to make network calls in parallel using Kotlin Flow. This is
  useful when you want to make network calls in parallel which are independent of each other.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/parallel/ParallelNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/parallel/ParallelNetworkCallsViewModel.kt)

* **Room Database Operation:** Learn how to fetch or insert entity in database using Kotlin Flow.
  This is useful when you are using Room Database in your Android Application.

    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/room/RoomDBActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/room/RoomDBViewModel.kt)

* **Long Running Task:** Learn how to run a long running task using Kotlin Flow. If you want to do
  any of your task in background thread using the Kotlin Flow, then this is useful.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/task/onetask/LongRunningTaskActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/task/onetask/LongRunningTaskViewModel.kt)

* **Two Long Running Tasks:** Learn how to run two long running tasks in parallel using Kotlin Flow. Blog: [Long-running tasks in parallel with Kotlin Flow](https://amitshekhar.me/blog/long-running-tasks-in-parallel-with-kotlin-flow)
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/task/twotasks/TwoLongRunningTasksActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/task/twotasks/TwoLongRunningTasksViewModel.kt)

* **Catch Error Handling:** Learn how to handle error in Kotlin Flow using Catch.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/errorhandling/catch/CatchActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/errorhandling/catch/CatchViewModel.kt)

* **EmitAll Error Handling:** Learn how to handle error in Kotlin Flow using emitAll.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/errorhandling/emitall/EmitAllActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/errorhandling/emitall/EmitAllViewModel.kt)

* **Completion:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/completion/CompletionActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/completion/CompletionViewModel.kt)

* **Reduce:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/reduce/ReduceActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/reduce/ReduceViewModel.kt)

* **Map:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/map/MapActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/map/MapViewModel.kt)

* **Filter:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/filter/FilterActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/filter/FilterViewModel.kt)

* **Search Feature:** Implement Search Using Kotlin Flow Operators - Debounce, Filter,
  DistinctUntilChanged, FlatMapLatest.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/search/SearchActivity.kt)

* **Retry:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retry/RetryActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retry/RetryViewModel.kt)

* **RetryWhen:** 
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrywhen/RetryWhenActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retrywhen/RetryWhenViewModel.kt)

* **Retry with Exponential Backoff:**
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/flow/ui/retryexponentialbackoff/RetryExponentialBackoffModel.kt)

* **Unit Test:** Learn how write unit-test for ViewModel which uses Kotlin Flow.
    * [ViewModelTest Code](app/src/test/java/me/tabraiz/learn/kotlin/flow/ui/retrofit/single/SingleNetworkCallViewModelTest.kt)

## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:

### License

```
   Copyright (C) 2023 Tabraiz Jawed

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

