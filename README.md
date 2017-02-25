# Pre-work - *SimpleToDo*

**SimpleToDo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Anant Aneja**

Time spent: **18** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [x] Add support for completion due dates for todo items (and display within listview item)
* [x] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) for setting/editng a due date using a custom `DatePickerFragment`
* [x] Use gson to persist complex types
* [x] Tweak the style improving the UI / UX, play with colors, images or backgrounds
* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/3dj5HCj.gif' title='Video Walkthrough on a real device' width='' alt='Video Walkthrough' />

GIF created with [FFmpeg](https://ffmpeg.zeranoe.com/builds/).

## Notes

#### Environment setup related:

 * I wanted to develop in Linux exclusively. Setting u up a Ubunutu Hyper-V VM + Windows X server install + Android Studio took a non-trivial amount of time! It seems to be worth the effort though, no PATH related foo-bars!
 * For testing/debugging: Hyper-V does not passthrough processor virt features to guest OS'es; so Android Studio complained about not having support to setup a fast emulator. I ended up using a real Android device + using ADB over the network (ADB over network support is pretty cool!)

## License

    Copyright [2017] [Anant Aneja]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.