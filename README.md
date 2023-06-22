[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)

# 3500 PA05 Project Repo

#[NOTES ABOUT GIT BUILD & MISSING MODULE-INFO.JAVA FILE]
- The git build is not building because of the JavaFX GUI Testing, however, we have spoken to
  Dr. Fontenot about this, and he said it was okay. We also have getters in our controller for
  our dialogs and asked if it was okay for the sake of JavaFX GUI testing and for future extension
  purposes, and he also said it was okay in-person. Dr. Fontenot pulled from our repository and made sure
  that the GUI testing worked on his end as well. Screenshot could be found in root directory named as
  "Message_With_Professor.png"
- PS - we confirmed with Dr Fontenot that complete 80% test coverage in branched is not 
required to receive extra credit points since gui testing is still fully functional. 

- Jackson Binding was not working with Module-Info.java, which is why we deleted it. The terminal
  may produce a message "loading from unnamed module" when running the program, but we also confirmed with
  Dr.Fontenot that it is okay.

#[PASSWORD FOR BUJO]
password: i love javadocs
(all lowercase)

#[SCREENSHOT SHOWCASING]
in root directory named GUI_showcase.png

#[LIST OF COMMANDS]
- Command/Control + E: opens dialog for creating a new Event
- Command/Control + T: opens dialog for creating a new Task
- Command/Control + S: saves the file
- Command/Control + O: opens the finder on your computer for you to choose a .bujo file to open
- Command/Control + 1: opens dialog for creating a new Note
- Command/Control + 2: opens dialog for creating a new Quote
- Command/Control + 3: opens dialog for configuring the week
- Command/Control + 4: opens dialog for creating a new week
- Command/Control + 5: change the starting day of the week to Tuesday
- Command/Control + 6: creating a default event
- Command/Control + 7: creating a default task 

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)



#[BUJO PITCH]
Welcome to your very own, easy to use, digital Bujo Journal! 
With many detailed features to edit week names, create new events and tasks, as well as write in your own notes and 
quotes, this product will serve as a handy organizational tool for any student. Beyond basic weekly planner 
functionalities, our Bullet Journal also comes with additional features including keyboard shortcuts to access all of 
your favorite menu bar buttons as well as a detailed view for each task and event that will appear when that task/event 
is clicked on. Not to mention, all of your weekly journal information will remain password protected at all times 
for added privacy! 
Thank you for using our product. Please refer to our description below for details on each of our features, enjoy!

#[List of Features:]
## Section 1: Requirements
- Week View: You can see all of your tasks, events, and week details across one calendar week.
- Event/Task Creation: Please click the Add... button and select either event or task
from the drop down menu to start creating your own new event or task. For either item,
including a description is optional but all other information is required for an event or
task to be created. 
- Commitment Warnings - if you do not enter all required information when creating an 
event, task or another bujo element, then a commitment warning will pop up on the screen.
In this case, please close the warning popup and try again.
- Persistence - when this bujo journal is first run, a default blank week configuration
will be created for you. In order to open a previously made week file, please click on the
Open button on the menu bar and then select your file from the popup. Similarly, to save
any changes you make to your current bujo, click the Save button and your changes will
- be updated in your bujo file when you close the bujo application. 

## Section 2: Headlining Features
- Task Queue: To the right of your screen, you'll see the column titled
task queue. This column will contain an exhaustive list of all tasks in 
the week that you can scroll through. 
- Menu Bar and Shortcuts: For your convenience, we've added all out buttons to edit your 
week in a Menu Bar at the top of the screen. Additionally, these features can be accessed
using keyboard shortcuts in place of these buttons. (FILL IN SHORTCUTS HERE)

## Section 3: Power-ups
- Quotes and Notes: Our journal features additional sections at the bottom of the screen
to add any quotes or general notes you'd like to store on your bujo. Please click the Add
button on menu bar to reveal a drop down menu. On this menu, click the Notes option to
trigger a dialog to create a new Note. Click the Quote option in the drop down menu to add 
a Quote.
- Mini Viewer: To view the complete name, description, and details of a given Event or Task
in your Bujo, simply click on that Event or Task in the Week View. A large popup will
appear, displaying your Event or Task in greater detail.
- Takesie Backsies: This bujo also includes functionality to delete any tasks or events
you've added to your journal. To access this delete feature, simply click on a given task
or event in week view to open that event/task's mini viewer. Now press the delete button
for that task/event that is visible in the bottom right corner of the mini viewer display.
Deleting a task from your week view will also remove the item from your task queue.

## Section 4: 
- Week Start: If the user would like to change the day that their week starts with, they can simply 
click the configure week button in the menu bar, and select the desired day from the dropdown choice box.
After clicking confirm, the weekly view will be updated to reflect what the user has chosen. Note that the
user doesn't have to change any other configuration for the week to change Week Start Day
- Links: If the user entered any valid, openable links in the description for task/event, when they open
the mini viewer for the respective task/event, they will see a list of links at the bottom of the mini viewer,
for which they can click on and the journal will open the clicked link. 

## Section 5:
- Splash Screen: When the bujo application is first launched, a splash screen will appear
before the actual bujo and week view is displayed. You'll need to enter the correct 
password to disable the splash screen and reveal your week view(password: i love javadocs).
- Privacy Locks: This bujo is password protected. You'll be prompted for your password
in the splash screen when the application is launched. The password is stored in, and 
can be edited by the user in their .bujo file. 
- Tested GUI: Our GUI and JavaFx compoments have been tested. 
- Visual Flourish: Our journal follows a calming theme color of lavender throughout its
elements. We keep to a consistent, visually appealing, text formatting and text styles.
- Our buttons including white shading that complements the lavender backdrop, 
highlighting the buttons functionality without drawing too much attention away from the 
rest of the journal elements and week view. 


#[Extending our Program]
If we were to extend our program to implement another feature, we can easily achieve that due to the flexibility 
of our program. For example, if we were to implement Sort by Name or Duration, we could either add a button to 
the menu bar or add it to our Config Week dialog section since we are configuring the set up of the weekly view. 
By adding the sort by name or duration option to our config week dialog, we will make it so such that like every 
other feature on the config week dialog, the user are able to change the only sort without changing other fields 
such as Week Name. We would then use an Enum class that implements the Comparator interface to hold two Enum methods, 
compareTo by name or compareTo by Duration, and call either two of these methods in a Compare class that overrides 
the sort() method. Whenever the user wants the tasks/events to be sorted, we will sort the list of EventItem/TaskItems 
based on what the user has chosen, then we will call updatePage() to display the updated EventsView and TasksView 
since updatePage() is the method that is constantly updating the view of the Bujo Page to the user.

#[[SOLID Principles]]
- Single Responsibility:
    - Our code follows Single Responsibility because we made sure that each class only represent/hold
      one idea and the methods within each class are related and serve purpose to that one idea. In addition,
      we made sure that methods are also abstracted into smaller helper methods and those methods are responsible
      for one task. For example, in our AbstractItem class, we have a method to retrieve the valid links of an item’s
      description. We made sure to separate validating the retrieved links to a helper method called isValidLink()
      from our main method of getValidLinks().
- Open to Extension, Closed for Modification:
    - Our implementation follows the principle of open to extension and close for modification by
      having interfaces and abstract classes that have inheritable methods, which increases the
      flexibility of having different versions of the same functionality if needed later on. For example,
      our BujoPageImp shows a weekly bujopage, but if in the future the user would like a monthly bujo page,
      a new subclass can extend the BujoPage Interface and add functionality specific to the monthly page.
      As such, every method of BujoPage Interface would be needed for a larger scaled bujopage.
- Liskov’s Substitution Principles:
    - We followed Liskov’s Substitution Principles by making sure that no subclass of any superclass, when
      replacing our superclass, will break the functionality of the program. For example, in our model, we
      made sure that all methods of our Item interface are applicable to subclass that extends/implements it.
      We also made sure to have only public methods inherited from the superclass in all of our subclass.
- Interface Segregation
    - When we initially designed our model, we had our EventItem and TaskItem both extending AbstractItem,
      which extends the Item Interface, but TaskItem does not have some getters for EventItem and vice versa.
      To follow SOLID, we implemented the EventItemInterface and TaskItemInterface such that EventItem and TaskItem
      only inherits methods that are relevant to themselves.
- Delegate Inversion
    - As per the delegate inversion principles, we made sure that our controller, view, and model have
      their own interface such that whenever needed, we can pass in different versions of our controller,
      view, and model such that the code can be tested or reused. We also instantiated model, controller,
      and view appropriately passed them in as delegates via their respective constructors so that the functionality
      of each are seperated but are accessible when needed. For example, we passed in an instance of our model
      to our controller such that when the controller is handling an event, the controller can delegate
      responsibility to our model.


